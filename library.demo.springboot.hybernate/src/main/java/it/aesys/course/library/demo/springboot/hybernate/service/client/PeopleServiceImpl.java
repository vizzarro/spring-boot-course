package it.aesys.course.library.demo.springboot.hybernate.service.client;

import it.aesys.course.library.demo.springboot.hybernate.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PeopleServiceImpl implements PeopleService{

    private RestTemplate restClient;

    @Autowired
    public PeopleServiceImpl() {
        this.restClient = new RestTemplate();
    }

    @Override
    public boolean findPerson(String taxCode) {
        ResponseEntity<PersonDto> response =  restClient.getForEntity(
                "http://localhost:8081/people/taxCode/"+taxCode, PersonDto.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return true;
        }else{
            return false;
        }
    }
}
