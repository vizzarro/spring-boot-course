package org.library.demo.dao.hb;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.demo.dao.BaseDaoImpl;
import org.library.demo.dao.UserLibraryDao;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.springframework.stereotype.Repository;

@Repository
public class UserLibraryDaoHbImpl extends BaseDaoImpl<UserLibrary, String> implements UserLibraryDao {

    @Override
    public UserLibrary get(String taxCode) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();
        UserLibrary userLibrary = null;
        try {
            session.beginTransaction();
            userLibrary = session.get(UserLibrary.class, taxCode);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
            if(userLibrary != null){
                return userLibrary;
            } else{
                return null;
            }
        }
    }

    @Override
    public void create(UserLibrary user) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

    @Override
    public void update(UserLibrary user) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Title toUpdate = session.get(Title.class, user.getTaxCode());
            toUpdate.setTitleId(user.getTaxCode());
            toUpdate.setName(user.getTaxCode());
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

    @Override
    public void delete(String taxCode) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.delete(session.get(UserLibrary.class, taxCode));
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
