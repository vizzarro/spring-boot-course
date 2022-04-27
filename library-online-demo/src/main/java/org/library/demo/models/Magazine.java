package org.library.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Magazine implements Title {
  private String name;
  private String titleId;
  private int lendingTime = 10;
  private  Integer id;
  @Autowired
  private Storage storage;
  private Integer userLibraryId;
  private String type = "MAGAZINE";

  public Magazine() { }

  public Magazine(String name,Integer id, Integer userLibraryId) {
    this.name = name;
    this.id = id;
    this.userLibraryId = userLibraryId;
  }

  public Magazine(String name, String title_id) {
    this.name = name;
    this.titleId = title_id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String getTitleId() {
    return titleId;
  }

  @Override
  public String getType() {
    return type;
  }

  public void setTitleId(String titleId) {
    this.titleId = titleId;
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
  public Integer getUserLibraryId() {
    return userLibraryId;
  }
}
