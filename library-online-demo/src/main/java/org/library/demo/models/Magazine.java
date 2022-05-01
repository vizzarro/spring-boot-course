package org.library.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "title")
public class Magazine implements Title {
  @Column(name = "name")
  private String name;
  @Id
  @Column(name = "title_id")
  private String titleId;
  @Column(name = "lending_time")
  private int lendingTime = 10;
  @Column(name = "type")
  private  String type="MAGAZINE";

  public Magazine() { }

  public Magazine(String name, String titleId) {
    this.name = name;
    this.titleId = titleId;
  }

  public Magazine(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }


  public int getLendingTime() {
    return lendingTime;
  }

  @Override
  public String getTitleId() {
    return titleId;
  }

  @Override
  public String getType() {
    return type;
  }

  public void setLendingTime(int lendingTime) {
    this.lendingTime = lendingTime;
  }
}
