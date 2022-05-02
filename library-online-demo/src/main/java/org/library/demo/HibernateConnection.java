package org.library.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateConnection {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/AcademyJava?useSSL=false&serverTimezone=UTC";
		String user = "postgres";
		String password = "29081990";

		try {
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("connessione al db riuscita");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
