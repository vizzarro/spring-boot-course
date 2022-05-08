package org.library.demo.dao;

import org.library.demo.models.Loan;
import org.library.demo.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
public class LoanDao extends GenericDaoImpl<Loan, Loan> {
    @Autowired
    private ApplicationContext ctx;

    @Override
    public Loan add(Loan entity) throws SQLException, ClassNotFoundException {

        Connection conn = getConnection();
        String query = "INSERT INTO loans (title_id, tax_code, creation_date) VALUES(?,?,?)";
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, entity.getTitleId());
        stat.setString(2, entity.getTaxCode());
        stat.setDate(3, new Date(entity.getCreationDate().getTime()));
        stat.executeUpdate();
        conn.close();
        return entity;
    }

    @Override
    public Loan delete(Loan id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        String query = "DELETE FROM loans WHERE tax_code=? AND title_id=? AND creation_date=?";
        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1,id.getTaxCode());
        stat.setString(2, id.getTitleId());
        stat.setDate(3, new Date(id.getCreationDate().getTime()));
        stat.execute();
        Loan loan = ctx.getBean(Loan.class);
        conn.close();
        return loan;

    }

    @Override
    public Loan update(Loan id, Loan entity) throws SQLException, ClassNotFoundException {
        Reservation userLibrary = ctx.getBean(Reservation.class);

        Connection conn = getConnection();
        String query = "UPDATE reservation SET title_id=?, tax_code=?, creation_date=? WHERE tax_Code=? AND title_id=? AND creation_date=?";
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, entity.getTitleId());
        stat.setString(2, entity.getTaxCode());
        stat.setDate(3, (Date) entity.getCreationDate());
        stat.setString(4, id.getTitleId());
        stat.setString(5, id.getTaxCode());
        stat.setDate(6, (Date) id.getCreationDate());
        stat.executeUpdate();
        conn.close();
        return entity;
    }

    @Override
    public Loan get(Loan id) throws SQLException, ClassNotFoundException {
        String query ="SELECT * FROM loans WHERE tax_code=? AND title_id=? AND creation_date=?";

        Connection conn = getConnection();
        PreparedStatement stat = getConnection().prepareStatement(query);

        stat.setString(1, id.getTaxCode());
        stat.setString(2,id.getTitleId());
        stat.setDate(3, new Date(id.getCreationDate().getTime()));

        ResultSet res = stat.executeQuery();
        res.next();
        String taxCode = res.getString("tax_code");
        String titleId = res.getString("title_id");
        Date creationDate = res.getDate("creation_date");
        Loan loan = ctx.getBean(Loan.class);
        loan.setTaxCode(taxCode);
        loan.setTitleId(titleId);
        loan.setCreationDate((Date) creationDate);

        conn.close();

        return loan;
    }
}
