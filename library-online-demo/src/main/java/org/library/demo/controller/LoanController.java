package org.library.demo.controller;


import org.library.demo.models.Loan;
import org.library.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {

  private LoanService service;

  @Autowired
  public LoanController(LoanService loanService) {
    this.service = loanService;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) throws Exception {
    Loan response = this.service.addLoan(loan);
    return ResponseEntity.ok(response);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Loan> getLoan(@PathVariable String id) throws SQLException {
    Loan response = this.service.getLoan(id);
    return ResponseEntity.ok(response);
  }

}
