package org.library.demo.service;

import java.sql.SQLException;

public interface GenericService<D , IdType> {

    D add(D dtoObject) throws SQLException, ClassNotFoundException;
    D get(IdType id) throws SQLException, ClassNotFoundException;
    D update(IdType id, D dtoObject) throws SQLException, ClassNotFoundException;
    D delete(IdType id) throws SQLException, ClassNotFoundException;

}
