package it.aesys.infopeople.infopeople.model;

import java.util.ArrayList;
import java.util.List;

public class Persons {

    List<Person> collection = new ArrayList<>();

    public Persons() {
    }

    public List<Person> getCollection() {
        return collection;
    }

    public void setCollection(List<Person> collection) {
        this.collection = collection;
    }
}
