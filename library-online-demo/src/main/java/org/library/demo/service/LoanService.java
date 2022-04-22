package org.library.demo.service;

import org.library.demo.models.Loan;

public interface LoanService {
  Loan addLoan(Loan newLoan) throws Exception;
  Loan getLoan(int id);
  Loan deleteLoan(int id);

}
