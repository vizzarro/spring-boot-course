package org.library.demo.dao;

import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.springframework.stereotype.Repository;

@Repository
public class TitleDaoImpl extends BaseDaoImpl<Title, Integer> implements TitleDao {

  @Override
  public Title get(Integer id) {
    return null;
  }

  @Override
  public Integer create(Title obj) {
    return 0;
  }

  @Override
  public Title update(Title obj) {
    return null;
  }

  @Override
  public void delete(Integer id) {

  }
}
