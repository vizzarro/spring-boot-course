package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.services.exceptions.BadRequestException;

import java.util.List;

public interface PersonRepository {
    Person addPerson(Person person);
    Person updatePerson(Person person, String taxCode) throws BadRequestException;
    void deletePerson(String taxCode);
    Person getPerson(String taxCode);
    List<Person> getAllPerson();

}
