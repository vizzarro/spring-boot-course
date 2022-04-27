package org.library.demo.dao;

import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.UserLibrary;
import org.springframework.stereotype.Repository;

@Repository
public class UserLibraryDaoImpl extends BaseDaoImpl<UserLibrary, String> implements UserLibraryDao {

  @Override
  public UserLibrary get(String id) {
    return null;
  }

  @Override
  public String create(UserLibrary obj) {
    return null;
  }

  @Override
  public UserLibrary update(UserLibrary obj) {
    return null;
  }

  @Override
  public void delete(String id) {

  }
}
