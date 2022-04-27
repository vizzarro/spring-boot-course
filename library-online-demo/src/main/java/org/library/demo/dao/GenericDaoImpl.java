package org.library.demo.dao;

import java.sql.*;

public abstract class GenericDaoImpl<T, D> implements GenericDao<T, D> {



    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/AcademyJava";
        return DriverManager.getConnection(url ,"postgres", "naomi92");
    }





}
