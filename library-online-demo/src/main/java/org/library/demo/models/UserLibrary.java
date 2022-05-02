package org.library.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "user")
public class UserLibrary {
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Id
  @Column(name = "tax_code")
  private String taxCode;
 //private List<Title> titleMockedDb;
 @OneToMany(mappedBy = "userLibrary")
  private List<Reservation> reservations = new ArrayList<>();

  public UserLibrary() { }

  public UserLibrary(String firstName, String lastName, String taxCode) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.taxCode = taxCode;
   // this.titleMockedDb = new ArrayList<>();
    //this.mockedTable = new ArrayList<>();
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
