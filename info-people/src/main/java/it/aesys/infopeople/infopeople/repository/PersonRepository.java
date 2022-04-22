package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.BadRequestException;

import java.util.List;

public interface PersonRepository {
    Person addPerson(Person person);
    Person updatePerson(Person person, String taxCode) throws DaoException;
    void deletePerson(String taxCode) throws DaoException;
    Person getPerson(String taxCode) throws DaoException;
    List<Person> getAllPerson();

}
