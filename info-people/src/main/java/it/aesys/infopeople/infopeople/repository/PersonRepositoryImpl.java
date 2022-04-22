package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.BadRequestException;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;
import it.aesys.infopeople.infopeople.services.exceptions.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    List<Person> persons = new ArrayList<>();

    @Override
    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }

    @Override
    public Person updatePerson(Person person, String taxCode) throws BadRequestException, DaoException {

        if (taxCode.equals(person.getTaxCode())) {
            BadRequestException exception = new BadRequestException();
            exception.setPath("/people");
            exception.getErrors().add(new ErrorModel("taxCode", "Tax code not valid"));
            throw exception;
        }

        for (Person pers : persons) {
            if (pers.getTaxCode().equals(taxCode)) {
                pers.setName(person.getName());
                pers.setSurname(person.getSurname());
                pers.setBirthday(person.getBirthday());
                pers.setAddress(person.getAddress());
                return pers;
            }
        }
        DaoException de = new DaoException();
        de.setStatusCode(HttpStatus.NOT_FOUND.value());
        throw de;
    }

    @Override
    public void deletePerson(String taxCode) throws DaoException{
        Person delPers = null;
        for (Person pers : persons) {
            if (pers.getTaxCode().equals(taxCode)) {
                delPers = pers;
            }
        }
        if (delPers != null) {
            persons.remove(delPers);
        }
        DaoException de = new DaoException();
        de.setStatusCode(HttpStatus.NOT_FOUND.value());
        throw de;
    }

    @Override
    public Person getPerson(String taxCode) throws DaoException{
        for (Person pers : persons) {
            if (pers.getTaxCode().equals(taxCode)) {
                return pers;
            }
        }
        DaoException de = new DaoException();
        de.setStatusCode(HttpStatus.NOT_FOUND.value());
        throw de;    }

    @Override
    public List<Person> getAllPerson() {
        return persons;
    }
}