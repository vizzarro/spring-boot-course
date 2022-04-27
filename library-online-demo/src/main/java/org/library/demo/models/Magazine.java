package org.library.demo.models;

public class Magazine implements Title {
    private String name;
    private static int lendingTime = 10;
    private String titleId;

    public Magazine() {
    }

    public Magazine(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

}
