package org.library.demo.service;

import org.library.demo.models.Reservation;

import java.sql.SQLException;

public interface ReservationService {
  void addReservation(Reservation newReservation) throws Exception;
  Reservation getReservation(int id) throws SQLException;
  void deleteReservation(int id) throws SQLException;

}
