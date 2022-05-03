package it.aesys.course.library.demo.springboot.hybernate.controller;


import it.aesys.course.library.demo.springboot.hybernate.dto.UserLibraryDto;
import it.aesys.course.library.demo.springboot.hybernate.request.GenericRequest;
import it.aesys.course.library.demo.springboot.hybernate.service.UserServiceImpl;
import it.aesys.course.library.demo.springboot.hybernate.service.client.PeopleServiceImpl;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserLibraryController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    private PeopleServiceImpl peopleService;
    @Autowired
    public UserLibraryController(){
        this.peopleService = new PeopleServiceImpl();
    }


    @GetMapping("{id}")
    public ResponseEntity<UserLibraryDto> getUser(@PathVariable String id) throws ServiceException {
        UserLibraryDto response = userServiceImpl.get(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<UserLibraryDto> addUser(@RequestBody GenericRequest<UserLibraryDto> requestUser) throws ServiceException {
        peopleService.findPerson(requestUser.getRequestData().getTaxCode());
            UserLibraryDto response = userServiceImpl.add(requestUser.getRequestData());
            return ResponseEntity.ok().body(response);

    }
    @PutMapping("{id}")
    public ResponseEntity<UserLibraryDto> updateUser(@RequestBody GenericRequest<UserLibraryDto> requestUser, @PathVariable String id) throws ServiceException {
        UserLibraryDto response = userServiceImpl.update(id, requestUser.getRequestData());
        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeUser(@PathVariable String id) throws ServiceException {
        userServiceImpl.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserLibraryDto>> getAllUser () throws ServiceException{
        List<UserLibraryDto> response =  userServiceImpl.getAll();
        return ResponseEntity.ok().body(response);
    }
}
