package org.library.demo.controller;

import org.library.demo.models.Reservation;
import org.library.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
  private ReservationService reservationService;

  @Autowired
  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> addReservation(@RequestBody Reservation reservation)
      throws Exception {
    reservationService.addReservation(reservation);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteReservation(@PathVariable Date date) {
    reservationService.deleteReservation(date);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Reservation> getReservation(@PathVariable Date date) {
    Reservation response = reservationService.getReservation(date);
    return ResponseEntity.ok(response);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public ResponseEntity<Reservation> updateReservation(@PathVariable Date date, @RequestBody Reservation newReservation) {
    Reservation response = reservationService.updateReservation(date, newReservation);
    return ResponseEntity.ok(response);
  }

}
