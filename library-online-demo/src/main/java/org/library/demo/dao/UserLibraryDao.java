package org.library.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.library.demo.models.*;
import org.springframework.stereotype.Repository;

@Repository
public class UserLibraryDao extends BaseDaoImpl<UserLibrary, String> {

  private Connection connection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  public UserLibraryDao(){
    connection = connect();
  }

  @Override
  public UserLibrary getById(String id) {

    UserLibrary userLibrary = null;
    String sql = "SELECT * " +
            "FROM user_library " +
            "WHERE tax_code=?";

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      resultSet = preparedStatement.executeQuery();
      String taxCode = null;
      String firstName = null;
      String lastName = null;

      if(resultSet.next()) {
        taxCode = resultSet.getString("tax_code");
        System.out.println("TAXCODE = " + taxCode);
        firstName = resultSet.getString("first_name");
        System.out.println("FIRST NAME = " + firstName);
        lastName = resultSet.getString("name");
        System.out.println("LAST NAME = " + lastName);
      }
      userLibrary = new UserLibrary(firstName, lastName, taxCode);
    } catch (SQLException e) {
      e.printStackTrace();
    }


    disconnect();
    try {
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userLibrary;

  }

  @Override
  public void add(UserLibrary userLibrary) {
    String sql = "INSERT INTO user_library (tax_code, first_name, last_name) " +
            "VALUES (?,?,?)  ";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, userLibrary.getTaxCode());
      preparedStatement.setString(2, userLibrary.getFirstName());
      preparedStatement.setString(3, userLibrary.getLastName());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    disconnect();
    try {
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(String id) {
    String sql = "DELETE FROM user_library " +
            "WHERE tax_code=?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    disconnect();
    try {
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public UserLibrary update(String id, UserLibrary updated) {
    String sql = "UPDATE user_library " +
            "SET tax_code=? , first_name =? , last_name=? " +
            "WHERE tax_code=?";

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ""+updated.getTaxCode());
      preparedStatement.setString(2, ""+updated.getFirstName());
      preparedStatement.setString(3, updated.getLastName());
      preparedStatement.setString(4, ""+id);

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    disconnect();
    try {
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }
}
