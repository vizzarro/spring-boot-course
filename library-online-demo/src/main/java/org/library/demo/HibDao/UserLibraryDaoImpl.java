package org.library.demo.HibDao;

import org.library.demo.dao.BaseDaoImpl;
import org.library.demo.dao.UserLibraryDao;
import org.library.demo.models.UserLibrary;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserLibraryDaoImpl extends BaseDaoImpl<UserLibrary, String> implements UserLibraryDao {

    @Override
    public UserLibrary get(String taxCode) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM USER_LIBRARY WHERE TAX_CODE=?");
        statement.setString(1, taxCode.toUpperCase());
        ResultSet resultSet = statement.executeQuery();

        UserLibrary user = null;
        if(resultSet.next()) {

            user = new UserLibrary();
            user.setTaxCode(resultSet.getString("tax_code"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
        }
        return user;
    }

    @Override
    public String create(UserLibrary user) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO USER_LIBRARY VALUES (?,?,?)");
        statement.setString(1, user.getTaxCode());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.executeUpdate();

        return user.getTaxCode();
    }

    @Override
    public UserLibrary update(UserLibrary user) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("UPDATE USER_LIBRARY SET FIRST_NAME = ?," +
                "LAST_NAME = ? WHERE TAX_CODE = ?");
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getTaxCode());
        statement.executeUpdate();

        return user;
    }

    @Override
    public void delete(String taxCode) throws SQLException {
        Connection conn = super.connect();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM USER_LIBRARY WHERE TAX_CODE = ?");
        statement.setString(1, taxCode.toUpperCase());

        statement.executeUpdate();
    }
}
