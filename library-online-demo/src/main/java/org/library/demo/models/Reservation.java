package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {

    @EmbeddedId
    private ReservationId reservationId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @MapsId("taxCode")
    @JoinColumn(name = "tax_code")
    private UserLibrary userLibrary;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @MapsId("titleId")
    @JoinColumn(name = "title_id")
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
