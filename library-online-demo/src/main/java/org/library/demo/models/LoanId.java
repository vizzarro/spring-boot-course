package org.library.demo.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class LoanId {

    private String titleId;
    private String taxCode;

    public LoanId(String titleId, String taxCode) {
        this.titleId = titleId;
        this.taxCode = taxCode;
    }

    public  LoanId() { }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
}
