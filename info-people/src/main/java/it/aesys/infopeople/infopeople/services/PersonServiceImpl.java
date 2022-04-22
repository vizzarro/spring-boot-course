package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.repository.PersonRepository;
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
        return personDto;
    }

    @Override
    public PersonDto updatePersonDto(PersonDto personDto, String taxcode) {
        return personDto;
    }

    @Override
    public PersonDto getPersonDto(String taxcode) {
      return   this.modelMapper.toPersonDto( repository.getPerson(taxcode));

    }

    @Override
    public void deletePersonDto(String taxcode) {
      repository.deletePerson(taxcode);
    }
}
