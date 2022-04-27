package org.library.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.library.demo.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/title")
public class TitleController {

  private final TitleService service;

  @Autowired
  public TitleController(TitleService titleService) {
    this.service = titleService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Title> getTitle(@PathVariable String id) throws SQLException {
    Title response = service.getTitle(id);
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/book")
  public ResponseEntity<Void> addBook(@RequestBody Book newBook) throws SQLException {
    service.addTitle(newBook);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/magazine")
  public ResponseEntity<Void> addMagazine(@RequestBody Magazine newMagazine) throws SQLException {
    service.addTitle(newMagazine);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteTitle(@PathVariable String id) throws SQLException {
    service.deleteTitle(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/book/{title_id}")
  public ResponseEntity<Title> updateBook(@PathVariable String id, @RequestBody Book newBook) throws SQLException {
    Title response = service.updateTitle(id, newBook);
    return ResponseEntity.ok(response);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/magazine/{title_id}")
  public ResponseEntity<Title> updateMagazine(@PathVariable String id, @RequestBody Magazine newMagazine) throws SQLException {
    Title response = service.updateTitle(id, newMagazine);
    return ResponseEntity.ok(response);
  }

}
