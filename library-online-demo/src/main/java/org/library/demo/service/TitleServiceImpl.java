package org.library.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.library.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class TitleServiceImpl implements TitleService {

  private GenericRepository<Title> repo;

  public TitleServiceImpl(GenericRepository<Title> repository) {
    this.repo = repository;
  }

  @Override
  public Title getTitle(int id) {
    return repo.getById(id);
  }

  @Override
  public void addTitle(Title newTitle) {
    repo.add(newTitle);
  }

  @Override
  public void deleteTitle(int id) {
    repo.delete(id);
  }

  @Override
  public Title updateTitle(int id, Title updated) {
    return repo.update(id, updated);
  }

}
