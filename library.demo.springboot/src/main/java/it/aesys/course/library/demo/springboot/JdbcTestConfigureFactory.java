package it.aesys.course.library.demo.springboot;

import it.aesys.course.library.demo.springboot.models.UserLibrary;
import org.apache.catalina.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JdbcTestConfigureFactory {


    public static void main(String[] args) {

        try {
            SessionFactory sessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    addAnnotatedClass(UserLibrary.class).buildSessionFactory();
            System.out.println("Ciao!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
