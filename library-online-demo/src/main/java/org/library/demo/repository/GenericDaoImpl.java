package org.library.demo.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.library.demo.models.*;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDaoImpl<T,K> implements GenericDao<T,K> {
    private SessionFactory factory;

    public SessionFactory getSessionFactory() {
        //creazione Session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserLibrary.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Magazine.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();

return factory;
    }



    public void deleteSession(SessionFactory session)  {
        if(null!=session){
            session.close();
            session = null;
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

}