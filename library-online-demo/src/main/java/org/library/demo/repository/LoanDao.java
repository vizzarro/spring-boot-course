package org.library.demo.repository;

import org.library.demo.models.*;
import org.library.demo.repository.connection.BaseDao;
import org.library.demo.repository.connection.BaseDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class LoanDao extends BaseDaoImpl<Loan, Loan> {
    Connection conn = null;

    public LoanDao() { }

    @Override
    public Loan getById(Loan id) throws SQLException {
        conn = this.getConnection();
        String query = "SELECT * FROM loans WHERE title_id = ? and tax_code = ? and creation_date = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id.getTitleId());
        ps.setString(2, id.getTaxCode());
        ps.setDate(3, (Date) id.getCreationDate());
        ResultSet rs = ps.executeQuery();
        while ( rs.next() ) {
            Loan loan = new Loan(
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
    public void add(Loan entity) throws SQLException {
            conn = this.getConnection();
            String query = "INSERT INTO loans(title_id, tax_code, creation_date)\n" +
                    "VALUES ('" + entity.getTitleId() + "','" + entity.getTaxCode() + "''" + entity.getCreationDate();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
            this.closeConnection(conn);
    }

    @Override
    public void delete(Loan id) throws SQLException {
        conn = this.getConnection();
        String query = "DELETE FROM title WHERE title_id = ? and tax_code = ? and creation_date = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public Loan update(Loan id, Loan updated) throws SQLException {
        conn = this.getConnection();
        String query = "UPDATE loans SET title_id = ?, tax_code = ?, creation_date = ? WHERE title_id = ? and tax_code = ? and creation_date = ?";
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
