package org.library.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.springframework.stereotype.Repository;

@Repository
public class TitleDao extends BaseDaoImpl<Title, String> {

  private Connection connection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  public TitleDao(){
    connection = connect();
  }

  @Override
  public Title getById(String id) {

    String titleType = null;
    String titleName = null;
    int titleId;
    Title title = null;

    String sql = "SELECT * " +
            "FROM title " +
            "WHERE title_id=?";

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      resultSet = preparedStatement.executeQuery();

      if(resultSet.next()) {
        titleId = resultSet.getInt("title_id");
        System.out.println("TITLE_ID = " + id);
        titleName = resultSet.getString("name");
        System.out.println("NAME = " + titleName);
        titleType = resultSet.getString("type");
        System.out.println("TYPE = " + titleType);
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

    try{
      if("BOOK".equals(titleType)){
        Title book = new Book(titleName, id);
        return book;
      } else {
        Title magazine = new Magazine(titleName, id);
        return magazine;
      }
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
      return null;
  }

  @Override
  public void add(Title title) {
    String sql = "INSERT INTO title (title_id, name, type) " +
            "VALUES (?,?,?)  ";
    try {
      preparedStatement = connection.prepareStatement(sql);
      String type = new String();
      try{
        if(title instanceof Book){
          type = "BOOK";
        } else {
          type = "MAGAZINE";
        }
      } catch (NullPointerException e){
        e.printStackTrace();
      }

      preparedStatement.setString(1, title.getId());
      preparedStatement.setString(2, title.getName());
      preparedStatement.setString(3, type);
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
    String sql = "DELETE FROM title " +
            "WHERE title_id=?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ""+id);
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
  public Title update(String id, Title updated) {
    String sql = "UPDATE title " +
            "SET title_id=? , name=? , type=? " +
            "WHERE title_id=?";

    try {
      preparedStatement = connection.prepareStatement(sql);
      String type = new String();
      try{
        if(updated instanceof Book){
          type = "BOOK";
        } else {
          type = "MAGAZINE";
        }
      } catch (NullPointerException e){
        e.printStackTrace();
      }

      preparedStatement.setString(1, updated.getId());
      preparedStatement.setString(2, updated.getName());
      preparedStatement.setString(3, type);
      preparedStatement.setString(4, id);

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
