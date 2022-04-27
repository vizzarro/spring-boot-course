package org.library.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.library.demo.models.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl extends BaseDaoImpl<Reservation, Reservation> implements ReservationDao {

    @Override
    public Reservation get(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM RESERVATION WHEN TITLE_ID=?, TAX_CODE=?");
        statement.setInt(1, r.getTitleId());
        statement.setString(2, r.getTaxCode());
        ResultSet resultSet = statement.executeQuery();

        r = new Reservation();
        r.setTitleId(Integer.parseInt(resultSet.getString("title_id")));
        r.setTaxCode(resultSet.getString("tax_code"));
        r.setCreationDate(resultSet.getDate("creation_date"));

        return r;
    }

    @Override
    public Reservation create(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO RESERVATION VALUES (?,?,?)");
        statement.setString(1, String.valueOf(r.getTitleId()));
        statement.setString(2, r.getTaxCode());
        statement.setDate(3, (Date) r.getCreationDate());

        statement.executeQuery();

        return r;
    }

    @Override
    public Reservation update(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE RESERVATION CREATION_DATE = ? WHEN TITLE_ID = ?, TAX_CODE=?");
        statement.setDate(1, (Date) r.getCreationDate());
        statement.setString(2, String.valueOf(r.getTitleId()));
        statement.setString(3, r.getTaxCode());
        statement.executeQuery();

        return r;
    }

    @Override
    public void delete(Reservation r) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE RESERVATION WHEN TITLE_ID = ?, TAX_CODE = ?");
        statement.setString(1, String.valueOf(r.getTitleId()));
        statement.setString(2, r.getTaxCode());

        statement.executeQuery();
    }
}
