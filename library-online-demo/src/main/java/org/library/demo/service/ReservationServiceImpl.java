package org.library.demo.service;

import org.library.demo.dao.*;
import org.library.demo.models.UserLibrary;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao;
    private TitleDao titleDao;
    private UserLibraryDao userLibraryDao;

    @Autowired
    public ReservationServiceImpl(
            ReservationDao reservationDao,
            TitleDao titleDao,
            UserLibraryDao userLibraryDao
    ) {
        this.reservationDao = reservationDao;
        this.titleDao = titleDao;
        this.userLibraryDao = userLibraryDao;
    }

    @Override
    public void addReservation(Reservation newReservation) throws Exception {
        if (newReservation == null)
            throw new Exception("No request");

        try {
            UserLibrary b = userLibraryDao.get(newReservation.getUserLibraryId());
        } catch (Exception e) {
            throw new Exception("No UserLibrary found for id " + newReservation.getUserLibraryId());
        }

        Title exists = titleDao.get(newReservation.getTitleId());
        if (exists == null)
            throw new Exception("No Title found for id " + newReservation.getTitleId());

        reservationDao.create(newReservation);
    }

    @Override
    public Reservation getReservation(Reservation id) throws SQLException {
        return reservationDao.get(id);
    }

    @Override
    public void deleteReservation(Reservation id) throws SQLException {
        this.reservationDao.delete(id);
    }
}
