package it.aesys.course.library.demo.springboot.hybernate.service.client;

import it.aesys.course.library.demo.springboot.hybernate.dto.PersonDto;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class PeopleServiceImpl implements PeopleService {

    private RestTemplate restClient;

    @Autowired
    public PeopleServiceImpl() {
        this.restClient = new RestTemplate();
    }

    @Override
    public boolean findPerson(String taxCode) throws ServiceException {
try {
    ResponseEntity<PersonDto> response = restClient.getForEntity(
            "http://localhost:8081/people/taxCode/" + taxCode, PersonDto.class);

}catch(HttpServerErrorException ex){
    ServiceException serviceException = new ServiceException("User Not Found!");
    serviceException.setStatusCode(HttpStatus.NOT_FOUND.value());
    throw serviceException;
}
    return true;}
}
