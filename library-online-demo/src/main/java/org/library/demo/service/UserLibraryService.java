package org.library.demo.service;

import org.library.demo.models.UserLibrary;

public interface UserLibraryService {
  void addUserLibrary(UserLibrary newUserLibrary) throws Exception;
  UserLibrary getUserLibrary(String taxCode);

}
