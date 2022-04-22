package it.aesys.infopeople.infopeople.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressDto {
    @NotBlank
    private String road;
    @Pattern(regexp = "^([1-9])(\\d*)(\\{1}[A-Z,a-z])?$")
    private String houseNumber;
    @Pattern(regexp = "^[a-z,A-Z]+$")
    private String city;
    @Pattern(regexp = "^[a-z,A-Z]+$")
    private String region;
    @Pattern(regexp = "^[a-z,A-Z]+$")
    private String country;
    @Pattern(regexp = "^\\d{5}$")
    private String ZIPCode;

    public AddressDto() {}

    public AddressDto(String road, String houseNumber, String city, String region, String country, String ZIPCode) {
        this.road = road;
        this.houseNumber = houseNumber;
        this.city = city;
        this.region = region;
        this.country = country;
        this.ZIPCode = ZIPCode;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZIPCode() {
        return ZIPCode;
    }

    public void setZIPCode(String ZIPCode) {
        this.ZIPCode = ZIPCode;
    }
}
