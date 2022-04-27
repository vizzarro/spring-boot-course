package org.library.demo.service;

import org.library.demo.models.Reservation;

import java.sql.SQLException;

public interface ReservationService {
  void addReservation(Reservation newReservation) throws Exception;
  Reservation getReservation(Reservation id) throws SQLException;
  void deleteReservation(Reservation id) throws SQLException;

}
