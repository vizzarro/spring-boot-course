package org.library.demo.repository;

import org.library.demo.models.Loan;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.connection.BaseDao;
import org.library.demo.repository.connection.BaseDaoImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao extends BaseDaoImpl<UserLibrary, String> {
    Connection conn = null;

    public UserDao() {
    }

    @Override
    public UserLibrary getById(String id) throws SQLException {
        conn = this.getConnection();
        String query = "SELECT * FROM user_library WHERE tax_code = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            UserLibrary userLibrary = new UserLibrary(
                    rs.getString("tax_code"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );
        }
        rs.close();
        ps.close();
        this.closeConnection(conn);

        return null;
    }

    @Override
    public void add(UserLibrary entity) throws SQLException {
        conn = this.getConnection();
        String query = "INSERT INTO user_library (tax_code, first_name, last_name)\n" +
                "VALUES ('" + entity.getTaxCode() + "','" + entity.getFirstName() + "''" + entity.getLastName();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public void delete(String id) throws SQLException {
        conn = this.getConnection();
        String query = "DELETE FROM title WHERE tax_code = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            UserLibrary userLibrary = new UserLibrary(
                    rs.getString("tax_code"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );
        }
        rs.close();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public UserLibrary update(String id, UserLibrary updated) throws SQLException {
        conn = this.getConnection();
        String query = "UPDATE user_library SET tax_code = ?, first_name = ?, last_name = ? WHERE tax_code = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, updated.getTaxCode());
        ps.setString(2, updated.getFirstName());
        ps.setString(3, updated.getLastName());
        ps.setString(4, id);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
        return null;
    }
}
