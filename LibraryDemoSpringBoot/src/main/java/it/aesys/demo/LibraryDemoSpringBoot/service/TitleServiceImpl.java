package it.aesys.demo.LibraryDemoSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import it.aesys.demo.LibraryDemoSpringBoot.models.Title;
import it.aesys.demo.LibraryDemoSpringBoot.repository.GenericRepository;
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
