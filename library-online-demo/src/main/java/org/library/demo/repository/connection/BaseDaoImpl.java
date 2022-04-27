package org.library.demo.repository.connection;

import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Repository
public abstract class BaseDaoImpl<T,K> implements BaseDao<T,K> {
    private Connection conn = null;

    @Override
    public Connection getConnection() {
        Properties propr = new Properties();
        propr.setProperty("user", "user");
        propr.setProperty("password", "29081990");
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
    public void closeConnection(Connection conn) {

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
