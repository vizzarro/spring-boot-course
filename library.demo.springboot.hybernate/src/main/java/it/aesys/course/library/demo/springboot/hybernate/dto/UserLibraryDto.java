package it.aesys.course.library.demo.springboot.hybernate.dto;

import org.springframework.stereotype.Component;

@Component
public class UserLibraryDto {

    private String firstName;
    private String lastName;
    private String taxCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
}
