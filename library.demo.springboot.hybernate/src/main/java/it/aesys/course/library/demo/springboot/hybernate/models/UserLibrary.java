package it.aesys.course.library.demo.springboot.hybernate.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_library")
public class UserLibrary {

  @Column(name="first_name")
  private String firstName;
  @Column(name="last_name")
  private String lastName;
  @Id
  @Column(name="tax_code")
  private String id;

  @OneToMany(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy="user")
  private List<Reservation> userReservations;

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

  public List<Reservation> getUserReservations() {
    return userReservations;
  }

  public void setUserReservations(List<Reservation> userReservations) {
    this.userReservations = userReservations;
  }

  public void addUser(Reservation reservation){
    this.userReservations.add(reservation);
  }

}
