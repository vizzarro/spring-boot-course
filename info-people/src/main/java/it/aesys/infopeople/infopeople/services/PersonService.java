package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.model.Person;

import java.util.List;

public interface PersonService {

    public PersonDto createPersonDto(PersonDto personDto);
    public PersonDto updatePerson(PersonDto personDto, String taxcode);
    public PersonDto getPerson(String taxcode);
    public void deletePerson(String taxcode);



}
