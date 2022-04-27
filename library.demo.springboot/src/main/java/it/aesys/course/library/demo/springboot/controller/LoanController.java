package it.aesys.course.library.demo.springboot.controller;


import it.aesys.course.library.demo.springboot.dto.LoanDto;
import it.aesys.course.library.demo.springboot.request.GenericRequest;
import it.aesys.course.library.demo.springboot.service.LoanServiceImpl;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
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
    public ResponseEntity<LoanDto> add(@RequestBody GenericRequest<LoanDto> request) throws ServiceException {
        LoanDto response = loanService.add(request.getRequestData());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<Void> delete(@RequestParam(name="title_id") String titleId,
                                           @RequestParam(name="tax_code") String taxCode,
                                           @RequestParam(name="creation_date")Date creationDate) throws ServiceException {
        loanService.delete(new LoanDto(titleId, taxCode, creationDate));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<LoanDto> get(@PathVariable String id) throws ServiceException {
        LoanDto response = loanService.get(new LoanDto());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/{id}")
    public ResponseEntity<LoanDto> update(@RequestBody GenericRequest<LoanDto> request, @PathVariable String id) throws ServiceException {
        LoanDto response = loanService.update(new LoanDto(), request.getRequestData());
        return ResponseEntity.ok().body(response);
    }


}
