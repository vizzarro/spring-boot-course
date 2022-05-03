package it.aesys.infopeople.infopeople.dtos;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class PersonDto {

    private int id;
    @Pattern(regexp = "^([a-z,A-Z]|\\'|[ÀÈÌÒÙYàèìòù])+$",
            message = "wrong formatting for name")
    private String name;
    @Pattern(regexp = "^([a-z,A-Z]|\\'|[ÀÈÌÒÙYàèìòù])+$",
    message = "wrong formatting for surname")
    private String surname;
    private Date birthday;
    @Pattern(regexp = "^(\\w{6}\\d{2}\\w\\d{2}\\w\\d{3}\\w)$",
            message = "wrong formatting for tax code")
    private String taxCode;
    @Valid
    private AddressDto address;

    public PersonDto(String name, String surname, Date birthday, String taxCode, AddressDto address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.taxCode = taxCode;
        this.address = address;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}

