package org.library.demo.service;

import org.library.demo.dao.UserLibraryDao;
import org.library.demo.dao.UserLibraryDaoImpl;
import org.library.demo.models.UserLibrary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;

@Service
public class BorrowerServiceImpl implements BorrowerService {
  private UserLibraryDao dao;

  public BorrowerServiceImpl(UserLibraryDao dao) {
    this.dao = dao;
  }

  @Override
  public void addBorrower(UserLibrary newUserLibrary) throws Exception {
    if (!StringUtils.hasLength(newUserLibrary.getFirstName()))
      throw new Exception("New UserLibrary must have a valid name!");

    if (!StringUtils.hasLength(newUserLibrary.getLastName()))
      throw new Exception("New UserLibrary must have a valid surname!");

    if (!StringUtils.hasLength(newUserLibrary.getTaxCode()))
      throw new Exception("New UserLibrary must have a valid tax code!");

    dao.create(newUserLibrary);
  }

  @Override
  public UserLibrary getBorrower(String id) throws SQLException {
    return dao.get(id);
  }
}
