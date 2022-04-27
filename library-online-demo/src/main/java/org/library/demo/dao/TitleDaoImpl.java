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
public class TitleDaoImpl extends BaseDaoImpl<Title, String> implements TitleDao {

    @Override
    public Title get(String id) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM TITLE WHERE TITLE_ID=?");
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Title title;
        if (resultSet.getString("type").equals("BOOK"))
            title = new Book();
        else title = new Magazine();

        title.setName(resultSet.getString("name"));
        title.setTitleId(id);

        return title;
    }

    @Override
    public String create(Title title) throws SQLException {
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

    @Override
    public Title update(Title title) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE TITLE SET NAME = ? WHERE TITLE_ID = ?");
        statement.setString(1, title.getName());
        statement.setString(2, title.getTitleId());
        statement.executeUpdate();

        return title;
    }

    @Override
    public void delete(String id) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM TITLE WHERE TITLE_ID = ?");
        statement.setString(1, id);

        statement.executeUpdate();
    }
}
