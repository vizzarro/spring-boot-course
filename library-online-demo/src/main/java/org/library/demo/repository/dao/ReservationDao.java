package org.library.demo.repository.dao;

import org.hibernate.Session;
import org.library.demo.models.*;
import org.library.demo.repository.GenericDaoImpl;
import org.library.demo.repository.exception.DaoException;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDao extends GenericDaoImpl<Reservation,Reservation> {

    List<Reservation> reservations = new ArrayList<>();
    Connection conn;

    public ReservationDao() {
    }

    @Override
    public Reservation getById(Reservation id) {
        return null;
    }

    @Override
    public void add(Reservation entity) throws ClassNotFoundException, SQLException {
        Session session = getSessionFactory().getCurrentSession();
        Reservation temp=null;
        try {

            session.beginTransaction();

            System.out.println("creazione oggetto title");

                temp = new Reservation("date",session.get(UserLibrary.class,1) ,session.get(Book.class,1));

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
    public void delete(Reservation id) throws ClassNotFoundException, SQLException, DaoException {

    }

    @Override
    public Reservation update(Reservation id, Reservation updated) {
        return null;
    }
}