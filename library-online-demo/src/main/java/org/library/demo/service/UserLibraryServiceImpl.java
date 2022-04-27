package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericDao;
import org.library.demo.repository.exception.DaoException;
import org.library.demo.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.sql.SQLException;

@Service
public class UserLibraryServiceImpl implements UserLibraryService {
  private GenericDao<UserLibrary,String> repo;

  public UserLibraryServiceImpl(GenericDao<UserLibrary,String> borrowerRepository) {
    this.repo = borrowerRepository;
  }

  @Override
  public void addBorrower(UserLibrary newUserLibrary) throws Exception {
    if (!StringUtils.hasLength(newUserLibrary.getFirstName()))
      throw new Exception("New UserLibrary must have a valid name!");

    if (!StringUtils.hasLength(newUserLibrary.getLastName()))
      throw new Exception("New UserLibrary must have a valid surname!");

    if (!StringUtils.hasLength(newUserLibrary.getTaxCode()))
      throw new Exception("New UserLibrary must have a valid tax code!");

    repo.add(newUserLibrary);
  }

  @Override
  public UserLibrary getBorrower(String id) {
    return repo.getById(id);
  }

  @Override
  public void deleteUser(String id) throws ClassNotFoundException, SQLException, DaoException, ServiceException {
    this.repo.delete(id);
  }
}
