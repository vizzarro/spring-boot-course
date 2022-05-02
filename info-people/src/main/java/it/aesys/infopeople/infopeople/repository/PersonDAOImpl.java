package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.model.Persons;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Profile("devel")
public class PersonDAOImpl implements PersonDAO {

    private EntityManager entityManager;

    private List<Person> persons = new ArrayList<>();

    @Autowired
    public PersonDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Person addPerson(Person person) {
        persons.add(person);

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

        }else {
            DaoException de = new DaoException();
            de.setStatusCode(HttpStatus.NOT_FOUND.value());
            throw de;
        }
    }

    @Override
    @Transactional
    public Person getPerson(String taxCode) throws DaoException{

        Person thePerson = entityManager.find(Person.class, taxCode);
        for (Person pers : persons) {
            if (pers.getTaxCode().equals(taxCode)) {
                return pers;
            }
        }
        DaoException de = new DaoException();
        de.setStatusCode(HttpStatus.NOT_FOUND.value());
        throw de;
}

    @Override
    @Transactional
    public List<Person> getAllPerson() {
        Query theQuery = entityManager.createQuery("from Person");
        List<Person> persons = theQuery.getResultList();
        return persons;
    }

}