package org.library.demo.service.mapper;

import org.library.demo.dtos.ReservationDto;
import org.library.demo.dtos.UserLibraryDto;
import org.library.demo.models.Reservation;
import org.library.demo.models.UserLibrary;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ReservationModelMapper implements ModelMapper<Reservation, ReservationDto> {

    @Autowired
    ApplicationContext ctx;

    @Override
    public Reservation toModelObject(ReservationDto dtoObject, Class<Reservation> reservationClass) {
        Reservation objectModel = ctx.getBean(Reservation.class);
        BeanUtils.copyProperties(dtoObject,objectModel);
        return objectModel;
    }

    @Override
    public ReservationDto toDtoObject(Reservation modelObject, Class<ReservationDto> reservationDtoClass) {
        ReservationDto dtoObject = ctx.getBean(ReservationDto.class);
        BeanUtils.copyProperties(modelObject,dtoObject);
        return dtoObject;
    }
}
