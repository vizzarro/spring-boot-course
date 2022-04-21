package it.aesys.courses.springboot.lesson2.controllers.exceptions;


import it.aesys.courses.springboot.lesson2.model.errors.Error;

import java.util.ArrayList;
import java.util.List;

public class BadRequestException extends RuntimeException{

    private List<Error> errors = new ArrayList<>();
    private String path;



    public BadRequestException() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
