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
        return null;
    }

    @Override
    public void add(Loan entity) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void delete(Loan id) throws ClassNotFoundException, SQLException, DaoException {

    }

    @Override
    public Loan update(Loan id, Loan updated) {
        return null;
    }
}
