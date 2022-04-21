package it.aesys.courses.springboot.lesson2.controllers;

import it.aesys.courses.springboot.lesson2.controllers.exceptions.BadRequestException;
import it.aesys.courses.springboot.lesson2.model.errors.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@ControllerAdvice
public class Lesson2ControllerAdvice {


    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ApiError> badRequest(  Exception ex, WebRequest request) {
        BadRequestException bre = (BadRequestException)ex;

        ApiError error = new ApiError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad Request");
        error.setPath(bre.getPath());
        error.getErrors().addAll(bre.getErrors());

        ResponseEntity<ApiError> errorResponse = ResponseEntity.badRequest().body(error);
        return errorResponse;
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> badRequest(  MethodArgumentNotValidException ex, WebRequest request) {

        ApiError error = new ApiError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());

        error.setMessage("Bad Request");
        error.setPath(ex.getNestedPath());
        error.getErrors().addAll(ex.getAllErrors().stream().map(obj -> {return new it.aesys.courses.springboot.lesson2.model.errors.Error(obj.getObjectName(),obj.getDefaultMessage());}).collect(Collectors.toList()));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.badRequest().body(error);
        return errorResponse;
    }
}
