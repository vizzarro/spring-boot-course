package it.aesys.course.library.demo.springboot.hybernate.dto;

import javax.persistence.Column;
import java.util.Date;

public class ReservationIdDto {

    private String titleId;
    private String taxCode;

    private Date creationDate;

    public ReservationIdDto() {

    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
