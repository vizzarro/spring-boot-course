package org.library.demo.repository.dao;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericDaoImpl;
import org.library.demo.repository.exception.DaoException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserLibraryDao extends GenericDaoImpl<UserLibrary, String> {

    List<UserLibrary> users = new ArrayList<>();
    Connection conn;

    public UserLibraryDao() {
    }

    public List<UserLibrary> getUserList()  {


        try {

            conn = this.getConnection();


            String query = "SELECT * FROM user_library";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                users.add(new UserLibrary(rs.getString("tax_code"), rs.getString("first_name"), rs.getString("last_name")));
            }
            return users;

        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {

            this.deleteConnection(conn);

        }
        return users;
    }



    @Override
    public UserLibrary getById(String id) {
        UserLibrary user = null;
        try {

            conn = this.getConnection();

            String query = "SELECT * FROM user_library WHERE tax_code = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {


            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {

            this.deleteConnection(conn);

        }
        return user;
    }

    @Override
    public void add(UserLibrary entity) {
        try {

            conn = this.getConnection();


            String query = "INSERT INTO user_library(tax_code, first_name, last_name) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, entity.getTaxCode());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {

            this.deleteConnection(conn);
        }
    }

    @Override
    public void delete(String id) throws ClassNotFoundException, SQLException, DaoException {
        try {

            conn = this.getConnection();


            String query = "DELETE FROM user_library WHERE tax_code=?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {
            this.deleteConnection(conn);
        }
    }

    @Override
    public UserLibrary update(String id, UserLibrary updated) {
        return null;
    }
}
