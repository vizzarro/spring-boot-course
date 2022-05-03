package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.repository.PersonDAO;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {


    private PersonDAO personDAO;
    private ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonDAO repository, ModelMapper modelMapper) {
        this.personDAO = repository;
        this.modelMapper = modelMapper;
    }


    @Override
    public PersonDto createPersonDto(PersonDto personDto) {
        return modelMapper.toPersonDto(personDAO.save(modelMapper.toPerson(personDto)));
    }

    @Override
    public PersonDto updatePersonDto(PersonDto personDto, String taxcode) {
        return createPersonDto(personDto);
    }
        @Override
        public PersonDto getPersonDto (int id) throws ServiceException {
            try {
                return this.modelMapper.toPersonDto(personDAO.getOne(id));
            } catch (RuntimeException e) {
                ServiceException ex = new ServiceException();
                ex.setPath("/people/get");
                ex.setStatusCode(HttpStatus.BAD_REQUEST.value());
                throw ex;
            }
        }

        @Override
        public void deletePersonDto (int id) throws ServiceException {
            try {
                personDAO.deleteById(id);
            } catch (RuntimeException e) {
                ServiceException ex = new ServiceException();
                ex.setPath("/people/get");
                ex.setStatusCode(HttpStatus.BAD_REQUEST.value());
                throw ex;
            }
        }
    }
