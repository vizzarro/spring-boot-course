package org.library.demo.models;

public class Book implements Title {
  private String name;
  private String id;

  public Book() { }

  public Book(String name, String id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Book{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }
}
