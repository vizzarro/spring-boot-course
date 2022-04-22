package it.aesys.infopeople.infopeople.model.errors;

public class ErrorModel {

    private String field;
    private String message;

    public ErrorModel() {
        super();
    }

    public ErrorModel(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
