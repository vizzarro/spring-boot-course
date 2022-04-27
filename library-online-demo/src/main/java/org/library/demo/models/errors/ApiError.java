package it.aesys.infopeople.infopeople.model.errors;

import java.util.ArrayList;
import java.util.List;

public class ApiError {

    private Integer statusCode;
    private String message;
    private String path;
    private List<ErrorModel> errors;

    public ApiError() {
        errors = new ArrayList<>();
    }

    public ApiError(Integer statusCode, String message, String path, List<ErrorModel> errors) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
