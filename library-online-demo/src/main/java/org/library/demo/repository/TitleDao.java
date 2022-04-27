package org.library.demo.repository;

import org.library.demo.models.*;
import org.library.demo.repository.connection.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class TitleDao extends BaseDaoImpl<Title, String> {
    Connection conn = null;

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
                    title = (new Book(rs.getString("name"), rs.getString("title_id")));
                } else if (rs.getString("type").equals("MAGAZINE")) {
                    title = (new Magazine(rs.getString("name"), rs.getString("title_id")));
                }
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection(conn);
        }
        return title;
    }

    @Override
    public void add(Title entity) throws SQLException {
        conn = this.getConnection();
        String query = "INSERT INTO title(title_id, name, type)\n" +
                "VALUES ('" + entity.getTitleId() + "','" + entity.getName() + "','BOOK');";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public void delete(String id) throws SQLException {
        conn = this.getConnection();
        String query = "DELETE FROM title WHERE title_id = ? and name = ? and type = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        int rs = ps.executeUpdate();
        ps.close();
        this.closeConnection(conn);
    }

    @Override
    public Title update(String id, Title updated) throws SQLException {
        conn = this.getConnection();
        String query = "UPDATE title SET title_id = ?, name = ?, type = ? WHERE title_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, updated.getTitleId());
        ps.setString(2, updated.getName());
        ps.setString(3, updated.getType());
        ps.setString(4, id);
        int rs = ps.executeUpdate();
        ps.close();
        this.closeConnection(conn);
        return null;
    }
}
