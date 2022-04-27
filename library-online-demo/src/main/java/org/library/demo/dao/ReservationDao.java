package org.library.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.library.demo.models.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDao extends BaseDaoImpl<Reservation, Date> {

  private Connection connection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  public ReservationDao(){
    connection = connect();
  }

  @Override
  public Reservation getById(Date creationDate) {

    Reservation reservation = new Reservation();
    String sql = "SELECT * " +
            "FROM reservation " +
            "WHERE creation_date=?";

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,""+creationDate);
      resultSet = preparedStatement.executeQuery();
      if(resultSet.next()) {
        System.out.println("TITLE_ID = " + resultSet.getInt("title_id"));
        System.out.println("TAX_CODE = " + resultSet.getInt("tax_code"));
        System.out.println("CREATION_DATE = " + resultSet.getDate("creation_date"));
        reservation = new Reservation(new Date(resultSet.getDate("creation_date").getTime()), resultSet.getString("title_id"), resultSet.getString("tax_code"));
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

    return reservation;

  }

  @Override
  public void add(Reservation reservation) {
    String sql = "INSERT INTO reservation (title_id, tax_code, creation_date) " +
            "VALUES (?,?,?)  ";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ""+reservation.getTitleId());
      preparedStatement.setString(2, ""+reservation.getTaxCode());
      preparedStatement.setString(3, reservation.getCreationDate().toString());
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
    String sql = "DELETE FROM reservation " +
            "WHERE creation_date=?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ""+creationDate);
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
  public Reservation update(Date creationDate, Reservation updated) {
    String sql = "UPDATE reservation " +
            "SET title_id=? , tax_code=? , creation_date=? " +
            "WHERE creation_date=?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ""+updated.getTitleId());
      preparedStatement.setString(2, ""+updated.getTaxCode());
      preparedStatement.setString(3, updated.getCreationDate().toString());
      preparedStatement.setString(4, ""+creationDate);


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
