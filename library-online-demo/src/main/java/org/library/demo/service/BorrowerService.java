package org.library.demo.service;

import org.library.demo.models.Borrower;

public interface BorrowerService {
  void addBorrower(Borrower newBorrower) throws Exception;
  Borrower getBorrower(int id);

}
