//package org.library.demo.service.client;
//
//import org.library.demo.dtos.PersonDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class PeopleClientServiceImpl implements PeopleService {
//
//
//    private RestTemplate restClient;
//
//    public PeopleClientServiceImpl() {
//    }
//    @Autowired
//    public PeopleClientServiceImpl(RestTemplate r) {
//        this.restClient = r;
//    }
//
//    @Override
//    public PersonDto findPeople(String taxCode) {
//
//
//
//        ResponseEntity<PersonDto> response =  restClient.getForEntity(
//                "http://localhost:8081/people/"+taxCode, PersonDto.class);
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//            return response.getBody();
//        }else{
//            return null;
//        }
//
//    }
//
//
//}
