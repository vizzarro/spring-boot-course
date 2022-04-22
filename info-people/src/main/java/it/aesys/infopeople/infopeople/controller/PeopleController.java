package it.aesys.infopeople.infopeople.controller;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.request.PersonRequest;
import it.aesys.infopeople.infopeople.services.PersonService;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/people")
public class PeopleController {

    @Autowired
    private PersonService personService;

    @GetMapping("{taxCode}")
    public PersonDto getPerson(@Valid @PathVariable String taxCode) throws ServiceException, DaoException {
        return  personService.getPersonDto(taxCode);
        // DTO return
    }

    @PostMapping
    public PersonDto createPerson(@Valid @RequestBody PersonRequest request){
       return personService.createPersonDto(request.getPersonDto());
    }

    @DeleteMapping("{taxCode}")
    public void  deletePerson(@Valid @PathVariable String taxCode) throws ServiceException {
        personService.deletePersonDto(taxCode);
    }

    @PutMapping("{taxCode}")
    public PersonDto updatePerson(@Valid @PathVariable String taxCode,@Valid @RequestBody PersonRequest request) throws ServiceException {
       return personService.updatePersonDto(request.getPersonDto(), taxCode);
    }


}
