package org.library.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "title")
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

  public Book() { }

  public Book(String name, String titleId) {
    this.name = name;
    this.titleId = titleId;
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
