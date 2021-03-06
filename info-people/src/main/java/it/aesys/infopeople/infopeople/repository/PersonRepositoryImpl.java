package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.model.Persons;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;
import it.aesys.infopeople.infopeople.repository.exceptions.EmptyFileSystemRepositoryExcepton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("devel")
public class PersonRepositoryImpl implements PersonRepository {

    private PersonFileSystemRepository fileSystem;
    private List<Person> persons = new ArrayList<>();

    @Autowired
    public PersonRepositoryImpl(PersonFileSystemRepository fileSystem) {
        this.fileSystem = fileSystem;
        try {
            persons.addAll(this.fileSystem.unserialize("personsRepository.json", Persons.class).getCollection());
        } catch (EmptyFileSystemRepositoryExcepton emptyFileSystemRepositoryExcepton) {
           System.out.println("Warning empty file repository");
        }
    }

    @Override
    public Person addPerson(Person person) {
        persons.add(person);
        updateFileSystem();
        return person;
    }

    @Override
    public Person updatePerson(Person person, String taxCode) throws  DaoException {
        if (!taxCode.equals(person.getTaxCode())) {
            DaoException exception = new DaoException();
            exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
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
        }else {
            DaoException de = new DaoException();
            de.setStatusCode(HttpStatus.NOT_FOUND.value());
            throw de;
        }
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
        fileSystem.serializeCollection(p, "personsRepository.json");
    }
}