package org.library.demo.controller;

import org.library.demo.dtos.LoanDto;
import org.library.demo.models.Loan;
import org.library.demo.request.GenericRequest;
import org.library.demo.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {

    @Autowired
    private LoanServiceImpl loanService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LoanDto> addLoan(@RequestBody GenericRequest<LoanDto> request) throws SQLException, ClassNotFoundException {
        LoanDto response = loanService.add(request.getRequestData());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<LoanDto> deleteLoan(@RequestParam(name="title_id") String titleId, @RequestParam(name="tax_code") String taxCode, @RequestParam(name="creation_date")Date creationDate) throws SQLException, ClassNotFoundException {
        LoanDto response = loanService.delete(new LoanDto(titleId, taxCode, creationDate));
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<LoanDto> getLoan(@PathVariable String id) throws SQLException, ClassNotFoundException {
        LoanDto response = loanService.get(new LoanDto());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/{id}")
    public ResponseEntity<LoanDto> updateLoan(@RequestBody GenericRequest<LoanDto> request, @PathVariable String id) throws SQLException, ClassNotFoundException {
        LoanDto response = loanService.update(new LoanDto(), request.getRequestData());
        return ResponseEntity.ok().body(response);
    }


}
