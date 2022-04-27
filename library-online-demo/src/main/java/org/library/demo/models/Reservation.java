package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;

public class Reservation {
//  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private Date creationDate;
  private String titleId;
  private String userTaxCode;

  public Reservation() {
  }

  public Reservation(String title_id, String tax_code, java.sql.Date creation_date) {
    this.creationDate = creation_date;
    this.titleId = title_id;
    this.userTaxCode = tax_code;
  }

  public Reservation(String title_id, String tax_code) {
    this.titleId = title_id;
    this.userTaxCode = tax_code;
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
