package it.aesys.course.library.demo.springboot.hybernate.dao;

import it.aesys.course.library.demo.springboot.hybernate.models.Reservation;
import it.aesys.course.library.demo.springboot.hybernate.models.Title;
import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class GenericDaoImpl<T, IdType> implements GenericDao<T, IdType> {

    private static Configuration CONFIGURATION;
    private static SessionFactory SESSION_FACTORY;
    private static Session CURRENT_SESSION;

    public static void buildSessionFactory() {
        if (CONFIGURATION == null) {
            CONFIGURATION = new Configuration().
                    addAnnotatedClass(UserLibrary.class).
                    addAnnotatedClass(Title.class).
                    addAnnotatedClass(Reservation.class).
                    configure();

        }
        SESSION_FACTORY = CONFIGURATION.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (SESSION_FACTORY == null) {
            buildSessionFactory();
        }
        return SESSION_FACTORY;
    }

    public static Session getNewSession(){
        CURRENT_SESSION = getSessionFactory().getCurrentSession();
        return CURRENT_SESSION;
    }

    public static void closeSession() {
        CURRENT_SESSION.close();
    }

}


