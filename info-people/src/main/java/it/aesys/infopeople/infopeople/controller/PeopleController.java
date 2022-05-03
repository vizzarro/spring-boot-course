package it.aesys.infopeople.infopeople.controller;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.request.PersonRequest;
import it.aesys.infopeople.infopeople.services.PersonService;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/people")
public class PeopleController {

    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public PersonDto getPerson(@Valid @PathVariable int id) throws ServiceException, DaoException {
        return  personService.getPersonDto(id);
        // DTO return
    }
    @GetMapping
    public List<PersonDto> getAllPerson() throws ServiceException, DaoException {
        return  personService.getAllPersonDto();
        // DTO return
    }

    @PostMapping
    public PersonDto createPerson(@Valid @RequestBody PersonRequest request){
       return personService.createPersonDto(request.getPersonDto());
    }

    @DeleteMapping("{id}")
    public void  deletePerson(@Valid @PathVariable int id) throws ServiceException {
        personService.deletePersonDto(id);
    }

    @PutMapping("{id}")
    public PersonDto updatePerson(@Valid @PathVariable int id,@Valid @RequestBody PersonRequest request) throws ServiceException {
       return personService.updatePersonDto(request.getPersonDto(), id);
    }


}
