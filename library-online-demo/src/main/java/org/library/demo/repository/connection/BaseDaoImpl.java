package org.library.demo.repository.connection;

import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Repository("baseDao")
public abstract class BaseDaoImpl<T,K> implements BaseDao<T,K> {


    @Override
    public Connection getConnection() {
        Connection conn = null;
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
    }


}
