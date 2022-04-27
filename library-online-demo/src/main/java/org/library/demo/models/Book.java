package org.library.demo.models;

import org.library.demo.config.MvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


@Component
public class Book implements Title {
    private String name;
    private String titleId;
    private int lendingTime = 30;
    private Integer id;
    @Autowired
    private Storage storage;
    private Integer userLibraryId;



    private String type = "BOOK";

    public Book() {
    }

    public Book(String name, Integer id, Integer userLibraryId) {
        this.name = name;
        this.id = id;
        // da capire perchè non funziona
        //storage.addStorageProperty(id, userLibraryId);

        Storage.getIstance().addStorageProperty(id, userLibraryId);
    }

    public Book(String name, String titleId) {
        this.name = name;
        this.titleId = titleId;
    }


    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserLibraryId() {
        return userLibraryId;
    }

    public void setUserLibraryId(Integer userLibraryId) {
        this.userLibraryId = userLibraryId;
    }

    @Override
    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLendingTime() {
        return lendingTime;
    }

    public void setLendingTime(int lendingTime) {
        this.lendingTime = lendingTime;
    }

    @Override
    public String getType() {
        return type;
    }
}
