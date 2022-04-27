package it.aesys.course.library.demo.springboot.controller;


import it.aesys.course.library.demo.springboot.dto.ReservationDto;
import it.aesys.course.library.demo.springboot.request.GenericRequest;
import it.aesys.course.library.demo.springboot.service.ReservationServiceImpl;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
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

  @DeleteMapping("delete")
  public ResponseEntity<Void> deleteReservation(@RequestParam(name="title_id") String titleId,
                                                @RequestParam(name="tax_code") String taxCode,
                                                @RequestParam(name="creation_date") Date creationDate) throws ServiceException {
    reservationService.delete(new ReservationDto(creationDate, titleId, taxCode));
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<ReservationDto> getReservation(@RequestParam(name="title_id") String titleId,
                                                       @RequestParam(name="tax_code") String taxCode,
                                                       @RequestParam(name="creation_date") Date creationDate) throws ServiceException {
    ReservationDto response = reservationService.get(new ReservationDto(creationDate, titleId, taxCode));
    return ResponseEntity.ok().body(response);
  }

  @PutMapping
  public ResponseEntity<ReservationDto> updateReservation(@RequestBody GenericRequest<ReservationDto> request,
                                                          @RequestParam(name="title_id") String titleId,
                                                          @RequestParam(name="tax_code") String taxCode,
                                                          @RequestParam(name="creation_date") Date creationDate) throws ServiceException {
    ReservationDto response = reservationService.update(new ReservationDto(creationDate, titleId, taxCode), request.getRequestData());
    return ResponseEntity.ok().body(response);
  }

}
