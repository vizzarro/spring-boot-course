package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonRepositoryDaoImpl implements PersonRepository{

    private EntityManager entityManager;

    @Autowired
    public PersonRepositoryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Person addPerson(Person person) {
        Person personDb = entityManager.merge(person);
        person.setId(personDb.getId());
        return null;
    }

    @Override
    public Person updatePerson(Person person, int id) throws DaoException {
        return null;
    }

    @Override
    public void deletePerson(int id) throws DaoException {

    }

    @Override
    public Person getPerson(int id) throws DaoException {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAllPerson() {
        return null;
    }
}
