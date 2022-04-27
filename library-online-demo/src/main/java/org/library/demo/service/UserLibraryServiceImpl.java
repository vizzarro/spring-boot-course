package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserLibraryServiceImpl implements UserLibraryService {

    private BaseDao<UserLibrary, String> userLibraryDao;

    @Autowired
    public UserLibraryServiceImpl(BaseDao<UserLibrary, String> userLibraryDao) {
        this.userLibraryDao = userLibraryDao;
    }

    @Override
    public UserLibrary getUserLibrary(String id) {
        return userLibraryDao.getById(id);
    }

    @Override
    public void addUserLibrary(UserLibrary newUserLibrary) {
        userLibraryDao.add(newUserLibrary);
    }

    @Override
    public void deleteUserLibrary(String id) {
        userLibraryDao.delete(id);
    }

    @Override
    public UserLibrary updateUserLibrary(String id, UserLibrary updated) {
        return this.userLibraryDao.update(id, updated);
    }
}
