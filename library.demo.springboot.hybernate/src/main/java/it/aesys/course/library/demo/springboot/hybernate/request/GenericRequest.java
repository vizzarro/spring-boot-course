package it.aesys.course.library.demo.springboot.hybernate.request;

public class GenericRequest<T> {

    private T requestData;

    public T getRequestData() {
        return requestData;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }
}
