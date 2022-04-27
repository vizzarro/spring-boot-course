package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.util.Date;

public class Loan {
  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private Date creationDate;
  private String titleId;
  private String userTaxCode;

  public Loan() {
    this.creationDate = new Date();
  }

  public Loan(String titleId, String userTaxCode) {
    this.titleId = titleId;
    this.userTaxCode=userTaxCode;
  }

  public Loan(String titleId, String userLibraryId,Date creationDate) {
    this.creationDate = creationDate;
    this.titleId = titleId;
    this.userTaxCode = userLibraryId;
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

  public String getUserTaxCode() {
    return userTaxCode;
  }

  public void setUserTaxCode(String userTaxCode) {
    this.userTaxCode = userTaxCode;
  }
}
