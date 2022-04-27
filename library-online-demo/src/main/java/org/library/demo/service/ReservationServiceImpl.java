package org.library.demo.service;

import org.library.demo.dao.ReservationDao;
import org.library.demo.dtos.ReservationDto;
import org.library.demo.models.Reservation;
import org.library.demo.service.mapper.ReservationModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ReservationServiceImpl implements GenericService<ReservationDto, String> {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private ReservationModelMapper modelMapper;

    @Override
    public ReservationDto add(ReservationDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(reservationDao.add(modelMapper.toModelObject(dtoObject, Reservation.class)), ReservationDto.class);
    }

    @Override
    public ReservationDto get(String id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(reservationDao.get(id), ReservationDto.class);
    }

    @Override
    public ReservationDto update(String id, ReservationDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(reservationDao.update(id, modelMapper.toModelObject(dtoObject, Reservation.class)), ReservationDto.class);

    }

    @Override
    public ReservationDto delete(String id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(reservationDao.delete(id), ReservationDto.class);
    }
}
