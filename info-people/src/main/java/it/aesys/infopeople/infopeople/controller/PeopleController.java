package it.aesys.infopeople.infopeople.controller;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.request.PersonRequest;
import it.aesys.infopeople.infopeople.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/people")
public class PeopleController {

    @Autowired
    private PersonService personService;

    @GetMapping("{taxCode}")
    public PersonDto getPerson(@PathVariable String taxCode){
        return  personService.getPersonDto(taxCode);
        // DTO return
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonRequest request){
       return personService.createPersonDto(request.getPersonDto());
    }

    @DeleteMapping("{taxCode}")
    public void deletePerson(@PathVariable String taxCode){
        personService.deletePersonDto(taxCode);
    }

    @PutMapping("{taxCode}")
    public PersonDto updatePerson(@PathVariable String taxCode, @RequestBody PersonRequest request){
       return personService.updatePersonDto(request.getPersonDto(), taxCode);
    }


}
