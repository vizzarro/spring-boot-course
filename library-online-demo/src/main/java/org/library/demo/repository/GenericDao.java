package org.library.demo.repository;

import org.library.demo.repository.exception.DaoException;
import java.sql.Connection;
import java.sql.SQLException;

public interface GenericDao<T,K> {
  T getById(K id);
  void add(T entity) throws ClassNotFoundException, SQLException;
  void delete(K id) throws ClassNotFoundException, SQLException, DaoException;
  T update(K id, T updated);
   Connection getConnection() throws ClassNotFoundException, SQLException;
   void deleteConnection(Connection conn) throws SQLException, ClassNotFoundException;

}
