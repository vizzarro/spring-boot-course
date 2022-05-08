package it.aesys.demo.LibraryDemoSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import it.aesys.demo.LibraryDemoSpringBoot.models.Book;
import it.aesys.demo.LibraryDemoSpringBoot.models.Magazine;
import it.aesys.demo.LibraryDemoSpringBoot.models.Title;
import it.aesys.demo.LibraryDemoSpringBoot.service.TitleService;
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
  public ResponseEntity<Title> getTitle(@PathVariable int id) {
    Title response = service.getTitle(id);
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/book")
  public ResponseEntity<Void> addBook(@RequestBody Book newBook) {
    service.addTitle(newBook);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/magazine")
  public ResponseEntity<Void> addMagazine(@RequestBody Magazine newMagazine) {
    service.addTitle(newMagazine);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteTitle(@PathVariable int id) {
    service.deleteTitle(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/book/{id}")
  public ResponseEntity<Title> updateBook(@PathVariable int id, @RequestBody Book newBook) {
    Title response = service.updateTitle(id, newBook);
    return ResponseEntity.ok(response);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/magazine/{id}")
  public ResponseEntity<Title> updateMagazine(@PathVariable int id, @RequestBody Magazine newMagazine) {
    Title response = service.updateTitle(id, newMagazine);
    return ResponseEntity.ok(response);
  }

}
