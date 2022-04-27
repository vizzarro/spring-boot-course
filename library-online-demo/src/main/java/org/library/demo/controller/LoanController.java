package org.library.demo.controller;

import org.library.demo.dtos.LoanDto;
import org.library.demo.dtos.MapperDto;
import org.library.demo.models.Loan;
import org.library.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {
    private LoanService service;

    @Autowired
    public LoanController(LoanService loanService) {
        this.service = loanService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addLoan(@RequestBody LoanDto loanDto) throws Exception {
        Loan loan = MapperDto.refactor(loanDto);
        service.addLoan(loan);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{titleId}/{taxCode}/{creationDate}")
    public ResponseEntity<Void> deleteLoan(@PathVariable String titleId,
                                           @PathVariable String taxCode,
                                           @PathVariable Date creationDate) throws SQLException {

        Loan id = new Loan();
        id.setCreationDate(creationDate);
        id.setUserLibraryId(taxCode);
        id.setTitleId(titleId);

        service.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{titleId}/{taxCode}/{creationDate}")
    public ResponseEntity<Loan> getLoan(@PathVariable String titleId,
                                        @PathVariable String taxCode,
                                        @PathVariable Date creationDate) throws SQLException {

        Loan id = new Loan();
        id.setCreationDate(creationDate);
        id.setUserLibraryId(taxCode);
        id.setTitleId(titleId);

        Loan response = service.getLoan(id);
        return ResponseEntity.ok(response);
    }

}
