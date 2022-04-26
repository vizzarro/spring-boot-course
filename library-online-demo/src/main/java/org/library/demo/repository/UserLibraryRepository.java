package org.library.demo.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.UserLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.context.ApplicationContext;

@Repository
public class UserLibraryRepository implements GenericRepository<UserLibrary> {
  private List<UserLibrary> mockedTable;
  @Autowired
  private UserDao userDao;

  public UserLibraryRepository() {
    this.mockedTable = new ArrayList<>();
  }

  @Override
  public UserLibrary getById(int id) {
    return this.mockedTable.get(id - 1);
  }

  public UserLibrary getByTaxCode(String taxCode) {
    try {

      if (userDao == null) {
       userDao = new UserDao();
      }

      return this.userDao.get(taxCode);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } return  null;
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
