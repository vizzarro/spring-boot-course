package it.aesys.course.library.demo.springboot.hybernate.dao;



import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.models.Reservation;
import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDao extends GenericDaoImpl<Reservation, Integer> {


    @Override
    public Reservation add(Reservation entity) throws DaoException {
        try{
            Session session = getNewSession();
            session.beginTransaction();
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

    }

    @Override
    public Reservation update(Integer id, Reservation entity) throws DaoException {

            return entity;
    }

    @Override
    public Reservation get(Integer id) throws DaoException {


            return null;
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
