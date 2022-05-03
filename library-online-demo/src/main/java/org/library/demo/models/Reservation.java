package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    private Reservation reservationId;
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
    }

    public Reservation(UserLibrary userLibrary, Title title, Date creationDate) {
        this.userLibrary = userLibrary;
        this.title = title;
        this.creationDate = new Date();
    }

    public Reservation(UserLibrary userLibrary, Title title) {
        this.userLibrary = userLibrary;
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserLibrary getUserLibrary() {
        return userLibrary;
    }

    public void setUserLibrary(UserLibrary userLibrary) {
        this.userLibrary = userLibrary;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Reservation getReservationId() {
        return reservationId;
    }

    public void setReservationId(Reservation reservationId) {
        this.reservationId = reservationId;
    }
}
