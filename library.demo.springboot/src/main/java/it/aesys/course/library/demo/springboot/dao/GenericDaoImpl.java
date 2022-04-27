package it.aesys.course.library.demo.springboot.dao;

import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDaoImpl<T, D> implements GenericDao<T, D> {

    @Value("${database-setting.db}")
    private String db;
    @Value("${database-setting.host}")
    private String host;
    @Value("${database-setting.port}")
    private String port;
    @Value("${database-setting.schema}")
    private String schema;
    @Value("${database-setting.driver}")
    private String driver;
    @Value("${database-setting.credentials.username}")
    private String username;
    @Value("${database-setting.credentials.password}")
    private String password;

    public Connection getConnection() throws DaoException {
        try {
            Class.forName(driver);

            String url = "jdbc:" + db + "://" + host + ":"+ port + "/" + schema;
            return DriverManager.getConnection(url ,username, password);
        }catch (ClassNotFoundException | SQLException e) {
            DaoException daoException = new DaoException(e.getMessage());
            throw daoException;
        }
    }





}
