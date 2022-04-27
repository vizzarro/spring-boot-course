package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;

public class Reservation {
  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private Date creationDate;
  private int titleId;
  private String taxCode;

  public Reservation() {
    this.creationDate = new Date();
  }

  public Reservation(Date creationDate, int titleId) {
    this.creationDate = creationDate;
    this.titleId = titleId;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    if (creationDate != null)
      this.creationDate = creationDate;
  }

  public int getTitleId() {
    return titleId;
  }

  public void setTitleId(int titleId) {
    this.titleId = titleId;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }
}
