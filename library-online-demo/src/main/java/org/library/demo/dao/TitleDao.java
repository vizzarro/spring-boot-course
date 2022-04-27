package org.library.demo.dao;
import org.library.demo.models.Title;
import org.library.demo.models.TypeTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class TitleDao extends GenericDaoImpl<Title, String> {

    @Autowired
    private ApplicationContext ctx;
    @Override
    public Title get(String id)  {
        Title title = ctx.getBean(Title.class);
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM title WHERE title_id=?";
            PreparedStatement stat = getConnection().prepareStatement(query);
            stat.setString(1, id);
            ResultSet res = stat.executeQuery();
            String name = res.getString("name");
            String type = res.getString("type");
            title.setName("name");
            title.setType(TypeTitle.valueOf(type));
            title.setTitleId(id);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }

    @Override
    public Title add(Title entity) {
        Title title = ctx.getBean(Title.class);
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO  title (title_id, name, type )VALUES(?,?,?)";
            PreparedStatement stat = getConnection().prepareStatement(query);
            stat.setString(1,entity.getTitleId());
            stat.setString(2,entity.getName());
            stat.setString(3,entity.getType().toString());
            stat.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }

    @Override
    public Title delete(String id) {
        Title title = ctx.getBean(Title.class);
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM title WHERE title_id = " +id;
            PreparedStatement stat = getConnection().prepareStatement(query);
            stat.execute();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }

    @Override
    public Title update(String id, Title updated) {
        Title title = ctx.getBean(Title.class);
        try {
            Connection connection = getConnection();
            String query = "UPDATE title SET title_id=? ,name=?,type=? WHERE title_id=?";
            PreparedStatement stat = getConnection().prepareStatement(query);
            stat.setString(1, updated.getTitleId());
            stat.setString(2, updated.getName());
            stat.setString(3, String.valueOf(updated.getType()));
            stat.setString(4, id);
            stat.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }

}