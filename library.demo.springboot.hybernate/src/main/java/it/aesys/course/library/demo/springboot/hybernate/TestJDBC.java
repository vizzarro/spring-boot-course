package it.aesys.course.library.demo.springboot.hybernate;

import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJDBC {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(UserLibrary.class).configure("hibernate.cfg.xml").buildSessionFactory();
        try {

            System.out.println("Ciao!");

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            UserLibrary user = new UserLibrary();
            user.setFirstName("Nicola");
            user.setId("48fnf4834f");
            user.setLastName("Rossi");
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException exception) {
            System.out.println("Not succesful!");
        }finally{
            sessionFactory.close();
        }
    }
}
