package org.library.demo.service;

import org.library.demo.models.Title;

import java.sql.SQLException;

public interface TitleService {
  Title getTitle(String id) throws SQLException;
  void addTitle(Title newTitle) throws SQLException;
  void deleteTitle(String id) throws SQLException;
  void updateTitle(Title updated) throws SQLException;

}
