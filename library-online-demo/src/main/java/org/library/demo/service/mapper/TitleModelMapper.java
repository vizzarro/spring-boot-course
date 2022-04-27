package org.library.demo.service.mapper;

import org.library.demo.dtos.ReservationDto;
import org.library.demo.dtos.TitleDto;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TitleModelMapper  implements ModelMapper<Title, TitleDto>{


    @Autowired
    ApplicationContext ctx;

    @Override
    public Title toModelObject(TitleDto dtoObject, Class<Title> titleClass) {
        Title objectModel = ctx.getBean(Title.class);
        BeanUtils.copyProperties(dtoObject,objectModel);
        return objectModel;
    }

    @Override
    public TitleDto toDtoObject(Title modelObject, Class<TitleDto> titleDtoClass) {
        TitleDto dtoObject = ctx.getBean(TitleDto.class);
        BeanUtils.copyProperties(modelObject,dtoObject);
        return dtoObject;
    }
}
