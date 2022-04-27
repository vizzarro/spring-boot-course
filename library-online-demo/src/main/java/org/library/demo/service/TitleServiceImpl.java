package org.library.demo.service;

import org.library.demo.models.Title;
import org.library.demo.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleServiceImpl implements TitleService {

  private BaseDao<Title, String> titleDao;

  @Autowired
  public TitleServiceImpl(BaseDao<Title, String> titleDao) {
    this.titleDao = titleDao;
  }

  @Override
  public Title getTitle(String id) {
    return titleDao.getById(id);
  }

  @Override
  public void addTitle(Title newTitle) {
    titleDao.add(newTitle);
  }

  @Override
  public void deleteTitle(String id) {
    titleDao.delete(id);
  }

  @Override
  public Title updateTitle(String id, Title updated) {
    return titleDao.update(id, updated);
  }

}
