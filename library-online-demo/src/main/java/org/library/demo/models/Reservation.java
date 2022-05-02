package org.library.demo.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
//  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  @Column(name = "creation_date")
  private String creationDate;

  @ManyToOne
  @JoinColumn(name = "tax_code")
  private UserLibrary userLibrary;
  @ManyToOne
  @JoinColumn(name = "title_id")
  private Book book;

  @EmbeddedId
  private ReservationKey id = new ReservationKey();

  public Reservation() {
  }

  public Reservation(String creationDate, UserLibrary userLibrary, Book book) {
    this.creationDate = creationDate;
    this.userLibrary = userLibrary;
    this.book = book;
  }

  public String getCreationDate() {
    return creationDate;
  }


  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public UserLibrary getUserLibrary() {
    return userLibrary;
  }

  public void setUserLibrary(UserLibrary userLibrary) {
    this.userLibrary = userLibrary;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public ReservationKey getId() {
    return id;
  }

  public void setId(ReservationKey id) {
    this.id = id;
  }
}
