package it.aesys.course.library.demo.springboot.hybernate.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="reservation_id")
  private int reservationId;
  @Column(name="title_id", insertable=false, updatable=false)
  private String titleId;
  @Column(name="tax_code", insertable=false, updatable=false)
  private String taxCode;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @Column(name="creation_date")
  private Date creationDate;

  @ManyToOne(cascade={CascadeType.DETACH, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name="tax_code")
  private UserLibrary user;

  @ManyToOne(cascade={CascadeType.DETACH, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name="title_id")
  private Title title;

  public Reservation() {
  }

  public int getReservationId() {
    return reservationId;
  }

  public void setReservationId(int reservationId) {
    this.reservationId = reservationId;
  }

  public UserLibrary getUser() {
    return user;
  }



  public void setUser(UserLibrary user) {
    this.user = user;
  }

  public Title getTitle() {
    return title;
  }

  public void setTitle(Title title) {
    this.title = title;
  }

  public String getTitleId() {
    return titleId;
  }

  public void setTitleId(String titleId) {
    this.titleId = titleId;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
}
