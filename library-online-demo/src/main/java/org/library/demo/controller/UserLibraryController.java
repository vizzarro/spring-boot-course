package org.library.demo.controller;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.exception.DaoException;
import org.library.demo.service.UserLibraryService;
import org.library.demo.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
@RequestMapping("/user")
public class UserLibraryController {

    private UserLibraryService service;

    @Autowired
    public UserLibraryController(UserLibraryService userLibraryServiceService) {
        this.service = userLibraryServiceService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody UserLibrary user)
            throws Exception {
        service.addBorrower(user);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserLibrary> getUser(@PathVariable String id) {
        UserLibrary response = service.getBorrower(id);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) throws ClassNotFoundException, SQLException, ServiceException, DaoException {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
