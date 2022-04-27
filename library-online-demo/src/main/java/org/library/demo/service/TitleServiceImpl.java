package org.library.demo.service;

import org.library.demo.dao.TitleDao;
import org.library.demo.dao.TitleDaoImpl;
import org.library.demo.models.Title;
import org.springframework.stereotype.Service;

@Service
public class TitleServiceImpl implements TitleService {

  private TitleDao titleDao;

  public TitleServiceImpl(TitleDao titleDao) {
    this.titleDao = titleDao;
  }

  @Override
  public Title getTitle(int id) {
    return titleDao.get(id);
  }

  @Override
  public void addTitle(Title newTitle) {
    titleDao.create(newTitle);
  }

  @Override
  public void deleteTitle(int id) {
    titleDao.delete(id);
  }

  @Override
  public Title updateTitle(int id, Title updated) {
    return titleDao.update(updated);
  }

}
