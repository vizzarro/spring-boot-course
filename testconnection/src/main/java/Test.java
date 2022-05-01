package org.library.demo;


import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("succesful!");
        } catch (HibernateException exception) {
            System.out.println("Not succesful!");
        }


    }
}
