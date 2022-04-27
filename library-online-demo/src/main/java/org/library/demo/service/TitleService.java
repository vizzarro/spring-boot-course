package org.library.demo.service;

import org.library.demo.models.Title;
import org.library.demo.service.exceptions.ServiceException;

import java.sql.SQLException;

public interface TitleService {
  Title getTitle(String id);
  void addTitle(Title newTitle) throws ClassNotFoundException, SQLException;
  void deleteTitle(String id) throws ClassNotFoundException, SQLException, ServiceException;
  Title updateTitle(String id, Title updated);

}
