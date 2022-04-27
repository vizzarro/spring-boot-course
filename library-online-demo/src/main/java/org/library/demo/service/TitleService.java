package org.library.demo.service;

import org.library.demo.models.Title;

import java.sql.SQLException;

public interface TitleService {
  Title getTitle(int id) throws SQLException;
  void addTitle(Title newTitle) throws SQLException;
  void deleteTitle(int id) throws SQLException;
  Title updateTitle(int id, Title updated) throws SQLException;

}
