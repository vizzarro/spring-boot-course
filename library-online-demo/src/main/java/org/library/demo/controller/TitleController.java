package org.library.demo.controller;

import org.library.demo.models.Book;
import org.library.demo.models.Magazine;
import org.library.demo.models.Title;
import org.library.demo.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/title")
public class TitleController {

  private final TitleService titleService;

  @Autowired
  public TitleController(TitleService titleService) {
    this.titleService = titleService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Title> getTitle(@PathVariable String id) {
    Title response = titleService.getTitle(id);
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/book")
  public ResponseEntity<Void> addBook(@RequestBody Book newBook) {
    titleService.addTitle(newBook);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/magazine")
  public ResponseEntity<Void> addMagazine(@RequestBody Magazine newMagazine) {
    titleService.addTitle(newMagazine);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteTitle(@PathVariable String id) {
    titleService.deleteTitle(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/book/{id}")
  public ResponseEntity<Title> updateBook(@PathVariable String id, @RequestBody Book newBook) {
    Title response = titleService.updateTitle(id, newBook);
    return ResponseEntity.ok(response);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/magazine/{id}")
  public ResponseEntity<Title> updateMagazine(@PathVariable String id, @RequestBody Magazine newMagazine) {
    Title response = titleService.updateTitle(id, newMagazine);
    System.out.println(response.toString());
    return ResponseEntity.ok(response);
  }

}
