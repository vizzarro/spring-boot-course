package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;

public interface PersonService {

    public PersonDto createPersonDto(PersonDto personDto);
    public PersonDto updatePersonDto(PersonDto personDto, int id) throws ServiceException;
    public PersonDto getPersonDto(int id) throws DaoException, ServiceException;
    public void deletePersonDto(int id) throws ServiceException;



}
