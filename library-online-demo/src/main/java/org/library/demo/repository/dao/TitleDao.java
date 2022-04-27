package org.library.demo.repository.dao;

import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
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
public class TitleDao extends GenericDaoImpl<Title,String> {

    List<Title> titles = new ArrayList<>();
    Connection conn;

    public TitleDao() {
    }

    @Override
    public Title getById(String id) {
        Title title = null;
        try {
                conn = this.getConnection();

            String query = "SELECT * FROM title WHERE title_id = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("type").equals("BOOK")) {
                    title=(new Book(rs.getString("name"), rs.getString("title_id")));
                } else if (rs.getString("type").equals("MAGAZINE")) {
                    title = (new Magazine(rs.getString("name"), rs.getString("title_id")));
                }

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("DB Error");
        } finally {

                this.deleteConnection(conn);

        }
        return title;
    }

    @Override
    public void add(Title entity)  {
        try {
                conn = this.getConnection();

            String query = "INSERT INTO title(title_id, name,type) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, entity.getTitleId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getType());
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

            String query = "DELETE FROM title WHERE title_id=?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("DB  Error");
        } finally {

                this.deleteConnection(conn);

        }

    }

    @Override
    public Title update(String id, Title updated) {
        return null;
    }


}