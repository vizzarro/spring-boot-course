package org.library.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaseDao<T, K> {

    T get(K id) throws SQLException;

    K create(T obj) throws SQLException;

    T update(T obj) throws SQLException;

    void delete(K obj) throws SQLException;

    Connection connect() throws ClassNotFoundException;

    void disconnect();

}
