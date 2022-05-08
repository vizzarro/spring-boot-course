package it.aesys.demo.LibraryDemoSpringBoot.controller;


import it.aesys.demo.LibraryDemoSpringBoot.models.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.aesys.demo.LibraryDemoSpringBoot.service.BorrowerService;

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
