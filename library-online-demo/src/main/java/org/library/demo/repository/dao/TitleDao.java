package org.library.demo.repository.dao;

import org.hibernate.Session;
import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.library.demo.repository.GenericDaoImpl;
import org.library.demo.repository.exception.DaoException;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TitleDao extends GenericDaoImpl<Title,String> {

    List<Title> titles = new ArrayList<>();
    Connection conn;

    public TitleDao() {
    }


    @Override
    public Title getById(String id) {
        Title title=null;
        Session session = getSessionFactory().getCurrentSession();

        try {
            //inizio transazione
            session.beginTransaction();

            // query che restituisce tutta la tabella
            title = session.get(Book.class, id);
            if (title == null){
                title = session.get(Magazine.class, id);
            }


            //commit
            session.getTransaction().commit();
            System.out.println("commit effettuato");

        }finally {
            deleteSession(getSessionFactory());
        }

        return title;
    }

    @Override
    public void add(Title entity) throws ClassNotFoundException, SQLException {
        Session session = getSessionFactory().getCurrentSession();
        Title temp=null;
        try {

            session.beginTransaction();

            System.out.println("creazione oggetto title");

            if ("BOOK".equals(entity.getType())) {
                 temp = new Book(entity.getName(), entity.getTitleId());
            } else if ("MAGAZINE".equals(entity.getType())) {
                temp = new Magazine(entity.getName(), entity.getTitleId());
            }
            session.save(temp);
            session.getTransaction().commit();

            //salvataggio oggetto
            System.out.println("salvataggio oggetto instructor");

            //commit

            System.out.println("commit effettuato");

        }finally {
            deleteSession(getSessionFactory());
        }
    }

    @Override
    public void delete(String id) throws ClassNotFoundException, SQLException, DaoException {
        Title title=null;
        Session session = getSessionFactory().getCurrentSession();

        try {
            //inizio transazione
            session.beginTransaction();

            // query che restituisce tutta la tabella
            title = session.get(Book.class, id);
            if (title == null){
                title = session.get(Magazine.class, id);
            }
            session.delete(title);


            //commit
            session.getTransaction().commit();
            System.out.println("commit effettuato");

        }finally {
            deleteSession(getSessionFactory());
        }

    }

    @Override
    public Title update(String id, Title updated) {
        return null;
    }
}