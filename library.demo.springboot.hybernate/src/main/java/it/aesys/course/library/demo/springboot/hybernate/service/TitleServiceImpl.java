package it.aesys.course.library.demo.springboot.hybernate.service;



import it.aesys.course.library.demo.springboot.hybernate.dao.LoanDao;
import it.aesys.course.library.demo.springboot.hybernate.dao.TitleDao;
import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.dto.TitleDto;
import it.aesys.course.library.demo.springboot.hybernate.dto.UserLibraryDto;
import it.aesys.course.library.demo.springboot.hybernate.models.Title;
import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitleServiceImpl implements GenericService<TitleDto, String> {


    private TitleDao titleDao;

    private ModelMapper modelMapper;

    @Autowired
    public TitleServiceImpl(){
        this.titleDao = new TitleDao();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<TitleDto> getAll() throws ServiceException {
        List<TitleDto> titleDtos=new ArrayList<>();
        try {
            for(Title temp : titleDao.getAll()){
                titleDtos.add(modelMapper.map(temp,TitleDto.class));
            }
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
        return titleDtos;
    }


    @Override
    public TitleDto add(TitleDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(titleDao.add(modelMapper.map(dtoObject, Title.class)), TitleDto.class);
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
    }

    @Override
    public TitleDto get(String id) throws ServiceException {
        try {
            return modelMapper.map(titleDao.get(id), TitleDto.class);
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
    }

    @Override
    public TitleDto update(String id, TitleDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(titleDao.update(id, modelMapper.map(dtoObject, Title.class)), TitleDto.class);
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
            titleDao.delete(id);
        } catch (DaoException e) {
            ServiceException serviceException = new ServiceException(e.getMessage());
            serviceException.setPath(e.getPath());
            serviceException.setStatusCode(e.getStatusCode());
            throw serviceException;
        }
    }
}
