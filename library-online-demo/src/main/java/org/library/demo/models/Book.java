package org.library.demo.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "title1")
public class Book implements Title {
  @Column(name = "name")
  private String name;
  @Id
  @Column(name = "title_id")
  private String titleId;
  @Column(name = "lending_time")
  private int lendingTime = 30;
  @Column(name = "type")
  private String type="BOOK";

  @OneToMany(mappedBy = "book")
  private List<Reservation> reservations = new ArrayList<>();

  public Book() { }

  public Book(String name, String titleId) {
    this.name = name;
    this.titleId = titleId;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Book(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int getLendingTime() {
   return lendingTime;
  }

  public String getTitleId() {
    return titleId;
  }

  public void setTitleId(String titleId) {
    this.titleId = titleId;
  }

  public  String getType() {
    return type;
  }

}
