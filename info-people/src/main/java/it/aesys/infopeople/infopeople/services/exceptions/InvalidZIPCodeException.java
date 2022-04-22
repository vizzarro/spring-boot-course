package it.aesys.infopeople.infopeople.services.exceptions;

import java.util.ArrayList;
import java.util.List;
import it.aesys.infopeople.infopeople.model.errors.ErrorModel;

public class InvalidZIPCodeException extends Exception{

    private List<ErrorModel> errors = new ArrayList<>();
    private String path;

    public InvalidZIPCodeException() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public InvalidZIPCodeException(String message) {
        super(message);
    }

    public InvalidZIPCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidZIPCodeException(Throwable cause) {
        super(cause);
    }

    public InvalidZIPCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
