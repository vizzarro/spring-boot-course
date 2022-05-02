package it.aesys.infopeople.infopeople.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "road")
    private String road;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "country")
    private String country;
    @Column(name = "zip_Code")
    private String zipCode;

    public Address() {
    }

    public Address(String road, String houseNumber, String city, String region, String country, String ZIPCode) {

        this.road = road;
        this.houseNumber = houseNumber;
        this.city = city;
        this.region = region;
        this.country = country;
        this.zipCode = ZIPCode;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
