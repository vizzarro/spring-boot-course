package org.library.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.springframework.stereotype.Repository;

@Repository
public class TitleDaoImpl extends BaseDaoImpl<Title, Integer> implements TitleDao {

    @Override
    public Title get(Integer id) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM TITLE WHEN TITLE_ID=?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Title title;
        if (resultSet.getString("type").equals("BOOK"))
            title = new Book();
        else title = new Magazine();

        title.setName(resultSet.getString("name"));
        title.setTitleId(id);

        return title;
    }

    @Override
    public Integer create(Title title) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO TITLE VALUES (?,?,?)");
        statement.setInt(1, title.getTitleId());
        statement.setString(2, title.getName());
        if (title instanceof Book)
            statement.setString(3, "BOOK");
        else
            statement.setString(3, "MAGAZINE");

        statement.executeQuery();

        return title.getTitleId();
    }

    @Override
    public Title update(Title title) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE TITLE NAME = ? WHEN TITLE_ID = ?");
        statement.setString(1, title.getName());
        statement.setInt(2, title.getTitleId());
        statement.executeQuery();

        return title;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE TITLE WHEN TITLE_ID =" + id);

        statement.executeQuery();
    }
}
