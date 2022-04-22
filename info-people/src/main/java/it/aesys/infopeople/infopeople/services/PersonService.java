package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.model.Person;

import java.util.List;

public interface PersonService {

    public PersonDto createPersonDto(PersonDto personDto);
    public PersonDto updatePersonDto(PersonDto personDto, String taxcode);
    public PersonDto getPersonDto(String taxcode);
    public void deletePersonDto(String taxcode);



}
