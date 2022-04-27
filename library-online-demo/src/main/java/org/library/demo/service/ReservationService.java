package org.library.demo.service;

import org.library.demo.models.Reservation;
import org.library.demo.service.exceptions.ServiceException;

import java.sql.SQLException;

public interface ReservationService {
  void addReservation(Reservation newReservation) throws Exception;
  Reservation getReservation(Reservation id);
  void deleteReservation(Reservation id) throws ClassNotFoundException, SQLException, ServiceException;

}
