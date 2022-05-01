package org.library.demo.service.mapper;

import org.library.demo.dtos.UserLibraryDto;
import org.library.demo.models.UserLibrary;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper implements ModelMapper<UserLibrary, UserLibraryDto> {

    @Autowired
    ApplicationContext ctx;

    @Override
    public UserLibrary toModelObject(UserLibraryDto dtoObject, Class<UserLibrary> userLibraryClass) {
        UserLibrary objectModel = ctx.getBean(UserLibrary.class);
        BeanUtils.copyProperties(dtoObject,objectModel);
        return objectModel;
    }

    @Override
    public UserLibraryDto toDtoObject(UserLibrary modelObject, Class<UserLibraryDto> userLibraryDtoClass) {
            UserLibraryDto dtoObject = ctx.getBean(UserLibraryDto.class);
            BeanUtils.copyProperties(modelObject,dtoObject);
            return dtoObject;
    }
}
