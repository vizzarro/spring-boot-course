package it.aesys.infopeople.infopeople.dtos;

import it.aesys.infopeople.infopeople.model.Address;

import java.util.Date;

public class PersonDto {


    private String name;
    private String surname;
    private Date birthday;
    private String taxCode;
    private AddressDto addressDto;

    public PersonDto(String name, String surname, Date birthday, String taxCode, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.taxCode = taxCode;
        this.addressDto = addressDto;
    }

    public PersonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}

