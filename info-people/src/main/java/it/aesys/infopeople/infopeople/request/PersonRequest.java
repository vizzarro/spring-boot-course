package it.aesys.infopeople.infopeople.request;

public class PersonRequest {

    private PersonDto person;
    private AddressDto address;

    public PersonRequest(){}

    public PersonRequest(PersonDto person) {
        this.person = person;
    }

    public PersonDto getPerson() {
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
