package it.aesys.course.library.demo.springboot.hybernate.dao;


import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class UserLibraryDao extends GenericDaoImpl<UserLibrary, String> {

    @Override
    public UserLibrary update(String id, UserLibrary entity) throws DaoException {
            try {
                Session session = getNewSession();
                session.beginTransaction();
                UserLibrary user = session.get(UserLibrary.class, id);
                if(!id.equals(entity.getId())){
                    closeSession();
                    DaoException daoException = new DaoException("Id does not match!");
                    daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
                    daoException.setPath("/user");
                    throw daoException;
                }
                user.setFirstName(entity.getFirstName());
                user.setLastName(entity.getLastName());
                user.setId(entity.getId());
                session.save(user);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                throw new DaoException(e.getMessage());
            } finally {
                closeSession();
            }
            return entity;
    }

    @Override
    public UserLibrary add(UserLibrary entity) throws DaoException {
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
    public void delete(String id) throws DaoException {
        try{
            Session session = getNewSession();
            session.beginTransaction();
            UserLibrary user = session.get(UserLibrary.class, id);
            if(user == null){
                DaoException daoException = new DaoException("Id does not correspond to any User");
                daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
                daoException.setPath("/user");
                throw daoException;
            }
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        }finally{
            closeSession();
        }
    }


    @Override
    public UserLibrary get(String id) throws DaoException {
        UserLibrary user;
        try{
        Session session = getNewSession();
        session.beginTransaction();
        user = session.get(UserLibrary.class, id);
        if(user == null){
            DaoException daoException = new DaoException("Id does not correspond to any User");
            daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
            daoException.setPath("/user");
            throw daoException;
        }
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        }finally{
            closeSession();
        }
        return user;
    }
}
