package org.library.demo.service;

import org.library.demo.dtos.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PersonServiceImpl {



    public PersonDto getPerson(String taxcode) throws Exception{

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/people/foos";
        ResponseEntity<PersonDto> response
                = restTemplate.getForEntity(fooResourceUrl + "/"+taxcode, PersonDto.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        throw  new Exception(String.valueOf(response.getStatusCodeValue()));
    }


}
