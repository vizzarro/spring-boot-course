package org.library.demo.dao;

import java.sql.Connection;

public interface BaseDao<T,K> {

    T get(K id);

    K create(T obj);

    T update(T obj, K id);

    void delete(K obj);

    Connection connect() throws ClassNotFoundException;

    void disconnect();

}
