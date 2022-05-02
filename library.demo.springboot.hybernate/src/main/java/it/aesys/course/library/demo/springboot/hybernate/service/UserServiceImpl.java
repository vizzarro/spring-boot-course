package it.aesys.course.library.demo.springboot.hybernate.service;


import it.aesys.course.library.demo.springboot.hybernate.dao.LoanDao;
import it.aesys.course.library.demo.springboot.hybernate.dao.UserLibraryDao;
import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.dto.UserLibraryDto;
import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements GenericService<UserLibraryDto, String> {

    private UserLibraryDao userDao;

    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(){
        this.userDao = new UserLibraryDao();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<UserLibraryDto> getAll() throws ServiceException {
        return null;
    }

    @Override
    public UserLibraryDto add(UserLibraryDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(userDao.add(modelMapper.map(dtoObject, UserLibrary.class)), UserLibraryDto.class);
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
    }

    @Override
    public UserLibraryDto get(String id) throws ServiceException {
        try {
            return modelMapper.map(userDao.get(id), UserLibraryDto.class);
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
    }

    @Override
    public UserLibraryDto update(String id, UserLibraryDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(userDao.update(id, modelMapper.map(dtoObject, UserLibrary.class)), UserLibraryDto.class);
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
    }

    @Override
    public void delete(String id) throws ServiceException {
        try {
            userDao.delete(id);
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
    }
}
