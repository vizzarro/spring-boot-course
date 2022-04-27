package org.library.demo.repository.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaseDao <T> {
    Connection getConnection();
    void closeConnection(Connection conn) throws SQLException;
}
