package it.aesys.infopeople.infopeople.model;

import java.util.Date;

public class Person {

    private String name;
    private String surname;
    private Date birthday;
    private String taxCode;
    private Address address;

    public Person() {}

    public Person(String name, String surname, Date birthday, String taxCode, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.taxCode = taxCode;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
