package it.aesys.infopeople.infopeople.model;

import javax.validation.constraints.Size;

public class Address {

    private String road;
    private String houseNumber;
    private String city;
    private String region;
    private String country;
    private String ZIPCode;

    public Address() {}

    public Address(String road, String houseNumber, String city, String region, String country, String ZIPCode) {

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
