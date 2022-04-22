package it.aesys.infopeople.infopeople.controller;

import it.aesys.infopeople.infopeople.model.errors.ApiError;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;
import it.aesys.infopeople.infopeople.services.exceptions.BadRequestException;
import it.aesys.infopeople.infopeople.services.exceptions.ControllerException;
import it.aesys.infopeople.infopeople.services.exceptions.RepositoryException;
import it.aesys.infopeople.infopeople.services.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

public class ControllerAdvice {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ApiError> serviceExceptionHandling(ServiceException ex, WebRequest request) {

        ApiError error = new ApiError();
        error.setStatusCode(ex.getStatusCode());
        error.setMessage(ex.getMessage());
        error.setPath(ex.getPath());
        error.getErrors().addAll(ex.getErrors());

        ResponseEntity<ApiError> errorResponse = ResponseEntity.status(ex.getStatusCode()).body(error);
        return errorResponse;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> badRequest(  MethodArgumentNotValidException ex, WebRequest request) {

        ApiError error = new ApiError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());

        error.setMessage("Bad Request");
        error.setPath(ex.getNestedPath());
        error.getErrors().addAll(ex.getAllErrors().stream().map(obj -> {return new ErrorModel(obj.getObjectName(),obj.getDefaultMessage());}).collect(Collectors.toList()));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.badRequest().body(error);
        return errorResponse;
    }


}
