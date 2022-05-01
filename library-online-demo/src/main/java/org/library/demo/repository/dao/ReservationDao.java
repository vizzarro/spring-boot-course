package org.library.demo.repository.dao;

import org.library.demo.models.Reservation;
import org.library.demo.repository.GenericDaoImpl;
import org.library.demo.repository.exception.DaoException;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDao extends GenericDaoImpl<Reservation,Reservation> {

    List<Reservation> reservations = new ArrayList<>();
    Connection conn;

    public ReservationDao() {
    }

    @Override
    public Reservation getById(Reservation id) {
        return null;
    }

    @Override
    public void add(Reservation entity) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void delete(Reservation id) throws ClassNotFoundException, SQLException, DaoException {

    }

    @Override
    public Reservation update(Reservation id, Reservation updated) {
        return null;
    }
}