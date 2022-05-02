package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;

import java.util.List;

public interface PersonRepository {
    Person addPerson(Person person);
    Person updatePerson(Person person, int id) throws DaoException;
    void deletePerson(int id) throws DaoException;
    Person getPerson(int id) throws DaoException;
    List<Person> getAllPerson();

}
