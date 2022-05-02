package it.aesys.course.library.demo.springboot.hybernate.dao;

;
import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.models.Title;
import it.aesys.course.library.demo.springboot.hybernate.models.TypeTitle;
import it.aesys.course.library.demo.springboot.hybernate.models.UserLibrary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TitleDao extends GenericDaoImpl<Title, String> {


    @Override
    public Title get(String id) throws DaoException {
        Title title;
        try {
            Session session = getNewSession();
            session.beginTransaction();
            title = session.get(Title.class, id);
            if (title == null) {
                DaoException daoException = new DaoException("Id does not correspond to any User");
                daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
                daoException.setPath("/user");
                throw daoException;
            }
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        } finally {
            closeSession();
        }
        return title;
    }

    @Override
    public List<Title> getAll() throws DaoException {
        List<Title> titleList;
        try {
            Session session = getNewSession();
            session.beginTransaction();
             titleList = session.createQuery("from Title").getResultList();
            if (titleList.isEmpty()) {
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
        return titleList;
    }

    @Override
    public Title add(Title entity) throws DaoException {
        try {
            Session session = getNewSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        } finally {
            closeSession();
        }
        return entity;
    }

    @Override
    public void delete(String id) throws DaoException {
        try {
            Session session = getNewSession();
            session.beginTransaction();
            Title title = session.get(Title.class, id);
            if (title == null) {
                DaoException daoException = new DaoException("Id does not correspond to any User");
                daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
                daoException.setPath("/user");
                throw daoException;
            }
            session.delete(title);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        } finally {
            closeSession();
        }
    }

    @Override
    public Title update(String id, Title entity) throws DaoException {
        try {
            Session session = getNewSession();
            session.beginTransaction();
            Title title = session.get(Title.class, id);
            if (!id.equals(entity.getTitleId())) {
                closeSession();
                DaoException daoException = new DaoException("Id does not match!");
                daoException.setStatusCode(HttpStatus.NOT_FOUND.value());
                daoException.setPath("/user");
                throw daoException;
            }
            title.setTitleId(entity.getName());
            title.setType(entity.getType());
            title.setTitleId(entity.getTitleId());
            session.save(title);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e.getMessage());
        } finally {
            closeSession();
        }
        return entity;
    }

}