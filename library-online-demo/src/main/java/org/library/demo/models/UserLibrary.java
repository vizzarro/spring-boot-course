package org.library.demo.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserLibrary {

  private String firstName;
  private String lastName;
  private String id;

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


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
