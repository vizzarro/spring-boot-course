package org.library.demo.repository;

import org.library.demo.models.Loan;
import org.library.demo.models.Reservation;
import org.library.demo.repository.connection.BaseDao;
import org.library.demo.repository.connection.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ReservationDao extends BaseDaoImpl<Reservation, Reservation> {
    Connection conn = null;
    public ReservationDao() { }

    @Override
    public Reservation getById(Reservation id) throws SQLException {
        Loan loan = null;

        conn = this.getConnection();
        String query = "SELECT * FROM reservation WHERE title_id = ? and tax_code = ? and creation_date = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id.getTitleId());
        ps.setString(2, id.getTaxCode());
        ps.setDate(3, (Date) id.getCreationDate());
        ResultSet rs = ps.executeQuery();
        while ( rs.next() ) {
            Reservation reservation = new Reservation (
                    rs.getString("title_id"),
                    rs.getString("Tax_code"),
                    rs.getDate("creation_date")
            );
        }
        rs.close();
        ps.close();
        this.closeConnection(conn);

        return null;
    }

    @Override
    public void add(Reservation entity) throws SQLException {
        conn = this.getConnection();
        String query = "INSERT INTO reservation (title_id, tax_code, creation_date)\n" +
                "VALUES ('" + entity.getTitleId() + "','" + entity.getTaxCode() + "''" + entity.getCreationDate();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public void delete(Reservation id) throws SQLException {
        conn = this.getConnection();
        String query = "DELETE FROM title WHERE title_id = ? and tax_code = ? and creation_date = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public Reservation update(Reservation id, Reservation updated) throws SQLException {
        conn = this.getConnection();
        String query = "UPDATE reservation SET title_id = ?, tax_code = ?, creation_date = ? WHERE title_id = ? and tax_code = ? and creation_date = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, updated.getTitleId());
        ps.setString(2, updated.getTaxCode());
        ps.setDate(3, (Date) updated.getCreationDate());
        ps.setString(4, id.getTitleId());
        ps.setString(5, id.getTaxCode());
        ps.setDate(6, (Date) id.getCreationDate());
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
        return null;
    }
}

