package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.util.Date;

public class Loan {
  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private Date creationDate;
  private String titleId;
  private int userLibraryId;
  private String taxCode;

  public Loan(String title_id, String tax_code, java.sql.Date creation_date) {
    this.creationDate = new Date();
  }

  public Loan(Date creationDate, String titleId) {
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

  public String getTitleId() {
    return titleId;
  }

  public void setTitleId(String titleId) {
    this.titleId = titleId;
  }

  public int getUserLibraryId() {
    return userLibraryId;
  }

  public void setUserLibraryId(int userLibraryId) {
    this.userLibraryId = userLibraryId;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }
}
