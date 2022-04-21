package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.model.Person;
import it.aesys.infopeople.infopeople.repository.PersonRepository;
import jdk.internal.module.IllegalAccessLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return personDto;
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto, String taxcode) {
        return personDto;
    }

    @Override
    public PersonDto getPerson(String taxcode) {
        return null;
    }

    @Override
    public void deletePerson(String taxcode) {

    }
}
