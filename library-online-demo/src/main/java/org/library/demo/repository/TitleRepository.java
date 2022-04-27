package org.library.demo.repository;

import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Storage;
import org.library.demo.models.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TitleRepository implements GenericRepository<Title> {
  private List<Title> titleMockedDb;
  @Autowired
  private Storage storage;



  public TitleRepository() {
    this.titleMockedDb = new ArrayList<>() {{
      add(new Book("Lord of the Ring: The Fellowship of the Ring", 0, 0));
      add(new Book("Lord of the Ring: The Two Towers", 1, 0));
      add(new Book("Lord of the Ring: The Return of the King", 2, 0));
      add(new Book("The Hobbit: An Unexpected Journey", 3, 1));
      add(new Book("The Hobbit: The Desolation of Smaug", 4, 1));
      add(new Book("The Hobbit: The Battle of Five Armies", 5, 0));
      add(new Book("The Silmarillion", 6, 0));
      add(new Magazine("Focus", 7, 1));
      add(new Magazine("Wired", 8, 0));
      add(new Magazine("Cosmopolitan", 9, 0));
      add(new Magazine("Time", 10, 1));
    }};
  }

  @Override
  public Title getById(int id) {
    return this.titleMockedDb.get(id - 1);
  }

  @Override
  public void add(Title entity) {
    storage.addStorageProperty(this.titleMockedDb.size(), entity.getUserLibraryId());
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
