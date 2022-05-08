package it.aesys.course.library.demo.springboot;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:postgresql://localhost:5432/AcademyJava";
        String user="postgres";
        String password="admin";

        try {
            Connection conn= DriverManager.getConnection(jdbcUrl,user,password );
            System.out.println("Connected");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
