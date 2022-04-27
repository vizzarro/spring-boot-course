package org.library.demo.service;

import org.library.demo.dao.UserLibraryDao;
import org.library.demo.dtos.UserLibraryDto;
import org.library.demo.models.UserLibrary;
import org.library.demo.service.mapper.UserModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements GenericService<UserLibraryDto, String> {

    @Autowired
    private UserLibraryDao userDao;
    @Autowired
    private UserModelMapper modelMapper;

    @Override
    public UserLibraryDto add(UserLibraryDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(userDao.add(modelMapper.toModelObject(dtoObject, UserLibrary.class)), UserLibraryDto.class);
    }

    @Override
    public UserLibraryDto get(String id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(userDao.get(id), UserLibraryDto.class);
    }

    @Override
    public UserLibraryDto update(String id, UserLibraryDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(userDao.update(id, modelMapper.toModelObject(dtoObject, UserLibrary.class)), UserLibraryDto.class);
    }

    @Override
    public UserLibraryDto delete(String id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(userDao.delete(id), UserLibraryDto.class);
    }
}
