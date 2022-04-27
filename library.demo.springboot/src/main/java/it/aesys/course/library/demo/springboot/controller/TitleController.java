package it.aesys.course.library.demo.springboot.controller;

import it.aesys.course.library.demo.springboot.dto.TitleDto;
import it.aesys.course.library.demo.springboot.request.GenericRequest;
import it.aesys.course.library.demo.springboot.service.TitleServiceImpl;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/title")
public class TitleController {

    @Autowired
    private TitleServiceImpl titleService;


    @PostMapping
    public ResponseEntity<TitleDto> addTitle(@RequestBody GenericRequest<TitleDto> request) throws ServiceException {
        TitleDto response = titleService.add(request.getRequestData());
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteTitle(@PathVariable String id) throws ServiceException {
        titleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable String id) throws ServiceException {
        TitleDto response = titleService.get(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<TitleDto> updateTitle(@RequestBody GenericRequest<TitleDto> request, @PathVariable String id) throws ServiceException {
        TitleDto response = titleService.update(id, request.getRequestData());
        return ResponseEntity.ok().body(response);
    }
}
