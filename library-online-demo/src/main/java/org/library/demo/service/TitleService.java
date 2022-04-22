package org.library.demo.service;

import org.library.demo.models.Title;

public interface TitleService {
  Title getTitle(int id);
  void addTitle(Title newTitle);
  void deleteTitle(int id);
  Title updateTitle(int id, Title updated);

}
