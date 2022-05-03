package org.library.demo.service;

import org.library.demo.models.Reservation;

import java.sql.SQLException;

public interface ReservationService {
    void addReservation(Reservation newReservation) throws Exception;

    Reservation getReservation(Integer id) throws SQLException;

    void deleteReservation(Integer id) throws SQLException;

    void updateReservation(Reservation reservation) throws SQLException;

}
