package it.aesys.demo.LibraryDemoSpringBoot.service;

import it.aesys.demo.LibraryDemoSpringBoot.models.Title;

public interface TitleService {
  Title getTitle(int id);
  void addTitle(Title newTitle);
  void deleteTitle(int id);
  Title updateTitle(int id, Title updated);

}
