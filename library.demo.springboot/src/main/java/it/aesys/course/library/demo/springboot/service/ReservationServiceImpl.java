package it.aesys.course.library.demo.springboot.service;


import it.aesys.course.library.demo.springboot.dao.ReservationDao;
import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.dto.ReservationDto;
import it.aesys.course.library.demo.springboot.models.Reservation;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements GenericService<ReservationDto, ReservationDto> {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReservationDto add(ReservationDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(reservationDao.add(modelMapper.map(dtoObject, Reservation.class)), ReservationDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public ReservationDto get(ReservationDto id) throws ServiceException {
        try {
            return modelMapper.map(reservationDao.get(modelMapper.map(id, Reservation.class)), ReservationDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public ReservationDto update(ReservationDto id, ReservationDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(reservationDao.update(modelMapper.map(id, Reservation.class), modelMapper.map(dtoObject, Reservation.class)), ReservationDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public void delete(ReservationDto id) throws ServiceException {
        try {
            reservationDao.delete(modelMapper.map(id, Reservation.class));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
