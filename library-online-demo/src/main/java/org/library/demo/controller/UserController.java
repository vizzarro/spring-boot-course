package org.library.demo.controller;

import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.library.demo.service.TitleService;
import org.library.demo.service.UserLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@ResponseBody
@RequestMapping(value = "/user")
public class UserController {
    private final UserLibraryService service;

    @Autowired
    public UserController(UserLibraryService userLibraryService) {
        this.service = userLibraryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{taxCode}")
    public ResponseEntity<UserLibrary> getTitle(@PathVariable String taxCode) throws SQLException {
        UserLibrary response = service.getUserLibrary(taxCode);
        return ResponseEntity.ok().body(response);
    }
}

