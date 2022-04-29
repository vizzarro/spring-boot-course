package org.library.demo.dao;

import java.sql.*;

import org.library.demo.models.Reservation;
import org.springframework.stereotype.Repository;
/*
@Repository
public class ReservationDaoImpl extends BaseDaoImpl<Reservation, Reservation> implements ReservationDao {

    @Override
    public Reservation get(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM RESERVATION WHERE TITLE_ID=? AND TAX_CODE=?");
        statement.setString(1, r.getTitleId());
        statement.setString(2, r.getTaxCode());
        ResultSet resultSet = statement.executeQuery();

        r = null;
        if(resultSet.next()) {
            r = new Reservation();
            r.setTitleId(resultSet.getString("title_id"));
            r.setTaxCode(resultSet.getString("tax_code"));
            r.setCreationDate(resultSet.getDate("creation_date"));
        }
        return r;
    }

    @Override
    public Reservation create(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO RESERVATION VALUES (?,?,?)");
        statement.setString(1, r.getTitleId());
        statement.setString(2, r.getTaxCode());
        statement.setDate(3, new java.sql.Date(r.getCreationDate().getTime()) );

        statement.executeUpdate();

        return r;
    }

    @Override
    public Reservation update(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE RESERVATION SET CREATION_DATE = ? WHERE TITLE_ID = ? AND TAX_CODE=?");
        statement.setDate(1, (Date) r.getCreationDate());
        statement.setString(2, r.getTitleId());
        statement.setString(3, r.getTaxCode());
        statement.executeUpdate();

        return r;
    }

    @Override
    public void delete(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM RESERVATION WHERE TITLE_ID = ? AND TAX_CODE = ?");
        statement.setString(1, r.getTitleId());
        statement.setString(2, r.getTaxCode());

        statement.executeUpdate();
    }
}*/
