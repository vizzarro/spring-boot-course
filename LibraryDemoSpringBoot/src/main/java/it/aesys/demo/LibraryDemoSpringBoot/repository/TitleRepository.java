package it.aesys.demo.LibraryDemoSpringBoot.repository;

import java.util.ArrayList;
import java.util.List;

import it.aesys.demo.LibraryDemoSpringBoot.models.Book;
import it.aesys.demo.LibraryDemoSpringBoot.models.Magazine;
import it.aesys.demo.LibraryDemoSpringBoot.models.Title;
import org.springframework.stereotype.Repository;

@Repository
public class TitleRepository implements GenericRepository<Title> {
  private List<Title> titleMockedDb;

  public TitleRepository() {
    this.titleMockedDb = new ArrayList<>() {{
      add(new Book("Lord of the Ring: The Fellowship of the Ring"));
      add(new Book("Lord of the Ring: The Two Towers"));
      add(new Book("Lord of the Ring: The Return of the King"));
      add(new Book("The Hobbit: An Unexpected Journey"));
      add(new Book("The Hobbit: The Desolation of Smaug"));
      add(new Book("The Hobbit: The Battle of Five Armies"));
      add(new Book("The Silmarillion"));
      add(new Magazine("Focus"));
      add(new Magazine("Wired"));
      add(new Magazine("Cosmopolitan"));
      add(new Magazine("Time"));
    }};
  }

  @Override
  public Title getById(int id) {
    return this.titleMockedDb.get(id - 1);
  }

  @Override
  public void add(Title entity) {
    this.titleMockedDb.add(entity);
  }

  @Override
  public void delete(int id) {
    this.titleMockedDb.remove(id - 1);
  }

  @Override
  public Title update(int id, Title updated) {
    Title found = getById(id);

    if (found != null)
      this.titleMockedDb.set(id - 1, updated);

    return getById(id);
  }
}
