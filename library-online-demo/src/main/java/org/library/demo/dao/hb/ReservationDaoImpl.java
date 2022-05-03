package org.library.demo.dao.hb;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.demo.dao.BaseDaoImpl;
import org.library.demo.dao.ReservationDao;
import org.library.demo.models.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.SQLException;

@Repository
public class ReservationDaoImpl extends BaseDaoImpl<Reservation, Integer> implements ReservationDao {

    @Override
    public Reservation get(Integer id) {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();
        Reservation reservation = null;
        try {
            session.beginTransaction();

            reservation = session.get(Reservation.class, id);
            System.out.println("Reservation" + reservation);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        } return reservation;
    }

    @Override
    public void create(Reservation r) throws SQLException {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            UserLibrary userLibrary = new UserLibrary("Lucia", "Verdi", "VRDLCU45RD4638HD");

            Title title = new Title("Cime Tempestose", "12", "book");

            Reservation reservationBook = new Reservation(userLibrary, title);

            userLibrary.addReservation(reservationBook);

            session.save(userLibrary);
            session.save(reservationBook);


            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }


    @Override
    public void update(Reservation r) {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Reservation reservation = session.get(Reservation.class, (Serializable) r.getReservationId());
            reservation.setReservationId(r.getReservationId());
            System.out.println("Reservation" + reservation);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

    @Override
    public void delete(Integer r) throws SQLException {

        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, r);

            if (null != reservation) {
                System.out.println("Delete" + reservation);
                session.delete(reservation);
            }

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

    }

