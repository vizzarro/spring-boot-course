package org.library.demo.service;

import org.library.demo.models.Loan;
import org.library.demo.models.UserLibrary;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.library.demo.repository.LoanDao;
import org.library.demo.repository.ReservationDao;
import org.library.demo.repository.TitleDao;
import org.library.demo.repository.UserDao;
import org.library.demo.repository.connection.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.SQLException;

@Service
public class ReservationServiceImpl implements ReservationService {

  private BaseDao<Reservation, String> repo;
  private BaseDao<Title, String> titleRepo;
  private BaseDao<UserLibrary, String> userRepo;
  private BaseDao<Loan, String>  loanRepo;

  @Autowired
  public ReservationServiceImpl(
          ReservationDao repo,
          TitleDao titleRepo,
          UserDao userRepo,
          LoanDao loanRepo
  ) {
    this.repo = repo;
    this.titleRepo = titleRepo;
    this.userRepo = userRepo;
    this.loanRepo = loanRepo;
  }

  @Override
  public void addReservation(Reservation newReservation) throws Exception {
    if (newReservation == null)
      throw new Exception("No request");
    this.repo.add(newReservation);
  }

  @Override
  public Reservation getReservation(String id) throws SQLException {
    return repo.getById(id);
  }

  @Override
  public void deleteReservation(String id) throws SQLException {
    this.repo.delete(id);
  }
}
