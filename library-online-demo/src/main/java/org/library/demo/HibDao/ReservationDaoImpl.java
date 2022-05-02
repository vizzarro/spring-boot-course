package org.library.demo.HibDao;


import org.hibernate.Session;
import org.library.demo.dao.BaseDaoImpl;
import org.library.demo.dao.ReservationDao;
import org.library.demo.models.*;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ReservationDaoImpl extends BaseDaoImpl<String, Reservation> implements ReservationDao {

    @Override
    public String get(Reservation id) {
        Session factory = BaseDaoImpl.getFactory().openSession();
        Session session = getFactory().getCurrentSession();

        try {
            session.beginTransaction();

            Reservation reservation = session.get(Reservation.class, id.getReservationId().getTaxCode());
            System.out.println("Reservation" + reservation);

            session.getTransaction().commit();

        } finally {
            BaseDaoImpl.getFactory().close();
        } return null;
    }

    @Override
    public void create(Reservation r) throws SQLException {

        Session factory = BaseDaoImpl.getFactory().openSession();
        Session session = getFactory().getCurrentSession();

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
            BaseDaoImpl.getFactory().close();
        }
    }


    @Override
    public void update(Reservation r) {
        Session factory = BaseDaoImpl.getFactory().openSession();
        Session session = getFactory().getCurrentSession();

        try {
            session.beginTransaction();

            Reservation reservation = session.get(Reservation.class, r.getReservationId().getTaxCode());
            System.out.println("Reservation" + reservation);

            session.getTransaction().commit();

        } finally {
            BaseDaoImpl.getFactory().close();
        }
    }

    @Override
    public void delete(Reservation r) throws SQLException {

        Session factory = BaseDaoImpl.getFactory().openSession();
        Session session = getFactory().getCurrentSession();


        try {
            int id = 1;

            session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, id);

            if (null != r.getUserLibrary()) {
                System.out.println("Delete" + reservation);
                session.delete(reservation);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    }

