package org.library.demo.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Repository
public abstract class GenericDaoImpl<T,K> implements GenericDao<T,K> {
    private Connection conn;

    public  Connection getConnection() {
Connection conn=null;
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/AcademyJava";
            Properties propr = new Properties();
            propr.setProperty("user", "postgres");
            propr.setProperty("password", "andrea");

             conn = DriverManager.getConnection(url, propr);

        } catch (ClassNotFoundException e) {
            System.out.println("DB connection Error");
        }  catch (SQLException e) {
            System.out.println("DB connection Error");
        }
        return conn;
    }



    public void deleteConnection(Connection conn)  {
        if(null!=conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

}