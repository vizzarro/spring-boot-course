package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.util.Date;

public class Loan {
  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private Date creationDate;
  private int titleId;
  private int userLibraryId;

  public Loan() {
    this.creationDate = new Date();
  }

  public Loan(Date creationDate, int titleId) {
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

  public int getUserLibraryId() {
    return userLibraryId;
  }

  public void setUserLibraryId(int userLibraryId) {
    this.userLibraryId = userLibraryId;
  }
}
