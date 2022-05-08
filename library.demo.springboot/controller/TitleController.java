package org.library.demo.controller;

import org.library.demo.dtos.TitleDto;
import org.library.demo.request.GenericRequest;
import org.library.demo.service.TitleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/title")
public class TitleController {

    @Autowired
    private TitleServiceImpl titleService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TitleDto> addTitle(@RequestBody GenericRequest<TitleDto> request) throws SQLException, ClassNotFoundException {
        TitleDto response = titleService.add(request.getRequestData());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<TitleDto> deleteTitle(@PathVariable String id) throws SQLException, ClassNotFoundException {
        TitleDto response = titleService.delete(id);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable String id) throws SQLException, ClassNotFoundException {
        TitleDto response = titleService.get(id);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/{id}")
    public ResponseEntity<TitleDto> updateTitle(@RequestBody GenericRequest<TitleDto> request, @PathVariable String id) throws SQLException, ClassNotFoundException {
        TitleDto response = titleService.update(id, request.getRequestData());
        return ResponseEntity.ok().body(response);
    }
}
