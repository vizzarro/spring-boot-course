package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.exception.DaoException;
import org.library.demo.service.exceptions.ServiceException;

import java.sql.SQLException;

public interface UserLibraryService {
  void addBorrower(UserLibrary newUserLibrary) throws Exception;
  UserLibrary getBorrower(String id);
  void deleteUser(String id) throws ClassNotFoundException, SQLException, DaoException, ServiceException;

}
