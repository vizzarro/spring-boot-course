package it.aesys.course.library.demo.springboot.hybernate.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReservationDto {
    private int reservationId;

    private String taxCode;
    private String titleId;
    private Date creationDate;

    public ReservationDto() {
    }


    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
