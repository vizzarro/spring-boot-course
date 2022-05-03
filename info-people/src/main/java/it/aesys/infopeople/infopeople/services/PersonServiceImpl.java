package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.PersonRepository;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository repository, PersonRepository personRepository) {
        this.repository=personRepository;
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }


    @Override
    public PersonDto getPersonDtoFromTaxCode(String taxCode) throws DaoException, ServiceException {
        List<Person> persons = repository.getPersonFromTaxCode(taxCode);

        return modelMapper.map(persons.get(0),PersonDto.class);
    }

    @Override
    public List<PersonDto> getAllPersonDto() {
        List<PersonDto> persons = new ArrayList<>();
        for(Person temp : repository.findAll()){
            persons.add(modelMapper.map(temp,PersonDto.class));
        }
        return persons;
    }

    @Override
    @Transactional
    public PersonDto createPersonDto(PersonDto personDto) {

        Person person = modelMapper.map(personDto, Person.class);
        return modelMapper.map(repository.save(person),PersonDto.class );

        //return modelMapper.map(repository.addPerson(person), PersonDto.class);
    }

    @Override
    public PersonDto updatePersonDto(PersonDto personDto, int id) throws ServiceException {
        return null;
    }
        @Override
        public PersonDto getPersonDto (int id) throws ServiceException {
            return this.modelMapper.map(repository.getById(id), PersonDto.class);
        }

        @Override
        public void deletePersonDto (int id) throws ServiceException {
                repository.deleteById(id);

            }
        }

