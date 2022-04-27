package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.library.demo.repository.GenericDao;
import org.library.demo.repository.exception.DaoException;
import org.library.demo.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class ReservationServiceImpl implements ReservationService {
  private GenericDao<Reservation,Reservation> repo;
  private GenericDao<Title,String> titleRepo;
  private GenericDao<UserLibrary,String> borrowerRepo;

  @Autowired
  public ReservationServiceImpl(
      GenericDao<Reservation,Reservation> repository,
      GenericDao<Title,String> titleRepository,
      GenericDao<UserLibrary,String> borrowerRepository
  ) {
    this.repo = repository;
    this.titleRepo = titleRepository;
    this.borrowerRepo = borrowerRepository;
  }

  public ReservationServiceImpl() {
  }

  @Override
  public void addReservation(Reservation newReservation) throws Exception {
//    if (newReservation == null)
//      throw new Exception("No request");
//
//    try {
//      UserLibrary b = borrowerRepo.getById(newReservation.getUserTaxCode()); // ra rivedere casting
//    } catch (Exception e) {
//      throw new Exception("No UserLibrary found for id " + newReservation.getUserTaxCode());
//    }
//
//    Title exists = titleRepo.getById(newReservation.getTitleId());
//    if (exists == null)
//      throw new Exception("No Title found for id " + newReservation.getTitleId());

    repo.add(newReservation);
  }

  @Override
  public Reservation getReservation(Reservation id) {
    return repo.getById(id);
  }

  @Override
  public void deleteReservation(Reservation id) throws ClassNotFoundException, SQLException, ServiceException {
    try {
      this.repo.delete(id);
    } catch (DaoException e) {
      e.printStackTrace();
    }
  }
}
