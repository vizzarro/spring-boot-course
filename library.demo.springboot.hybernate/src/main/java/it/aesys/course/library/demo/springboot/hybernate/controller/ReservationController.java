package it.aesys.course.library.demo.springboot.hybernate.controller;



import it.aesys.course.library.demo.springboot.hybernate.dto.ReservationDto;
import it.aesys.course.library.demo.springboot.hybernate.dto.ReservationIdDto;
import it.aesys.course.library.demo.springboot.hybernate.request.GenericRequest;
import it.aesys.course.library.demo.springboot.hybernate.service.ReservationServiceImpl;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
  @Autowired
  private ReservationServiceImpl reservationService;


  @PostMapping
  public ResponseEntity<ReservationDto> addReservation(@RequestBody GenericRequest<ReservationDto> request) throws ServiceException {
    ReservationDto response = reservationService.add(request.getRequestData());
    return ResponseEntity.ok().body(response);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteReservation(@PathVariable int id) throws ServiceException {
    reservationService.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<ReservationDto> getReservation(@PathVariable int id) throws ServiceException {
    ReservationDto response = reservationService.get(id);
    return ResponseEntity.ok().body(response);
  }

  @PutMapping
  public ResponseEntity<ReservationDto> updateReservation(@RequestBody GenericRequest<ReservationDto> request,
                                                          @PathVariable int id) throws ServiceException {
    ReservationDto response = reservationService.update(id, request.getRequestData());
    return ResponseEntity.ok().body(response);
  }

}
