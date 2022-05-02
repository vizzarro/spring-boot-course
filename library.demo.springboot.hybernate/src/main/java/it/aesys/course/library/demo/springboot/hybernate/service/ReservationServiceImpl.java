package it.aesys.course.library.demo.springboot.hybernate.service;


import it.aesys.course.library.demo.springboot.hybernate.dao.ReservationDao;
import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.dto.ReservationDto;
import it.aesys.course.library.demo.springboot.hybernate.dto.ReservationIdDto;
import it.aesys.course.library.demo.springboot.hybernate.models.Reservation;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements GenericService<ReservationDto, Integer> {

    private ReservationDao reservationDao;

    private ModelMapper modelMapper;

    @Autowired
    public ReservationServiceImpl(){
        this.reservationDao = new ReservationDao();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<ReservationDto> getAll() throws ServiceException {
        return null;
    }

    @Override
    public ReservationDto add(ReservationDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(reservationDao.add(modelMapper.map(dtoObject, Reservation.class)), ReservationDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public ReservationDto get(Integer id) throws ServiceException {
        try {
            return modelMapper.map(reservationDao.get(id), ReservationDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public ReservationDto update(Integer id, ReservationDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(reservationDao.update(id, modelMapper.map(dtoObject, Reservation.class)), ReservationDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            reservationDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
