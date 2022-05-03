package it.aesys.course.library.demo.springboot.hybernate.dao;



import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.models.Reservation;
import it.aesys.course.library.demo.springboot.hybernate.models.Title;
import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDao extends GenericDaoImpl<Reservation, Integer> {


    @Override
    public List<Reservation> getAll() throws DaoException {
        List<Reservation> reservationList;
        try {
            Session session = getNewSession();
            session.beginTransaction();
            reservationList = session.createQuery("from Reservation").getResultList();
            if (reservationList.isEmpty()) {
                DaoException daoException = new DaoException(("the list is empty"));
                daoException.setStatusCode((HttpStatus.NOT_FOUND.value()));
                daoException.setPath("/user");
                throw daoException;
            }
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        } finally {
            closeSession();
        }
        return reservationList;
    }

    @Override
    public Reservation add(Reservation entity) throws DaoException {
        try{
            Session session = getNewSession();
            session.beginTransaction();
            UserLibrary user = session.get(UserLibrary.class, entity.getTaxCode());
            Title title = session.get(Title.class, entity.getTitleId());
            entity.setTitle(title);
            entity.setUser(user);
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        }finally{
            closeSession();
        }
        return entity;

    }

    @Override
    public void delete(Integer id) throws DaoException {
        Reservation reservation;
        try{
            Session session = getNewSession();
            session.beginTransaction();
            reservation = session.get(Reservation.class, id);

            if(reservation == null){
                DaoException daoException = new DaoException("Id does not correspond to any reservation");
                daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
                daoException.setPath("/user");
                throw daoException;
            }
            session.delete(reservation);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        }finally{
            closeSession();
        }

    }

    @Override
    public Reservation update(Integer id, Reservation entity) throws DaoException {
        try {
            Session session = getNewSession();
            session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, id);

           // reservation.setTitleId(entity.getTitleId());
            reservation.setCreationDate(entity.getCreationDate());
           // reservation.setTaxCode(entity.getTaxCode());

            session.save(reservation);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        } finally {
            closeSession();
        }
        return entity;
    }

    @Override
    public Reservation get(Integer id) throws DaoException {

        Reservation reservation;
        try{
            Session session = getNewSession();
            session.beginTransaction();
            reservation = session.get(Reservation.class, id);
            if(reservation == null){
                DaoException daoException = new DaoException("Id does not correspond to any reservation");
                daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
                daoException.setPath("/user");
                throw daoException;
            }
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        }finally{
            closeSession();
        }
        return reservation;
    }

    public List<Reservation> getUserReservation(String id){
        Session session = getNewSession();
        session.beginTransaction();

        UserLibrary user = session.get(UserLibrary.class, id);
        session.getTransaction().commit();
        closeSession();
        return user.getUserReservations();
    }
}
