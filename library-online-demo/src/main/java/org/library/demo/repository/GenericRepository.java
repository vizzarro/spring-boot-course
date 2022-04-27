package org.library.demo.repository;

import org.library.demo.models.UserLibrary;

public interface GenericRepository<T> {
  T getById(int id);
  void add(T entity);
  void delete(int id);
  T update(int id, T updated);

}
