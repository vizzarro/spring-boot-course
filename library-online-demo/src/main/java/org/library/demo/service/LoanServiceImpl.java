package org.library.demo.service;

import org.library.demo.models.Loan;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
  private GenericRepository<Loan> repo;
  private GenericRepository<Title> titleRepo;
  private GenericRepository<UserLibrary> userRepo;

  @Autowired
  public LoanServiceImpl(
      GenericRepository<Loan> repository,
      GenericRepository<Title> titleRepository,
      GenericRepository<UserLibrary> userLibraryRepository
  ) {
    this.repo = repository;
    this.titleRepo = titleRepository;
    this.userRepo = userLibraryRepository;
  }

  @Override
  public Loan addLoan(Loan newLoan) throws Exception {
    if (newLoan == null)
      throw new Exception("No request");

    try {
      UserLibrary u = userRepo.getById(newLoan.getUserLibraryId());
    } catch (Exception e) {
      throw new Exception("No Borrower found for id " + newLoan.getUserLibraryId());
    }

    Title exists = titleRepo.getById(newLoan.getTitleId());
    if (exists == null)
      throw new Exception("No Title found for id " + newLoan.getTitleId());


    repo.add(newLoan);
    return newLoan;
  }

  @Override
  public Loan getLoan(int id) {
    return repo.getById(id);
  }

  @Override
  public Loan deleteLoan(int id) {
    this.repo.delete(id);
    return null;
  }
}
