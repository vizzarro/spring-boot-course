package it.aesys.course.library.demo.springboot.hybernate;

import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJDBC {

    public static void main(String[] args) {

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("Ciao!");
        } catch (HibernateException exception) {
            System.out.println("Not succesful!");

        }

    }
}