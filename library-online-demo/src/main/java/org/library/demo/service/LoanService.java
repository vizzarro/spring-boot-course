package org.library.demo.service;

import org.library.demo.models.Loan;

import java.util.Date;

public interface LoanService {
  void addLoan(Loan newLoan) throws Exception;
  Loan getLoan(Date id);
  void deleteLoan(Date id);
  Loan updateLoan(Date id, Loan updated);


}
