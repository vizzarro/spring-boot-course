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
public class ReservationDaoImpl extends BaseDaoImpl<Reservation, String> implements ReservationDao {

    @Override
    public Reservation get(String id) {
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

            Title title = new Book("Cime Tempestose", "12");
            Title title1 = new Magazine("Focus", "13");

            Reservation reservationBook = new Reservation(userLibrary, title);
            Reservation reservationMag = new Reservation(userLibrary, title1);

            userLibrary.addReservation(reservationBook);
            userLibrary.addReservation(reservationMag);

            session.save(userLibrary);
            session.save(reservationBook);
            session.save(reservationMag);

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
            System.out.println("Reservation" + reservation);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

    @Override
    public void delete(String r) throws SQLException {

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
