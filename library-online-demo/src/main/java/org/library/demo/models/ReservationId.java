package org.library.demo.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReservationId implements Serializable {

    private static final long serialVersionUID = 3181564449443687533L;
    private String titleId;
    private String taxCode;

    public ReservationId() {
    }

    public ReservationId(String titleId, String taxCode) {
        this.titleId = titleId;
        this.taxCode = taxCode;
    }


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
