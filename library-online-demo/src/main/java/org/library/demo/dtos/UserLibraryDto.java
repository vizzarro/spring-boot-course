package org.library.demo.dtos;

import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import java.util.List;

public class UserLibraryDto {

    private PersonDto personDto;
    private List<Reservation> reservations;
    private List<Title> titles;

    public UserLibraryDto() {
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
    //    private String name;
//    private String surname;
//    private Date birthday;
//    private String taxCode;
//    private AddressDto addressDto;
//
//    public UserLibraryDto() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getTaxCode() {
//        return taxCode;
//    }
//
//    public void setTaxCode(String taxCode) {
//        this.taxCode = taxCode;
//    }
//
//    public AddressDto getAddressDto() {
//        return addressDto;
//    }
//
//    public void setAddressDto(AddressDto addressDto) {
//        this.addressDto = addressDto;
//    }
}
