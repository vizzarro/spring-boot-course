package org.library.demo.models;

public class StorageProperty {
    private int userLibraryId;
    private int titleId;


    public StorageProperty(int titleId, int userLibraryId) {
        this.titleId = titleId;
        this.userLibraryId = userLibraryId;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public int getUserLibraryId() {
        return userLibraryId;
    }

    public void setUserLibraryId(int userLibraryId) {
        this.userLibraryId = userLibraryId;
    }
}
