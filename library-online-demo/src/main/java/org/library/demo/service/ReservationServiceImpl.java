package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.library.demo.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService {
  private BaseDao<Reservation, Date> reservationDao;
  private BaseDao<Title, String> titleDao;
  private BaseDao<UserLibrary, String> userLibraryDao;

  @Autowired
  public ReservationServiceImpl(
          BaseDao<Reservation, Date> reservationDao,
          BaseDao<Title, String> titleDao,
          BaseDao<UserLibrary, String> userLibraryDao
  ) {
    this.reservationDao = reservationDao;
    this.titleDao = titleDao;
  }

  @Override
  public void addReservation(Reservation newReservation) throws Exception {
    if (newReservation == null)
      throw new Exception("No request");

    try {
      UserLibrary b = userLibraryDao.getById(newReservation.getTaxCode());} catch (Exception e) {
      throw new Exception("No UserLibrary found for id " + newReservation.getTaxCode());
    }


    Title exists = titleDao.getById(newReservation.getTitleId());
    if (exists == null)
      throw new Exception("No Title found for id " + newReservation.getTitleId());

    reservationDao.add(newReservation);
  }

  @Override
  public Reservation getReservation(Date id) {
    return reservationDao.getById(id);
  }

  @Override
  public void deleteReservation(Date id) {
    this.reservationDao.delete(id);
  }

  @Override
  public Reservation updateReservation(Date id, Reservation updated) {
    return this.reservationDao.update(id, updated);
  }
}
