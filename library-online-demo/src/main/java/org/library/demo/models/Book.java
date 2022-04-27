package org.library.demo.models;

public class Book implements Title {
  private String name;
  private int lendingTime = 30;
  private int titleId;

  public Book() { }

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

  @Override
  public int getTitleId() {
    return titleId;
  }

  public void setTitleId(int titleId) {
    this.titleId = titleId;
  }

}
