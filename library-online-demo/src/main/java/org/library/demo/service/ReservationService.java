package org.library.demo.service;

import org.library.demo.models.Reservation;

public interface ReservationService {
  void addReservation(Reservation newReservation) throws Exception;
  Reservation getReservation(Reservation id);
  void deleteReservation(Reservation id);

}
