package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.model.Persons;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.BadRequestException;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;
import it.aesys.infopeople.infopeople.services.exceptions.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("devel")
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private PersonFileSystemRepository fileSystem;
    private List<Person> persons = new ArrayList<>();

    public PersonRepositoryImpl() {
        persons.addAll(fileSystem.unserialize("personsRepository", Persons.class).getCollection());
    }

    @Override
    public Person addPerson(Person person) {
        persons.add(person);
        updateFileSystem();
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
                updateFileSystem();
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
            updateFileSystem();
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

    private void updateFileSystem() {
        Persons p = new Persons();
        p.setCollection(persons);
        fileSystem.serializeCollection(p, "personsRepository");
    }
}