package org.library.demo.service;

import org.library.demo.models.Loan;
import org.library.demo.repository.exception.DaoException;
import org.library.demo.service.exceptions.ServiceException;

import java.sql.SQLException;

public interface LoanService {
  Loan addLoan(Loan newLoan) throws Exception;
  Loan getLoan(Loan id);
  void deleteLoan(Loan id) throws ClassNotFoundException, SQLException, DaoException, ServiceException;

}
