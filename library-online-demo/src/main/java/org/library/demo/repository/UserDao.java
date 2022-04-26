package org.library.demo.repository;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.connection.BaseDao;
import org.library.demo.repository.connection.BaseDaoImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
@Scope("singleton")
public class UserDao extends BaseDaoImpl {

    public UserDao() { }

    public UserLibrary get(String taxCode) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM user_library WHERE tax_code=?";
        Connection conn = getConnection();
        PreparedStatement stat = getConnection().prepareStatement(query);
        stat.setString(1, taxCode);
        ResultSet res = stat.executeQuery();
        UserLibrary userLibrary = null;
        while (res.next()) {
        String firstName = res.getString("first_name");
        String lastName = res.getString("last_name");
        taxCode = res.getString("tax_code");
        userLibrary = new UserLibrary();
        userLibrary.setFirstName(firstName);
        userLibrary.setLastName(lastName);
        userLibrary.setTaxCode(taxCode); }
        conn.close();
        return userLibrary;
    }
}
