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
  private BaseDao<Loan, String> repo;
  private BaseDao<Title, String> titleRepo;
  private BaseDao<UserLibrary, String> userRepo;
  private BaseDao<Reservation, String> resRepo;

  @Autowired
  public LoanServiceImpl(
      BaseDao<Loan, String> repository,
      BaseDao<Title, String> titleRepository,
      BaseDao<UserLibrary, String> userLibraryRepository,
      BaseDao<Reservation, String> reservationRepository
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
    this.repo.add(newLoan);
    return newLoan;
  }

  @Override
  public Loan getLoan(String id) throws SQLException {
    return repo.getById(id);
  }

  @Override
  public Loan deleteLoan(String id) throws SQLException {
    this.repo.delete(id);
    return null;
  }
}
