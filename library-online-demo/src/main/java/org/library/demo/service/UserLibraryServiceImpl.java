package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.connection.BaseDao;
import org.library.demo.repository.connection.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;

@Service
public class UserLibraryServiceImpl implements UserLibraryService {


  private BaseDao<UserLibrary, String> repo;
  @Autowired
  public UserLibraryServiceImpl(BaseDao<UserLibrary, String> userLibraryRepository) {
    this.repo = userLibraryRepository;
  }

  @Override
  public void addUserLibrary(UserLibrary newUserLibrary) throws Exception {
    if (!StringUtils.hasLength(newUserLibrary.getFirstName()))
      throw new Exception("New UserLibrary must have a valid name!");

    if (!StringUtils.hasLength(newUserLibrary.getLastName()))
      throw new Exception("New UserLibrary must have a valid surname!");

    if (!StringUtils.hasLength(newUserLibrary.getTaxCode()))
      throw new Exception("New UserLibrary must have a valid tax code!");

    repo.add(newUserLibrary);
  }

  @Override
  public UserLibrary getUserLibrary(String taxCode) throws SQLException {
    return repo.getById(taxCode);
  }
}
