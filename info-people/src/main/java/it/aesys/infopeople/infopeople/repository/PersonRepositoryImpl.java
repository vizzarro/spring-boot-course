package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.exceptions.BadRequestException;
import it.aesys.infopeople.infopeople.repository.exceptions.Error;
import it.aesys.infopeople.infopeople.repository.exceptions.FileNotFoundException;

import java.util.*;

public class PersonRepositoryImpl implements PersonRepository {

    List<Person> persons = new ArrayList<>();

    @Override
    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }

    @Override
    public Person updatePerson(Person person, String taxCode) {
        if (taxCode.equals(person.getTaxCode())) {
            BadRequestException exception = new BadRequestException();
            exception.setPath("/"); //da modificare dal controller
            exception.getErrors().add(new Error("taxCode", "Tax code not valid"));
            throw exception;
        }
        Person oldPerson = null;
        for (Person pers : persons) {
            if (pers.getTaxCode().equals(taxCode)) {
                oldPerson = pers;
            }
        }
        if (oldPerson != null) {
            oldPerson.setName(person.getName());
            oldPerson.setSurname(person.getSurname());
            oldPerson.setBirthday(person.getBirthday());
            oldPerson.setAddress(person.getAddress());
            return oldPerson;
        }
        throw new FileNotFoundException("Resource with tax code" + taxCode + "not found");
    }

    @Override
    public void deletePerson(String taxCode) {
        Person delPers = null;
        for (Person pers : persons) {
            if (pers.getTaxCode().equals(taxCode)) {
                delPers = pers;
            }
        }
        if (delPers != null) {
            persons.remove(delPers);
        }
        throw new FileNotFoundException("Resource with tax code" + taxCode + "not found");
    }

    @Override
    public Person getPerson(String taxCode) {
        for (Person pers : persons) {
            if (pers.getTaxCode().equals(taxCode)) {
                return pers;
            }
        }
        throw new FileNotFoundException("Resource with tax code" + taxCode + "not found");
    }

    @Override
    public List<Person> getAllPerson() {
        return persons;
    }
}





