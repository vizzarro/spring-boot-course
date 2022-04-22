package it.aesys.infopeople.infopeople.request;

import it.aesys.infopeople.infopeople.dtos.AddressDto;
import it.aesys.infopeople.infopeople.dtos.PersonDto;

public class PersonRequest {

    private PersonDto personDto;

    public PersonRequest(){}

    public PersonRequest(PersonDto personDto) {
        this.personDto = personDto;
    }



    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }
/*
    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

 */
}
