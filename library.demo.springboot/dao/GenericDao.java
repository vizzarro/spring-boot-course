package org.library.demo.dao;

import java.sql.SQLException;

public interface GenericDao<T, D> {

    T add(T entity) throws SQLException, ClassNotFoundException;
    T delete(D id) throws SQLException, ClassNotFoundException;
    T update(D id, T entity) throws SQLException, ClassNotFoundException;
    T get(D id) throws SQLException, ClassNotFoundException;
}
