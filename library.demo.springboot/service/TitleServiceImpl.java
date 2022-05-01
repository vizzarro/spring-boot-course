package org.library.demo.service;

import org.library.demo.dao.TitleDao;
import org.library.demo.dtos.TitleDto;
import org.library.demo.models.Title;
import org.library.demo.service.mapper.TitleModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TitleServiceImpl implements GenericService<TitleDto, String> {

    @Autowired
    private TitleDao titleDao;
    @Autowired
    private TitleModelMapper modelMapper;

    @Override
    public TitleDto add(TitleDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(titleDao.add(modelMapper.toModelObject(dtoObject, Title.class)), TitleDto.class);
    }

    @Override
    public TitleDto get(String id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(titleDao.get(id), TitleDto.class);
    }

    @Override
    public TitleDto update(String id, TitleDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(titleDao.update(id, modelMapper.toModelObject(dtoObject, Title.class)), TitleDto.class);

    }

    @Override
    public TitleDto delete(String id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(titleDao.delete(id), TitleDto.class);
    }
}
