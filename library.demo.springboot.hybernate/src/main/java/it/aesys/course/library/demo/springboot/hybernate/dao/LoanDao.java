package it.aesys.course.library.demo.springboot.hybernate.dao;


import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.models.Loan;
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

            return entity;

    }

    @Override
    public void delete(Loan id) throws DaoException {

    }

    @Override
    public Loan update(Loan id, Loan entity) throws DaoException {
            return entity;
    }

    @Override
    public Loan get(Loan id) throws DaoException {

            Loan loan = ctx.getBean(Loan.class);
            return loan;

    }
}
