package it.aesys.course.library.demo.springboot.dao;

import it.aesys.course.library.demo.springboot.dao.exception.DaoException;

import java.sql.SQLException;

public interface GenericDao<T, IdType> {

    T add(T entity) throws DaoException;
    void delete(IdType id) throws DaoException;
    T update(IdType id, T entity) throws DaoException;
    T get(IdType id) throws DaoException;
}
