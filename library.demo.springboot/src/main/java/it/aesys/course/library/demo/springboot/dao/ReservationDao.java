package it.aesys.course.library.demo.springboot.dao;


import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ReservationDao extends GenericDaoImpl<Reservation, Reservation> {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Reservation add(Reservation entity) throws DaoException {
        Reservation reservation = ctx.getBean(Reservation.class);

        Connection conn = getConnection();
        String query = "INSERT INTO reservation (title_id, tax_code, creation_date) VALUES(?,?,?)";
        PreparedStatement stat;
        try {
            stat = getConnection().prepareStatement(query);
            stat.setString(1, entity.getTitleId());
            stat.setString(2, entity.getTaxCode());
            stat.setDate(3,  new Date(entity.getCreationDate().getTime()));
            stat.executeUpdate();
            conn.close();
            return entity;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public void delete(Reservation id) throws DaoException {
        Connection conn = getConnection();
        String query = "DELETE FROM reservation WHERE title_id=? AND tax_code=? AND creation_date=?";
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(query);
            stat.setString(1, id.getTitleId());
            stat.setString(2,id.getTaxCode());
            stat.setDate(3, new Date(id.getCreationDate().getTime()));
            stat.execute();
            conn.close();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public Reservation update(Reservation id, Reservation entity) throws DaoException {
        Connection conn = getConnection();
        String query = "UPDATE reservation SET title_id=?, tax_code=?, creation_date=? " +
                "WHERE title_id=? AND tax_code=? AND creation_date=?";
        PreparedStatement stat;
        try {
            stat = getConnection().prepareStatement(query);
            stat.setString(1, entity.getTitleId());
            stat.setString(2, entity.getTaxCode());
            stat.setDate(3, new Date(entity.getCreationDate().getTime()));
            stat.setString(4, id.getTitleId());
            stat.setString(5, id.getTaxCode());
            stat.setDate(6, new Date(id.getCreationDate().getTime()));
            stat.executeUpdate();
            conn.close();
            return entity;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public Reservation get(Reservation id) throws DaoException {
        String query ="SELECT * FROM reservation WHERE title_id=? AND tax_code AND creation_date";

        Connection conn = getConnection();
        PreparedStatement stat;
        try {
            stat = getConnection().prepareStatement(query);
            stat.setString(1, id.getTitleId());
            stat.setString(2, id.getTaxCode());
            stat.setDate(3, new Date(id.getCreationDate().getTime()));

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
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
