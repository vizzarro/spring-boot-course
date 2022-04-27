package org.library.demo.service;

import org.library.demo.models.UserLibrary;

import java.sql.SQLException;

public interface UserLibraryService {
    void addUserLibrary(UserLibrary newUserLibrary) throws Exception;

    UserLibrary getUserLibrary(String id) throws SQLException;

}
