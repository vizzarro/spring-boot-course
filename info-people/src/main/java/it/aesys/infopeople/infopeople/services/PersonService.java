package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;

import java.util.List;

public interface PersonService {

    public PersonDto getPersonDtoFromTaxCode(String taxCode) throws DaoException, ServiceException;
    public List<PersonDto> getAllPersonDto();
    public PersonDto createPersonDto(PersonDto personDto);
    public PersonDto updatePersonDto(PersonDto personDto, int id) throws ServiceException;
    public PersonDto getPersonDto(int id) throws DaoException, ServiceException;
    public void deletePersonDto(int id) throws ServiceException;



}
