package org.library.demo.repository;

import org.library.demo.models.Loan;
import org.library.demo.models.Reservation;
import org.library.demo.repository.connection.BaseDao;
import org.library.demo.repository.connection.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ReservationDao extends BaseDaoImpl<Reservation, String> {
    Connection conn = null;
    public ReservationDao() { }

    @Override
    public Reservation getById(String id) throws SQLException {
        Loan loan = null;

        conn = this.getConnection();
        String query = "SELECT * FROM reservation WHERE tax_code = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);

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
    public void delete(String id) throws SQLException {
        conn = this.getConnection();
        String query = "DELETE FROM title WHERE tax_code = ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public Reservation update(String id, Reservation updated) throws SQLException {
        conn = this.getConnection();
        String query = "UPDATE reservation SET title_id = ?, tax_code = ?, creation_date = ? WHERE tax_code = ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, updated.getTitleId());
        ps.setString(2, updated.getTaxCode());
        ps.setDate(3, (Date) updated.getCreationDate());
        ps.setString(4, id);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
        return null;
    }

}

