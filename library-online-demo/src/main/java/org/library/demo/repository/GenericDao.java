package org.library.demo.repository;

import org.hibernate.SessionFactory;
import org.library.demo.repository.exception.DaoException;
import java.sql.Connection;
import java.sql.SQLException;

public interface GenericDao<T,K> {
  T getById(K id);
  void add(T entity) throws ClassNotFoundException, SQLException;
  void delete(K id) throws ClassNotFoundException, SQLException, DaoException;
  T update(K id, T updated);
    SessionFactory getSessionFactory() throws ClassNotFoundException, SQLException;
   void deleteSession(SessionFactory session) throws SQLException, ClassNotFoundException;

}
