package org.library.demo.service;

import org.library.demo.models.UserLibrary;

public interface BorrowerService {
  void addBorrower(UserLibrary newUserLibrary) throws Exception;
  UserLibrary getBorrower(int id);

}
