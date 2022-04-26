package org.library.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Magazine implements Title {
  private String name;
  private int lendingTime = 10;
  private  Integer id;
  @Autowired
  private Storage storage;
  private Integer userLibraryId;

  public Magazine() { }

  public Magazine(String name,Integer id, Integer userLibraryId) {
    this.name = name;
    this.id = id;
    // da capire perchè non funziona
    //storage.addStorageProperty(id, userLibraryId);

    Storage.getIstance().addStorageProperty(id, userLibraryId);
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
  public Integer getUserLibraryId() {
    return userLibraryId;
  }

  public void setUserLibraryId(Integer userLibraryId) {
    this.userLibraryId = userLibraryId;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getLendingTime() {
    return lendingTime;
  }
}
