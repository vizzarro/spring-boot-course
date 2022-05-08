package org.library.demo.controller;

import org.library.demo.dtos.UserLibraryDto;
import org.library.demo.request.GenericRequest;
import org.library.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/user")
public class UserLibraryController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserLibraryDto> getUser(@PathVariable String id) throws SQLException, ClassNotFoundException {
        UserLibraryDto response = userServiceImpl.get(id);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<UserLibraryDto> addUser(@RequestBody GenericRequest<UserLibraryDto> requestUser) throws SQLException, ClassNotFoundException {
        UserLibraryDto response = userServiceImpl.add(requestUser.getRequestData());
        return ResponseEntity.ok().body(response);
    }
    @RequestMapping(method= RequestMethod.PUT, value="/{id}")
    public ResponseEntity<UserLibraryDto> updateUser(@RequestBody GenericRequest<UserLibraryDto> requestUser, @PathVariable String id) throws SQLException, ClassNotFoundException {
        UserLibraryDto response = userServiceImpl.update(id, requestUser.getRequestData());
        return ResponseEntity.ok().body(response);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public ResponseEntity<UserLibraryDto> removeUser(@PathVariable String id) throws SQLException, ClassNotFoundException {
        UserLibraryDto response = userServiceImpl.delete(id);
        return ResponseEntity.ok().body(response);
    }
}
