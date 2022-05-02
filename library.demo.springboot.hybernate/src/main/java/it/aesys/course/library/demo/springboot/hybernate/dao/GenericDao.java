package it.aesys.course.library.demo.springboot.hybernate.dao;


import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;

import java.util.List;

public interface GenericDao<T, IdType> {

    List<T> getAll() throws DaoException;

    T add(T entity) throws DaoException;

    void delete(IdType id) throws DaoException;

    T update(IdType id, T entity) throws DaoException;

    T get(IdType id) throws DaoException;
}
