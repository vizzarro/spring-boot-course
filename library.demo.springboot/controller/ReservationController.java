package org.library.demo.controller;

import org.library.demo.dtos.ReservationDto;
import org.library.demo.dtos.UserLibraryDto;
import org.library.demo.models.Reservation;
import org.library.demo.request.GenericRequest;
import org.library.demo.service.ReservationServiceImpl;
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
  @Autowired
  private ReservationServiceImpl reservationService;


  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<ReservationDto> addReservation(@RequestBody GenericRequest<ReservationDto> request) throws SQLException, ClassNotFoundException {
    ReservationDto response = reservationService.add(request.getRequestData());
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<ReservationDto> deleteReservation(@PathVariable String id) throws SQLException, ClassNotFoundException {
    ReservationDto response = reservationService.delete(id);
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<ReservationDto> getReservation(@PathVariable String id) throws SQLException, ClassNotFoundException {
    ReservationDto response = reservationService.get(id);
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(method= RequestMethod.PUT, value="/{id}")
  public ResponseEntity<ReservationDto> updateReservation(@RequestBody GenericRequest<ReservationDto> request, @PathVariable String id) throws SQLException, ClassNotFoundException {
    ReservationDto response = reservationService.update(id, request.getRequestData());
    return ResponseEntity.ok().body(response);
  }

}
