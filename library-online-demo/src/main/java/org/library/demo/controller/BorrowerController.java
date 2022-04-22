package org.library.demo.controller;

import org.library.demo.models.Borrower;
import org.library.demo.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/borrower")
public class BorrowerController {

  private BorrowerService service;

  @Autowired
  public BorrowerController(BorrowerService borrowerService) {
    this.service = borrowerService;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> addBorrower(@RequestBody Borrower borrower) throws Exception {
    this.service.addBorrower(borrower);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Borrower> getBorrower(@PathVariable int id) {
    Borrower response = this.service.getBorrower(id);
    return ResponseEntity.ok(response);
  }

}
