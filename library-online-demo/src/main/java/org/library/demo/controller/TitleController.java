package org.library.demo.controller;

import java.sql.SQLException;

import org.library.demo.dtos.MapperDto;
import org.library.demo.dtos.TitleDto;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addTitle(@RequestBody TitleDto titleDto) throws SQLException {

        Title title = MapperDto.refactor(titleDto);

        service.addTitle(title);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteTitle(@PathVariable String id) throws SQLException {
        service.deleteTitle(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateTitle(@RequestBody TitleDto titleDto) throws SQLException {

        Title title = MapperDto.refactor(titleDto);
        service.updateTitle(title);
        return ResponseEntity.noContent().build();
    }


}
