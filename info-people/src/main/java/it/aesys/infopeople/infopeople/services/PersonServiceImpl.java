package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;
import it.aesys.infopeople.infopeople.repository.PersonRepository;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {


    private PersonRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @Override
    public PersonDto createPersonDto(PersonDto personDto) {
        return modelMapper.toPersonDto(repository.addPerson(modelMapper.toPerson(personDto)));
    }

    @Override
    public PersonDto updatePersonDto(PersonDto personDto, String taxcode) throws ServiceException {
        try {
            return this.modelMapper.toPersonDto(repository.updatePerson(modelMapper.toPerson(personDto), taxcode));
        } catch (DaoException e) {
            ServiceException ex = new ServiceException();
            ex.setPath(e.getPath());
            ex.setStatusCode(e.getStatusCode());
            ex.setErrors(e.getErrors());
            ex.getErrors().add(new ErrorModel("taxCode", "Service queried database, " +
                    "but there is not matching in database"));
            throw ex;
        }
    }
        @Override
        public PersonDto getPersonDto (String taxcode) throws ServiceException {
            try {
                return this.modelMapper.toPersonDto(repository.getPerson(taxcode));
            } catch (DaoException e) {
                ServiceException ex = new ServiceException();
                ex.setPath(e.getPath());
                ex.setStatusCode(e.getStatusCode());
                ex.setErrors(e.getErrors());
                ex.getErrors().add(new ErrorModel("taxCode", "Service queried database, " +
                        "but there is not matching in database"));
                throw ex;
            }
        }

        @Override
        public void deletePersonDto (String taxcode) throws ServiceException {
            try {
                repository.deletePerson(taxcode);
            } catch (DaoException e) {
                ServiceException ex = new ServiceException();
                ex.setPath(e.getPath());
                ex.setStatusCode(e.getStatusCode());
                ex.setErrors(e.getErrors());
                ex.getErrors().add(new ErrorModel("taxCode", "Service queried database, " +
                        "but there is not matching in database"));
                throw ex;
            }
        }
    }
