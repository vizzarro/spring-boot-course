package org.library.demo.dao;

import org.library.demo.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ReservationDao extends GenericDaoImpl<Reservation, String> {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Reservation add(Reservation entity) throws SQLException, ClassNotFoundException {
        Reservation reservation = ctx.getBean(Reservation.class);

        Connection conn = getConnection();
        String query = "INSERT INTO reservation (title_id, tax_code, creation_date) VALUES(?,?,?)";
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, entity.getTitleId());
        stat.setString(2, entity.getTaxCode());
        stat.setDate(3,  new Date(entity.getCreationDate().getTime()));
        stat.executeUpdate();
        conn.close();
        return entity;
    }

    @Override
    public Reservation delete(String id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        String query = "DELETE FROM reservation WHERE title_id=?";
        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1, id);
        stat.execute();
        Reservation reservation = new Reservation();
        conn.close();
        return reservation;

    }

    @Override
    public Reservation update(String id, Reservation entity) throws SQLException, ClassNotFoundException {
        Reservation userLibrary = ctx.getBean(Reservation.class);

        Connection conn = getConnection();
        String query = "UPDATE reservation SET title_id=?, tax_code=?, creation_date=? WHERE tax_Code=?";
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, entity.getTitleId());
        stat.setString(2, entity.getTaxCode());
        stat.setDate(3, new Date(entity.getCreationDate().getTime()));
        stat.setString(4, id);
        stat.executeUpdate();
        conn.close();
        return userLibrary;
    }

    @Override
    public Reservation get(String id) throws SQLException, ClassNotFoundException {
        String query ="SELECT * FROM reservation WHERE title_id=?";

        Connection conn = getConnection();
        PreparedStatement stat = getConnection().prepareStatement(query);

        stat.setString(1, id);

        ResultSet res = stat.executeQuery();
        res.next();
        String taxCode = res.getString("tax_code");
        String titleId = res.getString("title_id");
        Date creationDate = res.getDate("creation_date");
        Reservation reservation = ctx.getBean(Reservation.class);
        reservation.setTaxCode(taxCode);
        reservation.setTitleId(titleId);
        reservation.setCreationDate(creationDate);

        conn.close();

        return reservation;
    }
}
