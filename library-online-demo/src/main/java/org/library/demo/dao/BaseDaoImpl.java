package org.library.demo.dao;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.sql.*;

public abstract class BaseDaoImpl<T, U> implements BaseDao<T, U> {

    private Connection connection = null;

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return connection;
    }

    public void disconnect(){

        if(connection != null){
            try{
                connection.close();
                connection = null;
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
