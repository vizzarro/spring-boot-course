package it.aesys.infopeople.infopeople.controller;

import it.aesys.infopeople.infopeople.model.errors.ApiError;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;
import it.aesys.infopeople.infopeople.services.exceptions.BadRequestException;
import it.aesys.infopeople.infopeople.services.exceptions.ForbiddenTaxCodeException;
import it.aesys.infopeople.infopeople.services.exceptions.InvalidZIPCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

public class ControllerAdvice {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ApiError> badRequest(Exception ex, WebRequest request) {
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
        error.getErrors().addAll(ex.getAllErrors().stream().map(obj -> {return new ErrorModel(obj.getObjectName(),obj.getDefaultMessage());}).collect(Collectors.toList()));

        ResponseEntity<ApiError> errorResponse = ResponseEntity.badRequest().body(error);
        return errorResponse;
    }

    @ExceptionHandler(value = ForbiddenTaxCodeException.class)
    public ResponseEntity<ApiError> forbiddenTaxCOde(  ForbiddenTaxCodeException ex, WebRequest request) {

        ApiError error = new ApiError();

        error.setStatusCode(HttpStatus.FORBIDDEN.value());
        error.setMessage("Forbidden TaxCode");
        error.setPath(ex.getPath());

        ResponseEntity<ApiError> errorResponse = ResponseEntity.badRequest().body(error);
        return errorResponse;
    }

    @ExceptionHandler(value = InvalidZIPCodeException.class)
    public ResponseEntity<ApiError> invalidZIPCode(  InvalidZIPCodeException ex, WebRequest request) {

        ApiError error = new ApiError();
        error.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage("Invalid ZIP Code");
        error.setPath(ex.getPath());
        error.getErrors().addAll(ex.getErrors());

        ResponseEntity<ApiError> errorResponse = ResponseEntity.badRequest().body(error);
        return errorResponse;
    }


}
