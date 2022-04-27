package org.library.demo.controller;

import org.library.demo.models.Loan;
import org.library.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {

        private LoanService loanService;

        @Autowired
        public LoanController(LoanService loanService) {
            this.loanService = loanService;
        }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<Void> addLoan(@RequestBody Loan loan)
                throws Exception {
            loanService.addLoan(loan);
            return ResponseEntity.noContent().build();
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
        public ResponseEntity<Void> deleteLoan(@PathVariable Date date) {
            loanService.deleteLoan(date);
            return ResponseEntity.noContent().build();
        }

        @RequestMapping(method = RequestMethod.GET, value = "/{id}")
        public ResponseEntity<Loan> getLoan(@PathVariable Date date) {
            Loan response = loanService.getLoan(date);
            return ResponseEntity.ok(response);
        }

        @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
        public ResponseEntity<Loan> updateLoan(@PathVariable Date date, @RequestBody Loan newLoan) {
            Loan response = loanService.updateLoan(date, newLoan);
            return ResponseEntity.ok(response);
        }
}
