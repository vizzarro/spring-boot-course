package org.library.demo.service;

import org.library.demo.models.Reservation;
import org.library.demo.models.Title;

import java.util.Date;

public interface ReservationService {
  void addReservation(Reservation newReservation) throws Exception;
  Reservation getReservation(Date id);
  void deleteReservation(Date id);
  Reservation updateReservation(Date id, Reservation updated);

}
