package it.aesys.course.library.demo.springboot.dao;


import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.models.Loan;
import it.aesys.course.library.demo.springboot.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class LoanDao extends GenericDaoImpl<Loan, Loan> {
    @Autowired
    private ApplicationContext ctx;

    @Override
    public Loan add(Loan entity) throws DaoException {

        Connection conn = getConnection();
        String query = "INSERT INTO loans (title_id, tax_code, creation_date) VALUES(?,?,?)";
        PreparedStatement stat;
        try {
            stat = getConnection().prepareStatement(query);
            stat.setString(1, entity.getTitleId());
            stat.setString(2, entity.getTaxCode());
            stat.setDate(3, new Date(entity.getCreationDate().getTime()));
            stat.executeUpdate();
            conn.close();
            return entity;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public void delete(Loan id) throws DaoException {
        Connection conn = getConnection();
        String query = "DELETE FROM loans WHERE tax_code=? AND title_id=? AND creation_date=?";
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(query);
            stat.setString(1,id.getTaxCode());
            stat.setString(2, id.getTitleId());
            stat.setDate(3, new Date(id.getCreationDate().getTime()));
            stat.execute();
            conn.close();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public Loan update(Loan id, Loan entity) throws DaoException {

        Connection conn = getConnection();
        String query = "UPDATE reservation SET title_id=?, tax_code=?, creation_date=?" +
                " WHERE tax_Code=? AND title_id=? AND creation_date=?";
        PreparedStatement stat;
        try {
            stat = getConnection().prepareStatement(query);
            stat.setString(1, entity.getTitleId());
            stat.setString(2, entity.getTaxCode());
            stat.setDate(3, (Date) entity.getCreationDate());
            stat.setString(4, id.getTitleId());
            stat.setString(5, id.getTaxCode());
            stat.setDate(6, (Date) id.getCreationDate());
            stat.executeUpdate();
            conn.close();
            return entity;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public Loan get(Loan id) throws DaoException {
        String query ="SELECT * FROM loans WHERE tax_code=? AND title_id=? AND creation_date=?";

        Connection conn = getConnection();
        PreparedStatement stat;
        try {
            stat = getConnection().prepareStatement(query);
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
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }
}
