package org.library.demo.repository;

import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.UserLibrary;
import org.springframework.stereotype.Repository;

@Repository
public class UserLibraryRepository implements GenericRepository<UserLibrary> {
  private List<UserLibrary> mockedTable;

  public UserLibraryRepository() {
    this.mockedTable = new ArrayList<>();
  }

  @Override
  public UserLibrary getById(int id) {
    return this.mockedTable.get(id - 1);
  }

  @Override
  public void add(UserLibrary entity) {
    this.mockedTable.add(entity);
  }

  @Override
  public void delete(int id) {
    this.mockedTable.remove(id - 1);
  }

  @Override
  public UserLibrary update(int id, UserLibrary updated) {
    UserLibrary found = getById(id);

    if (found != null)
      this.mockedTable.set(id - 1, updated);

    return getById(id);
  }
}
