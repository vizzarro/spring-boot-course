package org.library.demo.service;

import org.library.demo.models.Loan;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.connection.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoanServiceImpl implements LoanService {
  private BaseDao<Loan> repo;
  private BaseDao<Title> titleRepo;
  private BaseDao<UserLibrary> userRepo;
  private BaseDao<Reservation> resRepo;

  @Autowired
  public LoanServiceImpl(
      BaseDao<Loan> repository,
      BaseDao<Title> titleRepository,
      BaseDao<UserLibrary> userLibraryRepository,
      BaseDao<Reservation> reservationRepository
  ) {
    this.repo = repository;
    this.titleRepo = titleRepository;
    this.userRepo = userLibraryRepository;
    this.resRepo = reservationRepository;
  }

  public LoanServiceImpl() { }

  @Override
  public Loan addLoan(Loan newLoan) throws Exception {
    if (newLoan == null)
      throw new Exception("No request");

    try {
      UserLibrary u = userRepo.getById(newLoan.getUserLibraryId());
    } catch (Exception e) {
      throw new Exception("No Borrower found for id " + newLoan.getUserLibraryId());
    }

    Title exists = titleRepo.getById(Integer.parseInt(newLoan.getTitleId()));
    if (exists == null)
      throw new Exception("No Title found for id " + newLoan.getTitleId());


    repo.add(newLoan);
    return newLoan;
  }

  @Override
  public Loan getLoan(int id) throws SQLException {
    return repo.getById(id);
  }

  @Override
  public Loan deleteLoan(int id) throws SQLException {
    this.repo.delete(id);
    return null;
  }
}
