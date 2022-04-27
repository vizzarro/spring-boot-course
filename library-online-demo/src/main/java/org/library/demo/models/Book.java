package org.library.demo.models;

public class Book implements Title {
  private String name;
  private String titleId;
  private int lendingTime = 30;
  private String type="BOOK";

  public Book() { }

  public Book(String name, String titleId) {
    this.name = name;
    this.lendingTime = lendingTime;
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
