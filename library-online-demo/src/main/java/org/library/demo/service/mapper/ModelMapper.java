package org.library.demo.service.mapper;

public interface ModelMapper<Model, Dto> {

    Model toModelObject(Dto dtoObject, Class<Model> modelClass);
    Dto toDtoObject(Model modelObject, Class<Dto> dtoClass);

}
