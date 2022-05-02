package org.library.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.springframework.stereotype.Repository;

@Repository
public class TitleDaoImpl extends BaseDaoImpl<Title, String> implements TitleDao {

    @Override
    public Title get(String id) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();
        Title title = null;
        try {
            session.beginTransaction();
            title = session.get(Title.class, id);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
            if(title != null && "BOOK".equals(title.getTYPE())){
                return (Book)title;
            }
            if(title != null && "MAGAZINE".equals(title.getTYPE())){
                return (Magazine)title;
            }

            return null;
        }
    }

        /**
        Connection conn = connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM TITLE WHERE TITLE_ID=?");
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        Title title = null;
        if (resultSet.next()){
            if (resultSet.getString("type").equals("BOOK"))
                title = new Book();
            else title = new Magazine();

            title.setName(resultSet.getString("name"));
            title.setTitleId(id);
        }
         */



    @Override
    public void create(Title title) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(title);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
        /**
        Connection conn = connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO title VALUES (?,?,?)");
        statement.setString(1, title.getTitleId());
        statement.setString(2, title.getName());
        if (title instanceof Book)
            statement.setString(3, "BOOK");
        else
            statement.setString(3, "MAGAZINE");

        statement.executeUpdate();
        statement.close();
        disconnect();
        return title.getTitleId();
    }
         */

    @Override
    public void update(Title title) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Title toUpdate = session.get(Title.class, title.getTitleId());
            toUpdate.setTitleId(title.getTitleId());
            toUpdate.setName(title.getName());
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
        /**
        }
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE TITLE SET NAME = ? WHERE TITLE_ID = ?");
        statement.setString(1, title.getName());
        statement.setString(2, title.getTitleId());
        statement.executeUpdate();

        return title;
    }
         */

    @Override
    public void delete(String id) throws SQLException {
        SessionFactory factory = getFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.delete(session.get(Title.class, id));
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

        /**
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM TITLE WHERE TITLE_ID = ?");
        statement.setString(1, id);

        statement.executeUpdate();
         */
    }
