package org.library.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;


public interface Title {
  String getName();
  int getLendingTime();
  String getTitleId();
  String getType();

}
