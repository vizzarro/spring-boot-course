package org.library.demo.models;

import java.io.Serializable;
import java.util.Date;

public class ReservationKey implements Serializable {

    private String userTaxCode;
    private String titleId;

    public ReservationKey() {
    }

    public ReservationKey(String userTaxCode, String titleId) {
        this.userTaxCode = userTaxCode;
        this.titleId = titleId;
    }

    public String getUserTaxCode() {
        return userTaxCode;
    }

    public void setUserTaxCode(String userTaxCode) {
        this.userTaxCode = userTaxCode;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
}
