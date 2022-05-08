package it.aesys.course.library.demo.springboot.dao;


import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.models.UserLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserLibraryDao extends GenericDaoImpl<UserLibrary, String> {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public UserLibrary update(String id, UserLibrary entity) throws DaoException {

        Connection conn = getConnection();
        String query = "UPDATE user_library SET first_name=?, last_name=?, tax_code=? WHERE tax_Code=?";
        try {
            PreparedStatement stat = getConnection().prepareStatement(query);
            stat.setString(1, entity.getFirstName());
            stat.setString(2, entity.getLastName());
            stat.setString(3, entity.getId());
            stat.setString(4, id);
            stat.executeUpdate();
            conn.close();
            return entity;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public UserLibrary add(UserLibrary entity) throws DaoException {
        Connection conn = getConnection();
        String query ="INSERT INTO user_library(tax_code, first_name, last_name) VALUES (?,?,?)";
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(query);
            stat.setString(1, entity.getId());
            stat.setString(2, entity.getFirstName());
            stat.setString(3, entity.getLastName());
            stat.executeUpdate();
            conn.close();
            return entity;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }



    @Override
    public void delete(String id) throws DaoException {
        Connection conn = getConnection();
        String query = "DELETE FROM user_library WHERE tax_code=?";
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(query);
            stat.setString(1, id);
            ResultSet set = stat.executeQuery();
            UserLibrary userLibrary = ctx.getBean(UserLibrary.class);

            userLibrary.setFirstName( set.getString("first_name"));
            userLibrary.setLastName(set.getString("last_name"));
            userLibrary.setId(set.getString("tax_code"));
            conn.close();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }


    @Override
    public UserLibrary get(String id) throws DaoException {
        String query ="SELECT * FROM user_library WHERE tax_code=?";

        Connection conn = getConnection();
        PreparedStatement stat;
        try {
            stat = getConnection().prepareStatement(query);
            stat.setString(1, id);

            ResultSet res = stat.executeQuery();
            res.next();
            String firstName = res.getString("first_name");
            String lastName = res.getString("last_name");
            UserLibrary userLibrary = ctx.getBean(UserLibrary.class);
            userLibrary.setFirstName(firstName);
            userLibrary.setLastName(lastName);
            userLibrary.setId(id);

            conn.close();

            return userLibrary;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }

    }
}
