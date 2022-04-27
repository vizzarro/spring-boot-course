package org.library.demo.service;

import java.sql.SQLException;

import org.library.demo.models.Title;
import org.library.demo.repository.connection.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleServiceImpl implements TitleService {

  private BaseDao<Title, String> repo;
  @Autowired
  public TitleServiceImpl(BaseDao<Title, String> repository) {
    this.repo = repository;
  }

  @Override
  public Title getTitle(String id) throws SQLException {
    return repo.getById(id);
  }

  @Override
  public void addTitle(Title newTitle) throws SQLException {
    repo.add(newTitle);
  }

  @Override
  public void deleteTitle(String id) throws SQLException {
    repo.delete(id);
  }

  @Override
  public Title updateTitle(String id, Title updated) throws SQLException {
    return repo.update(id, updated);
  }

}
