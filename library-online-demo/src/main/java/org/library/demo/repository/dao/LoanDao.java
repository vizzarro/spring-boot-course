package org.library.demo.repository.dao;

import org.library.demo.models.Loan;
import org.library.demo.repository.GenericDaoImpl;
import org.library.demo.repository.exception.DaoException;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class LoanDao extends GenericDaoImpl<Loan,Loan> {
    Connection conn;

    public LoanDao() {
    }

    @Override
    public Loan getById(Loan id) {
        Loan loan = null;
        try {

                conn = this.getConnection();

            String query = "SELECT * FROM loan WHERE title_id = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loan = new Loan(rs.getString("title_id"), rs.getString("tax_code"), rs.getDate("creation_date"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {
                this.deleteConnection(conn);

        }
        return loan;
    }

    @Override
    public void add(Loan entity) {
        try {
                conn = this.getConnection();

            String query = "INSERT INTO loan(title_id, tax_code,creation_date) VALUES (?,?,NOW());";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, entity.getTitleId());
            ps.setString(2, entity.getUserTaxCode());
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {

                this.deleteConnection(conn);

        }


    }

    @Override
    public void delete(Loan id) throws ClassNotFoundException, SQLException, DaoException {
        try {
                conn = this.getConnection();

            String query = "DELETE FROM loan WHERE title_id=? AND tax_code=?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id.getTitleId());
            ps.setString(2, id.getUserTaxCode());
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {
                this.deleteConnection(conn);
        }

    }

    @Override
    public Loan update(Loan id, Loan updated) {
        return null;
    }
}
