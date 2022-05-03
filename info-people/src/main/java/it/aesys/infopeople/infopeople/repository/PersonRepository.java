package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
//    Person addPerson(Person person);
//    Person updatePerson(Person person, int id) throws DaoException;
//    void deletePerson(int id) throws DaoException;
//    Person getPerson(int id) throws DaoException;
//    List<Person> getAllPerson();

}
