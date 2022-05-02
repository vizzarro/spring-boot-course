package it.aesys.course.library.demo.springboot.hybernate.service;

import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;

import java.util.List;

public interface GenericService<D , IdType> {
    List<D> getAll() throws ServiceException;
    D add(D dtoObject) throws ServiceException;
    D get(IdType id) throws ServiceException;
    D update(IdType id, D dtoObject) throws ServiceException;
    void delete(IdType id) throws ServiceException;

}
