package org.library.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface BaseDao<T, U> {
  T getById(U u);
  void add(T entity);
  void delete(U id);
  T update(U id, T updated);

  Connection connect();
  void disconnect();

}
