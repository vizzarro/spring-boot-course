package org.library.demo.repository.dao;

import org.library.demo.models.Reservation;
import org.library.demo.repository.GenericDaoImpl;
import org.library.demo.repository.exception.DaoException;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ReservationDao extends GenericDaoImpl<Reservation,Reservation> {

    List<Reservation> reservations = new ArrayList<>();
    Connection conn;

    public ReservationDao() {}

    public List<Reservation> getReservationList()  {

        try {
                conn = this.getConnection();
            String query = "SELECT * FROM reservation";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reservations.add(new Reservation(rs.getString("title_id"), rs.getString("tax_code"), rs.getDate("creation_date")));
            }
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                this.deleteConnection(conn);
        }
        return reservations;
    }

    @Override
    public Reservation getById(Reservation id) {
        Reservation res = null;
        try {
            conn = this.getConnection();
            String query = "SELECT * FROM reservation WHERE title_id = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res = new Reservation(rs.getString("title_id"), rs.getString("tax_code"), rs.getDate("creation_date"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                this.deleteConnection(conn);
        }
        return res;
    }

    @Override
    public void add(Reservation entity) throws SQLException {
        try {
                conn = this.getConnection();

            String query = "INSERT INTO reservation(title_id, tax_code,creation_date) VALUES (?,?,NOW());";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, entity.getTitleId());
            ps.setString(2, entity.getUserTaxCode());
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.deleteConnection(conn);
        }
    }
    @Override
    public void delete(Reservation id) throws ClassNotFoundException, SQLException, DaoException {
        try {
                conn = this.getConnection();

            String query = "DELETE FROM reservation WHERE title_id=? AND tax_code=?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id.getTitleId());
            ps.setString(2, id.getUserTaxCode());
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
        } catch (SQLException e) {
            DaoException ex= new DaoException();
        } finally {
                this.deleteConnection(conn);
        }
    }
    @Override
    public Reservation update(Reservation id, Reservation updated) {
        return null;
    }
}
