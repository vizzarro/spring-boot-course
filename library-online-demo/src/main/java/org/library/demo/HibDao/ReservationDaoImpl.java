package org.library.demo.HibDao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.library.demo.dao.BaseDaoImpl;
import org.library.demo.dao.ReservationDao;
import org.library.demo.models.*;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ReservationDaoImpl extends BaseDaoImpl<Reservation, Reservation> implements ReservationDao {

    @Override
    public Reservation get(Reservation id) {
        Session factory = BaseDaoImpl.getFactory().openSession();
        Session session = getFactory().getCurrentSession();

        try {
            session.beginTransaction();

            Reservation reservation = session.get(Reservation.class, id.getReservationId().getTaxCode());
            System.out.println("Reservation" + reservation);

            session.getTransaction().commit();

        } finally {
            BaseDaoImpl.getFactory().close();
        }
    }

    @Override
    public Reservation create(Reservation r) throws SQLException {

        Session factory = BaseDaoImpl.getFactory().openSession();
        Session session = getFactory().getCurrentSession();

        try {
            session.beginTransaction();

            UserLibrary userLibrary = new UserLibrary("Lucia", "Verdi", "VRDLCU45RD4638HD");

            Title title = new Book("Cime Tempestose", "12");
            Title title1 = new Magazine("Focus", "13");

            session.getTransaction().commit();

        } finally {
            BaseDaoImpl.getFactory().close();
        }
    }


    @Override
    public Reservation update(Reservation r) {
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

            if (null != instructor) {
                System.out.println("Delete" + instructorDetail);
                session.delete(instructor);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    }
}
