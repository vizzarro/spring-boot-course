package org.library.demo.controller;

import org.library.demo.models.UserLibrary;
import org.library.demo.service.UserLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/userLibrary")
public class UserLibraryController {

    private UserLibraryService userLibraryService;

    @Autowired
    public UserLibraryController(UserLibraryService userLibraryService) {
        this.userLibraryService = userLibraryService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addUserLibrary(@RequestBody UserLibrary userLibrary)
            throws Exception {
        userLibraryService.addUserLibrary(userLibrary);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteUserLibrary(@PathVariable String taxCode) {
        userLibraryService.deleteUserLibrary(taxCode);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserLibrary> getUserLibrary(@PathVariable String taxCode) {
        UserLibrary response = userLibraryService.getUserLibrary(taxCode);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<UserLibrary> updateUserLibrary(@PathVariable String taxCode, @RequestBody UserLibrary newUserLibrary) {
        UserLibrary response = userLibraryService.updateUserLibrary(taxCode, newUserLibrary);
        return ResponseEntity.ok(response);
    }
}
