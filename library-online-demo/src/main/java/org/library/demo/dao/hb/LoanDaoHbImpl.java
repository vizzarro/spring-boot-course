package org.library.demo.dao.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.demo.dao.BaseDaoImpl;
import org.library.demo.dao.LoanDao;
import org.library.demo.models.Loan;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.*;

@Repository
public class LoanDaoHbImpl extends BaseDaoImpl<Loan, Loan> implements LoanDao {

    @Override
    public Loan get(Loan loanId) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();
        Loan loan = null;
        try {
            session.beginTransaction();
            loan = session.get(Loan.class, (Serializable) loanId);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
            if(loan != null){
                return loan;
            } else{
                return null;
            }
        }
    }


        /**
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM LOANS WHERE TITLE_ID=? AND TAX_CODE=?");
        statement.setString(1, loan.getTitleId());
        statement.setString(2, loan.getTaxCode());
        ResultSet resultSet = statement.executeQuery();

        loan = null;
        if(resultSet.next()) {
            loan = new Loan();
            loan.setTitleId(resultSet.getString("title_id"));
            loan.setTaxCode(resultSet.getString("tax_code"));
            loan.setCreationDate(resultSet.getDate("creation_date"));
        }
        return loan;
    }
         */

    @Override
    public void create(Loan loan) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(loan);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

        /**
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO LOANS VALUES (?,?,?)");
        statement.setString(1, String.valueOf(l.getTitleId()));
        statement.setString(2, l.getTaxCode());
        statement.setDate(3, new java.sql.Date(l.getCreationDate().getTime()));

        statement.executeUpdate();

        return l;
    }
         */




    @Override
    public void delete(Loan loanId) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.delete(session.get(Loan.class, (Serializable) loanId));
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
        /**
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM LOANS WHERE TITLE_ID = ? AND TAX_CODE = ?");
        statement.setString(1, l.getTitleId());
        statement.setString(2, l.getTaxCode());

        statement.executeUpdate();
    }
         */

    @Override
    public void update(Loan updated) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Loan toUpdate = session.get(Loan.class, (Serializable) updated.getLoanId());
            toUpdate.setLoanId(new Loan(updated.getLoanId()));
            toUpdate.setCreationDate(updated.getCreationDate());
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
    /**
     Connection conn = super.connect();
     PreparedStatement statement = conn.prepareStatement("UPDATE LOANS SET CREATION_DATE = ? WHERE TITLE_ID = ? AND TAX_CODE=?");
     statement.setDate(1, (Date) l.getCreationDate());
     statement.setString(2, l.getTitleId());
     statement.setString(3, l.getTaxCode());
     statement.executeUpdate();

     return l;
     }
     */
}


