package it.aesys.course.library.demo.springboot.service;

import it.aesys.course.library.demo.springboot.dao.UserLibraryDao;
import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.dto.UserLibraryDto;
import it.aesys.course.library.demo.springboot.models.UserLibrary;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements GenericService<UserLibraryDto, String> {

    @Autowired
    private UserLibraryDao userDao;
    private ModelMapper modelMapper;

    public UserServiceImpl(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public UserLibraryDto add(UserLibraryDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(userDao.add(modelMapper.map(dtoObject, UserLibrary.class)), UserLibraryDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public UserLibraryDto get(String id) throws ServiceException {
        try {
            return modelMapper.map(userDao.get(id), UserLibraryDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public UserLibraryDto update(String id, UserLibraryDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(userDao.update(id, modelMapper.map(dtoObject, UserLibrary.class)), UserLibraryDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws ServiceException {
        try {
            userDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
