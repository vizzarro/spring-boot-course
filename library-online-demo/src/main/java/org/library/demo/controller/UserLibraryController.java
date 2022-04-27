package org.library.demo.controller;

import org.library.demo.dtos.MapperDto;
import org.library.demo.dtos.UserLibraryDto;
import org.library.demo.models.UserLibrary;
import org.library.demo.service.UserLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "userLibrary")
public class UserLibraryController {

    private UserLibraryService service;

    @Autowired
    public UserLibraryController(UserLibraryService userLibraryService) {
        this.service = userLibraryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserLibrary> getUserLibrary(@PathVariable String id) throws SQLException {
        UserLibrary response = service.getUserLibrary(id);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addUserLibrary(@RequestBody UserLibraryDto userLibraryDto) throws Exception {

        UserLibrary userLibrary = MapperDto.refactor(userLibraryDto);

        service.addUserLibrary(userLibrary);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteUserLibrary(@PathVariable String id) throws SQLException {
        service.deleteUserLibrary(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UserLibrary> updateUserLibrary(@RequestBody UserLibraryDto userLibraryDto) throws SQLException {

        UserLibrary userLibrary = MapperDto.refactor(userLibraryDto);

        UserLibrary response = service.updateUserLibrary(userLibrary);
        return ResponseEntity.ok(response);
    }
}
