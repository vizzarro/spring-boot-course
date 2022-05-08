package org.library.demo.dao;

import org.library.demo.models.UserLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
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
    public UserLibrary update(String id, UserLibrary entity) throws SQLException, ClassNotFoundException {
        UserLibrary userLibrary = ctx.getBean(UserLibrary.class);

        Connection conn = getConnection();
        String query = "UPDATE user_library SET first_name=?, last_name=?, tax_code=? WHERE tax_Code=?";
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, entity.getFirstName());
        stat.setString(2, entity.getLastName());
        stat.setString(3, entity.getId());
        stat.setString(4, id);
        stat.executeUpdate();
        conn.close();
        return userLibrary;

    }

    @Override
    public UserLibrary add(UserLibrary entity) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        String query ="INSERT INTO user_library(tax_code, first_name, last_name) VALUES (?,?,?)";
        PreparedStatement stat = conn.prepareStatement(query);
        stat.setString(1, entity.getId());
        stat.setString(2, entity.getFirstName());
        stat.setString(3, entity.getLastName());
        stat.executeUpdate();
        conn.close();
        return entity;
    }



    @Override
    public UserLibrary delete(String id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        String query = "DELETE FROM user_library WHERE tax_code=" + id;
        PreparedStatement stat = conn.prepareStatement(query);
        ResultSet set = stat.executeQuery();
        UserLibrary userLibrary = ctx.getBean(UserLibrary.class);

        userLibrary.setFirstName( set.getString("first_name"));
        userLibrary.setLastName(set.getString("last_name"));
        userLibrary.setId(set.getString("tax_code"));
        conn.close();
        return userLibrary;
    }


    @Override
    public UserLibrary get(String id) throws SQLException, ClassNotFoundException {
        String query ="SELECT * FROM user_library WHERE tax_code=?";

        Connection conn = getConnection();
        PreparedStatement stat = getConnection().prepareStatement(query);

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

    }
}
