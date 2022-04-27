package org.library.demo.service;

import org.library.demo.dao.UserLibraryDao;
import org.library.demo.models.UserLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;

@Service
public class UserLibraryServiceImpl implements UserLibraryService {

    private UserLibraryDao dao;

    @Autowired
    public UserLibraryServiceImpl(UserLibraryDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUserLibrary(UserLibrary newUserLibrary) throws Exception {
        if (!StringUtils.hasLength(newUserLibrary.getFirstName()))
            throw new Exception("New UserLibrary must have a valid name!");

        if (!StringUtils.hasLength(newUserLibrary.getLastName()))
            throw new Exception("New UserLibrary must have a valid surname!");

        if (!StringUtils.hasLength(newUserLibrary.getTaxCode()))
            throw new Exception("New UserLibrary must have a valid tax code!");

        dao.create(newUserLibrary);
    }

    @Override
    public UserLibrary getUserLibrary(String id) throws SQLException {
        return dao.get(id);
    }
}
