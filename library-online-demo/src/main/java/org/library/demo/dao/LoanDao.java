package org.library.demo.dao;

import org.library.demo.models.Loan;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class LoanDao extends BaseDaoImpl<Loan, Date> {

  private Connection connection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  public LoanDao(){
    connection = connect();
  }

  @Override
  public Loan getById(Date creationDate) {

    String sql = "SELECT * " +
                 "FROM loans " +
                 "WHERE creation_date=?";

    Loan loan = new Loan();

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,""+creationDate);
      resultSet = preparedStatement.executeQuery();
      if(resultSet.next()) {
        System.out.println("TITLE_ID = " + resultSet.getInt("title_id"));
        System.out.println("TAX_CODE = " + resultSet.getInt("tax_code"));
        System.out.println("CREATION_DATE = " + resultSet.getDate("creation_date"));
        loan = new Loan(new Date(resultSet.getDate("creation_date").getTime()), resultSet.getString("title_id"), resultSet.getString("tax_code"));
      }
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
    if(loan != null){
      return loan;
    } else
    return null;
  }

  @Override
  public void add(Loan loan) {
    String sql = "INSERT INTO loans (title_id, tax_code, creation_date) " +
                 "VALUES (?,?,?)  ";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, loan.getTitleId());
      preparedStatement.setString(2, loan.getTaxCode());
      preparedStatement.setString(3, loan.getCreationDate().toString());
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
  public void delete(Date creationDate) {
    String sql = "DELETE FROM loans " +
                 "WHERE creation_date=?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, creationDate.toString());
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
  public Loan update(Date creationDate, Loan updated) {
    String sql = "UPDATE loans " +
                 "SET title_id=? , tax_code=? , creation_date=? " +
                 "WHERE creation_date=?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, updated.getTitleId());
      preparedStatement.setString(2, updated.getTaxCode());
      preparedStatement.setString(3, updated.getCreationDate().toString());
      preparedStatement.setString(4, creationDate.toString());


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

