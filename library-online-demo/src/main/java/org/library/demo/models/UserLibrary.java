package org.library.demo.models;

import java.util.ArrayList;
import java.util.List;

public class UserLibrary {
  private String firstName;
  private String lastName;
  private String taxCode;
  private List<Title> titleMockedDb;
  private List<Reservation> mockedTable;

  public UserLibrary() { }

  public UserLibrary(String firstName, String lastName, String taxCode) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.taxCode = taxCode;
    this.titleMockedDb = new ArrayList<>();
    this.mockedTable = new ArrayList<>();
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
