package org.library.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LoanDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date creationDate;
    private int titleId;
    private String userLibraryId;

    public LoanDto() {
        this.creationDate = new Date();
    }

    public LoanDto(Date creationDate, int titleId, String userLibraryId) {
        this.creationDate = creationDate;
        this.titleId = titleId;
        this.userLibraryId = userLibraryId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate != null) this.creationDate = creationDate;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getUserLibraryId() {
        return userLibraryId;
    }

    public void setUserLibraryId(String userLibraryId) {
        this.userLibraryId = userLibraryId;
    }
}
