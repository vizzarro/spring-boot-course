package org.library.demo.service;

import org.library.demo.models.Loan;
import org.library.demo.models.UserLibrary;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.library.demo.repository.connection.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ReservationServiceImpl implements ReservationService {
  private BaseDao<Reservation> repo;
  private BaseDao<Title> titleRepo;
  private BaseDao<UserLibrary> borrowerRepo;
  private BaseDao<Loan> loanRepo;

  @Autowired
  public ReservationServiceImpl(
      BaseDao<Reservation> repository,
      BaseDao<Title> titleRepository,
      BaseDao<UserLibrary> borrowerRepository,
      BaseDao<Loan> loanRepository
  ) {
    this.repo = repository;
    this.titleRepo = titleRepository;
    this.borrowerRepo = borrowerRepository;
    this.loanRepo = loanRepository;
  }

  @Override
  public void addReservation(Reservation newReservation) throws Exception {
    if (newReservation == null)
      throw new Exception("No request");

    try {
      UserLibrary b = borrowerRepo.getById(newReservation.getBorrowerId());
    } catch (Exception e) {
      throw new Exception("No UserLibrary found for id " + newReservation.getBorrowerId());
    }

    Title exists = titleRepo.getById(Integer.parseInt(newReservation.getTitleId()));
    if (exists == null)
      throw new Exception("No Title found for id " + newReservation.getTitleId());

    repo.add(newReservation);
  }

  @Override
  public Reservation getReservation(int id) throws SQLException {
    return repo.getById(id);
  }

  @Override
  public void deleteReservation(int id) throws SQLException {
    this.repo.delete(id);
  }
}
