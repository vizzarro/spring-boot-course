package org.library.demo.service;

import org.library.demo.models.Title;

public interface TitleService {
  Title getTitle(String id);
  void addTitle(Title newTitle);
  void deleteTitle(String id);
  Title updateTitle(String id, Title updated);

}
