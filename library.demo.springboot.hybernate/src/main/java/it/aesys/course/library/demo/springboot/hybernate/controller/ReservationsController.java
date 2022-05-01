package it.aesys.course.library.demo.springboot.hybernate.controller;

import it.aesys.course.library.demo.springboot.hybernate.dao.ReservationDao;
import it.aesys.course.library.demo.springboot.hybernate.dto.ReservationDto;
import it.aesys.course.library.demo.springboot.hybernate.models.Reservation;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value="/reservations")
public class ReservationsController {

    @Autowired
    ReservationDao reservationDao;

    @GetMapping("{taxCode}")
    public ResponseEntity<List<Reservation>> getReservation(@PathVariable String taxCode) {
        List<Reservation> reservations = reservationDao.getUserReservation(taxCode);
        return ResponseEntity.ok().body(reservations);
    }
}
