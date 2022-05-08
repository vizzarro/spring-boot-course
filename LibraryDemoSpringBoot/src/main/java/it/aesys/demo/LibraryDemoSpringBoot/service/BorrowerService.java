package it.aesys.demo.LibraryDemoSpringBoot.service;

import it.aesys.demo.LibraryDemoSpringBoot.models.Borrower;

public interface BorrowerService {
  void addBorrower(Borrower newBorrower) throws Exception;
  Borrower getBorrower(int id);

}
