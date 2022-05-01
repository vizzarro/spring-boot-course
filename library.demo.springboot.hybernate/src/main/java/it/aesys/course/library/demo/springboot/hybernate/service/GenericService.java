package it.aesys.course.library.demo.springboot.hybernate.service;

import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;

public interface GenericService<D , IdType> {

    D add(D dtoObject) throws ServiceException;
    D get(IdType id) throws ServiceException;
    D update(IdType id, D dtoObject) throws ServiceException;
    void delete(IdType id) throws ServiceException;

}
