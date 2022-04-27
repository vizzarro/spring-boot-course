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

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
  private ReservationService service;

  @Autowired
  public ReservationController(ReservationService reservationService) {
    this.service = reservationService;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> addReservation(@RequestBody Reservation reservation)
      throws Exception {
    service.addReservation(reservation);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteReservation(@PathVariable int id) throws SQLException {
    service.deleteReservation(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Reservation> getReservation(@PathVariable int id) throws SQLException {
    Reservation response = service.getReservation(id);
    return ResponseEntity.ok(response);
  }

}
