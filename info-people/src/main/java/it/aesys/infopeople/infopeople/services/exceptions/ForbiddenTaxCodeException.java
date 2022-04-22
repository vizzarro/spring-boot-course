package it.aesys.infopeople.infopeople.services.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ForbiddenTaxCodeException extends Exception {

    private String path;

    public ForbiddenTaxCodeException() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ForbiddenTaxCodeException(String message) {
        super(message);
    }

    public ForbiddenTaxCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenTaxCodeException(Throwable cause) {
        super(cause);
    }

    public ForbiddenTaxCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
