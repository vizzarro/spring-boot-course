package org.library.demo.service;

import org.library.demo.models.UserLibrary;

public interface UserLibraryService {
  UserLibrary getUserLibrary(String id);
  void addUserLibrary(UserLibrary newUserLibrary);
  void deleteUserLibrary(String id);
  UserLibrary updateUserLibrary(String id, UserLibrary updated);


}
