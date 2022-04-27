package org.library.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LoanDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date creationDate;
    private int titleId;
    private String taxCode;

    public LoanDto() {
        this.creationDate = new Date();
    }

    public LoanDto(Date creationDate, int titleId, String taxCode) {
        this.creationDate = creationDate;
        this.titleId = titleId;
        this.taxCode = taxCode;
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

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
}
