package org.library.demo.service;

import org.library.demo.models.Loan;

import java.sql.SQLException;

public interface LoanService {
  Loan addLoan(Loan newLoan) throws Exception;
  Loan getLoan(String id) throws SQLException;
  Loan deleteLoan(String id) throws SQLException;

}
