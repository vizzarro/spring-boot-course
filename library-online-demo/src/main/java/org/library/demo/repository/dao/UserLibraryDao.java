package org.library.demo.repository.dao;


import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericDaoImpl;
import org.library.demo.repository.exception.DaoException;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import java.sql.SQLException;


@Repository
public class UserLibraryDao extends GenericDaoImpl<UserLibrary, String> {

    @Override
    public UserLibrary getById(String id) {
        UserLibrary user =null;
        Session session = getSessionFactory().getCurrentSession();

        try {
            //inizio transazione
            session.beginTransaction();

            // query che restituisce tutta la tabella
            user = session.get(UserLibrary.class, id);

            //commit
            session.getTransaction().commit();
            System.out.println("commit effettuato");

        }finally {
            deleteSession(getSessionFactory());
        }

        return user;
    }

    @Override
    public void add(UserLibrary entity) throws ClassNotFoundException, SQLException {

        Session session = getSessionFactory().getCurrentSession();
        try {



            System.out.println("creazione oggetto Instructor");
            UserLibrary userLibrary = new UserLibrary(entity.getFirstName(), entity.getLastName(), entity.getTaxCode());


            //inizio transazione
            session.beginTransaction();

            //salvataggio oggetto
            System.out.println("salvataggio oggetto instructor");
            session.save(userLibrary);

            //commit
            session.getTransaction().commit();
            System.out.println("commit effettuato");

        }finally {
            deleteSession(getSessionFactory());
        }
    }

    @Override
    public void delete(String id) throws ClassNotFoundException, SQLException, DaoException {
        UserLibrary user =null;
        Session session = getSessionFactory().getCurrentSession();

        try {
            //inizio transazione
            session.beginTransaction();

            // query che restituisce tutta la tabella
            user = session.get(UserLibrary.class, id);
session.delete(user);
            //commit
            session.getTransaction().commit();
            System.out.println("delete succesfull");

        }finally {
            deleteSession(getSessionFactory());
        }
    }


    @Override
    public UserLibrary update(String id, UserLibrary updated) {
        UserLibrary user =null;
        Session session = getSessionFactory().getCurrentSession();

        try {
            //inizio transazione
            session.beginTransaction();

            // query che restituisce tutta la tabella
            user = session.get(UserLibrary.class, id);
            user.setFirstName(updated.getFirstName());
            user.setLastName(updated.getLastName());

            //commit
            session.getTransaction().commit();
            System.out.println("commit effettuato");

        }finally {
            deleteSession(getSessionFactory());
        }

        return user;
    }
}
