package org.library.demo.dtos;

import org.library.demo.models.UserLibrary;

public class UserLibraryDto {

    private String firstName;
    private String lastName;
    private String taxCode;

    public UserLibraryDto() {
    }

    public UserLibraryDto(String firstName, String lastName, String taxCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxCode = taxCode;
    }

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
