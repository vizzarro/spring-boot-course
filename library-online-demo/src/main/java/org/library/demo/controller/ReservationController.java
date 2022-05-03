package org.library.demo.controller;

import org.library.demo.dtos.MapperDto;
import org.library.demo.dtos.ReservationDto;
import org.library.demo.dtos.TitleDto;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.library.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Date;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
    private ReservationService service;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.service = reservationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addReservation(@RequestBody ReservationDto reservationDto) throws Exception {
        Reservation reservation = MapperDto.refactor(reservationDto);
        service.addReservation(reservation);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Integer reservationId) throws SQLException {
        service.deleteReservation(reservationId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{reservationId}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Integer reservationId) throws SQLException {
        Reservation response = service.getReservation(reservationId);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateReservation(@RequestBody ReservationDto reservationDto) throws SQLException {

        Reservation reservation = MapperDto.refactor(reservationDto);
        service.updateReservation(reservation);
        return ResponseEntity.noContent().build();
    }

}
