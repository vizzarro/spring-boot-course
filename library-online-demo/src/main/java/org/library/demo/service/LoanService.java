package org.library.demo.service;

import org.library.demo.models.Loan;

import java.sql.SQLException;

public interface LoanService {
    Loan addLoan(Loan newLoan) throws Exception;

    Loan getLoan(Integer id) throws SQLException;

    Loan deleteLoan(Integer id) throws SQLException;

    void updateLoan(Loan updeted) throws SQLException;

}
