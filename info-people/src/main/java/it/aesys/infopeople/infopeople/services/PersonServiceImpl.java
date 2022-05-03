package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.repository.PersonDAO;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
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
        return modelMapper.toPersonDto(personDAO.addPerson(modelMapper.toPerson(personDto)));
    }

    @Override
    public PersonDto updatePersonDto(PersonDto personDto, String taxcode) throws ServiceException {
        try {
            return this.modelMapper.toPersonDto(personDAO.updatePerson(modelMapper.toPerson(personDto), taxcode));
        } catch (DaoException e) {
            ServiceException ex = new ServiceException();
            ex.setPath(e.getPath());
            ex.setStatusCode(e.getStatusCode());
            ex.setErrors(e.getErrors());
            throw ex;
        }
    }
        @Override
        public PersonDto getPersonDto (String taxcode) throws ServiceException {
            try {
                return this.modelMapper.toPersonDto(personDAO.getPerson(taxcode));
            } catch (DaoException e) {
                ServiceException ex = new ServiceException();
                ex.setPath(e.getPath());
                ex.setStatusCode(e.getStatusCode());
                ex.setErrors(e.getErrors());
                throw ex;
            }
        }

        @Override
        public void deletePersonDto (String taxcode) throws ServiceException {
            try {
                personDAO.deletePerson(taxcode);
            } catch (DaoException e) {
                ServiceException ex = new ServiceException();
                ex.setPath(e.getPath());
                ex.setStatusCode(e.getStatusCode());
                ex.setErrors(e.getErrors());

                throw ex;
            }
        }
    }
