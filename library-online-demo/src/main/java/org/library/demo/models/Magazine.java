package org.library.demo.models;

public class Magazine implements Title {
  private String name;
  private String titleId;
  private int lendingTime = 10;
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

  @Override
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
