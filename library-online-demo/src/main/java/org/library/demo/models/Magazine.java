package org.library.demo.models;

public class Magazine implements Title {
  private String name;
  private int lendingTime = 10;
  private int titleId;

  public Magazine() { }

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
  public int getTitleId() {
    return titleId;
  }

  public void setTitleId(int titleId) {
    this.titleId = titleId;
  }

}
