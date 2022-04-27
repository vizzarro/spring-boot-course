package it.aesys.course.library.demo.springboot.service;


import it.aesys.course.library.demo.springboot.dao.TitleDao;
import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.dto.TitleDto;
import it.aesys.course.library.demo.springboot.models.Title;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TitleServiceImpl implements GenericService<TitleDto, String> {

    @Autowired
    private TitleDao titleDao;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TitleDto add(TitleDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(titleDao.add(modelMapper.map(dtoObject, Title.class)), TitleDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public TitleDto get(String id) throws ServiceException {
        try {
            return modelMapper.map(titleDao.get(id), TitleDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public TitleDto update(String id, TitleDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(titleDao.update(id, modelMapper.map(dtoObject, Title.class)), TitleDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public void delete(String id) throws ServiceException {
        try {
            titleDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
