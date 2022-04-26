package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Storage {
    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
    private Date creationDate;
    private List<StorageProperty> storagePropertyList = new ArrayList<>();
    private static Storage istance=null; // riferimento all' istanza

    public Storage() {
        this.creationDate = new Date();


    } // costruttore

    public static Storage getIstance() {
        if(istance==null)
            istance = new Storage();
        return istance;
    }

    public void addStorageProperty(int titleid, int userLibraryId) {
        StorageProperty storageProperty = new StorageProperty(titleid, userLibraryId);
        storagePropertyList.add(storageProperty);
    }

    public Storage(Date creationDate, int titleId) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate != null)
            this.creationDate = creationDate;
    }
}
