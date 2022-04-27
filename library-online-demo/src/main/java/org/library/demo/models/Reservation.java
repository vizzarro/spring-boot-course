package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;

public class Reservation {
  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private Date creationDate;
  private String titleId;
  private int borrowerId;
  private String taxCode;

  public Reservation(String title_id, String tax_code, java.sql.Date creation_date) {
    this.creationDate = new Date();
  }

  public Reservation(Date creationDate, int titleId) {
    this.creationDate = creationDate;
    this.titleId = getTitleId();
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    if (creationDate != null)
      this.creationDate = creationDate;
  }

  public String getTitleId() {
    return titleId;
  }

  public void setTitleId(String titleId) {
    this.titleId = titleId;
  }

  public int getBorrowerId() {
    return borrowerId;
  }

  public void setBorrowerId(int borrowerId) {
    this.borrowerId = borrowerId;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }
}
