package org.library.demo.service;

import org.library.demo.models.Loan;

import java.sql.SQLException;

public interface LoanService {
  Loan addLoan(Loan newLoan) throws Exception;
  Loan getLoan(int id) throws SQLException;
  Loan deleteLoan(int id) throws SQLException;

}
