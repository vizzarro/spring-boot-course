package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.PersonRepository;
import it.aesys.infopeople.infopeople.repository.PersonRepositoryDaoImpl;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository repository, ModelMapper modelMapper) {
        this.modelMapper = new ModelMapper();
    }


    @Override
    public PersonDto createPersonDto(PersonDto personDto) {
        return modelMapper.map(repository.addPerson(modelMapper.map(personDto, Person.class)), PersonDto.class);
    }

    @Override
    public PersonDto updatePersonDto(PersonDto personDto, int id) throws ServiceException {
        try {
            return this.modelMapper.map(repository.updatePerson(modelMapper.map(personDto, Person.class), id), PersonDto.class);
        } catch (DaoException e) {
            ServiceException ex = new ServiceException();
            ex.setPath(e.getPath());
            ex.setStatusCode(e.getStatusCode());
            ex.setErrors(e.getErrors());
            throw ex;
        }
    }
        @Override
        public PersonDto getPersonDto (int id) throws ServiceException {
            try {
                return this.modelMapper.map(repository.getPerson(id), PersonDto.class);
            } catch (DaoException e) {
                ServiceException ex = new ServiceException();
                ex.setPath(e.getPath());
                ex.setStatusCode(e.getStatusCode());
                ex.setErrors(e.getErrors());
                throw ex;
            }
        }

        @Override
        public void deletePersonDto (int id) throws ServiceException {
            try {
                repository.deletePerson(id);
            } catch (DaoException e) {
                ServiceException ex = new ServiceException();
                ex.setPath(e.getPath());
                ex.setStatusCode(e.getStatusCode());
                ex.setErrors(e.getErrors());

                throw ex;
            }
        }
    }
