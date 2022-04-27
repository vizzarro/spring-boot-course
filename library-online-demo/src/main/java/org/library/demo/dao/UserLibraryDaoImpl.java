package org.library.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.springframework.stereotype.Repository;

@Repository
public class UserLibraryDaoImpl extends BaseDaoImpl<UserLibrary, String> implements UserLibraryDao {

    @Override
    public UserLibrary get(String taxCode) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM USER_LIBRARY WHEN TAX_CODE=" +
                taxCode);
        ResultSet resultSet = statement.executeQuery();

        UserLibrary user = new UserLibrary();
        user.setTaxCode(resultSet.getString("tax_code"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));

        return user;
    }

    @Override
    public String create(UserLibrary user) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO USER_LIBRARY VALUES (?,?,?)");
        statement.setString(1, user.getTaxCode());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.executeQuery();

        return user.getTaxCode();
    }

    @Override
    public UserLibrary update(UserLibrary user) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE USER_LIBRARY FIRST_NAME = ?," +
                "LAST_NAME = ? WHEN TAX_CODE = ?");
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getTaxCode());
        statement.executeQuery();

        return user;
    }

    @Override
    public void delete(String id) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE USER_LIBRARY WHEN TAX_CODE =" + id);

        statement.executeQuery();
    }
}
