package it.aesys.infopeople.infopeople.dtos;

import it.aesys.infopeople.infopeople.model.Address;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class PersonDto {


    @Pattern(regexp = "^([a-z,A-Z]|\\'|[ÀÈÌÒÙYàèìòù])+$")
    private String name;
    @Pattern(regexp = "^([a-z,A-Z]|\\'|[ÀÈÌÒÙYàèìòù])+$")
    private String surname;
    @NotNull
    private Date birthday;
    @Pattern(regexp = "^(\\w{6}\\d{2}\\w\\d{2}\\w\\d{3}\\w)$")
    private String taxCode;
    @Valid
    private AddressDto addressDto;

    public PersonDto(String name, String surname, Date birthday, String taxCode, AddressDto address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.taxCode = taxCode;
        this.addressDto = address;
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

