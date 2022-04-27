package it.aesys.course.library.demo.springboot.controller;

import it.aesys.course.library.demo.springboot.errors.ApiError;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class LibraryControllerAdvice {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ApiError> serviceExceptionHandling(ServiceException ex, WebRequest request) {

        ApiError error = new ApiError();
        error.setStatusCode(ex.getStatusCode());
        error.setMessage(ex.getMessage());
        error.setPath(ex.getPath());
        error.getErrors().addAll(ex.getErrors());

        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }
}
