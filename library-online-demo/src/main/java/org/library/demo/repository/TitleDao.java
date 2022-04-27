package org.library.demo.repository;

import org.library.demo.models.Book;
import org.library.demo.models.Loan;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.library.demo.repository.connection.BaseDaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitleDao<Title> extends BaseDaoImpl {

    public TitleDao() {
    }

    List<Title> titles = new ArrayList<>();
    Connection conn = null;

    public List<Title> getTitleList() throws SQLException {

        conn = this.getConnection();


        String query = "SELECT * FROM title";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getString("type").equals("BOOK")) {
                titles.add((Title) new Book(rs.getString("name"), rs.getString("title_id")));
            } else if (rs.getString("type").equals("MAGAZINE")) {
                titles.add((Title)new Magazine(rs.getString("name"), rs.getString("title_id")));
            }
        }
        closeConnection(conn);
        return titles;


    }



}
