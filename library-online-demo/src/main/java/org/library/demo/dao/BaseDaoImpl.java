package org.library.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDaoImpl<T, K> implements BaseDao<T, K> {

    private static final String URL = "jdbc:postgresql://localhost:5432/AcademyJava";
    private static final String USER = "postgres";
    private static final String PWD = "password";
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    protected Connection connection = null;

    @Override
    public Connection connect() {
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {/*Do Nothing*/}
        }
    }
}
