package org.library.demo.service;

import java.sql.SQLException;
import org.library.demo.models.Title;
import org.library.demo.repository.GenericDao;
import org.library.demo.repository.exception.DaoException;
import org.library.demo.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class TitleServiceImpl implements TitleService {

  private GenericDao<Title,String> repo;

  public TitleServiceImpl(GenericDao<Title,String> repository) {
    this.repo = repository;
  }

  @Override
  public Title getTitle(String id) {
    return repo.getById(id);
  }

  @Override
  public void addTitle(Title newTitle) throws SQLException, ClassNotFoundException {
    repo.add(newTitle);
  }

  @Override
  public void deleteTitle(String id) throws ClassNotFoundException, SQLException {
    try {
      this.repo.delete(id);
    } catch (DaoException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Title updateTitle(String id, Title updated) {
    return repo.update(id, updated);
  }

}
