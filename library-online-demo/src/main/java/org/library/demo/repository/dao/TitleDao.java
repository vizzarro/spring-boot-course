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
        return null;
    }

    @Override
    public void add(Title entity) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void delete(String id) throws ClassNotFoundException, SQLException, DaoException {

    }

    @Override
    public Title update(String id, Title updated) {
        return null;
    }
}