package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {

    @EmbeddedId
    private ReservationId reservationId;

    @ManyToOne
    @MapsId("taxCode")
    private UserLibrary userLibrary;

    @ManyToOne
    @MapsId("titleId")
    private Title title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date creationDate;

    public Reservation() {
        this.creationDate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
