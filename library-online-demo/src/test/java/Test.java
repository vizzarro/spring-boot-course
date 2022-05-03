import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.library.demo.models.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/AcademyJava?useSSL=false&serverTimezone=UTC";
        String user = "postgres";
        String password = "password";

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("connessione al db riuscita");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Loan.class)
                .addAnnotatedClass(Magazine.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(UserLibrary.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            UserLibrary us = session.get(UserLibrary.class,1);
            System.out.println(us);
            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }
    }

}
