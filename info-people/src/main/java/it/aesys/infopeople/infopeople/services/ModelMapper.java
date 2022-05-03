package it.aesys.infopeople.infopeople.services;

import it.aesys.infopeople.infopeople.dtos.AddressDto;
import it.aesys.infopeople.infopeople.dtos.PersonDto;
import it.aesys.infopeople.infopeople.model.Address;
import it.aesys.infopeople.infopeople.model.Person;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public PersonDto toPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setName(person.getName());
        personDto.setSurname(person.getSurname());
        personDto.setBirthday(person.getBirthday());
        personDto.setAddressDto(this.toAddressDto(person.getAddress()));
        personDto.setTaxCode(person.getTaxCode());

        return personDto;
    }

    public Person toPerson(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        person.setBirthday((java.sql.Date)personDto.getBirthday());
        person.setAddress(this.toAddress(personDto.getAddressDto()));
        person.setTaxCode(personDto.getTaxCode());

        return person;
    }

    public AddressDto toAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCity());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setRegion(address.getRegion());
        addressDto.setRoad(address.getRoad());
        addressDto.setZIPCode(address.getZIPCode());

        return addressDto;
    }


    public Address toAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCity());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setRegion(addressDto.getRegion());
        address.setRoad(addressDto.getRoad());
        address.setZIPCode(addressDto.getZIPCode());

        return address;
    }

}
