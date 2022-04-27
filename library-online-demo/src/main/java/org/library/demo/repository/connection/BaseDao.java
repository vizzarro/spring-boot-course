package org.library.demo.repository.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaseDao <T,K> {
    Connection getConnection();
    void closeConnection(Connection conn) throws SQLException;
    T getById(K id) throws SQLException;
    void add(T entity) throws SQLException;
    void delete(K id) throws SQLException;
    T update(K id, T updated) throws SQLException;
    T getByTaxCode(K taxCode);
}
