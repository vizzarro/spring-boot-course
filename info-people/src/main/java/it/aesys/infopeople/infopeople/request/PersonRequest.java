package it.aesys.infopeople.infopeople.request;

import it.aesys.infopeople.infopeople.dtos.AddressDto;
import it.aesys.infopeople.infopeople.dtos.PersonDto;

public class PersonRequest {

    private PersonDto person;
    private AddressDto address;

    public PersonRequest(){}

    public PersonRequest(PersonDto person) {
        this.person = person;
    }

    public PersonDto getPersonDto() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
