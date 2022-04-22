package it.aesys.infopeople.infopeople.services.exceptions;

import java.util.ArrayList;
import java.util.List;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;

public class BadRequestException extends Exception {

    private List<ErrorModel> errors = new ArrayList<>();
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

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }
}

