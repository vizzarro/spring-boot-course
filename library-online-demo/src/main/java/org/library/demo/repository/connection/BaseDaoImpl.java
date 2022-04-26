package org.library.demo.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class BaseDaoImpl<T> implements BaseDao {
    private Connection conn = null;

    @Override
    public Connection getConnection() {
        Properties propr = new Properties();
        propr.setProperty("user", "postgres");
        propr.setProperty("password", "postgres");
        String url = "jdbc:postgresql://localhost:5432/AcademyJava";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, propr);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void closeConnection() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn = null;
    }
}
