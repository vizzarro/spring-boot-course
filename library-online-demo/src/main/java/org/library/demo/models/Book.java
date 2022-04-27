package org.library.demo.models;

public class Book implements Title {
    private String name;
    private static int lendingTime = 30;
    private String titleId;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

}
