package it.aesys.course.library.demo.springboot.hybernate.service.client;

import it.aesys.course.library.demo.springboot.hybernate.dto.PersonDto;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;

public interface PeopleService {

    boolean findPerson(String taxCode) throws ServiceException;
}
