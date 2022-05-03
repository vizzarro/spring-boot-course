package it.aesys.course.library.demo.springboot.hybernate.service.client;

import it.aesys.course.library.demo.springboot.hybernate.dto.PersonDto;

public interface PeopleService {

    boolean findPerson(String taxCode);
}
