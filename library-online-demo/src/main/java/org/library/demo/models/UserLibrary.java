package org.library.demo.models;

import java.util.ArrayList;
import java.util.List;

public class UserLibrary {
  private String firstName;
  private String lastName;
  private String taxCode;

  public UserLibrary(String tax_code, String first_name, String last_name) {
    this.taxCode = tax_code;
    this.firstName = first_name;
    this.lastName = last_name;
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
