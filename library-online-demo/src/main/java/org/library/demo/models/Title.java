package org.library.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "title")
public class Title {

    @Id
    @Column(name = "title_id")
    private String titleId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "title")
    private List<Reservation> reservations;


    public Title() {
    }

    public Title(String name, String titleId, String type) {
        this.name = name;
        this.titleId = titleId;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getType() {
        return type;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


    public void addReservation(Reservation reservation) {
        if (null == reservations) {
            reservations = new ArrayList<>();
        }

        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "Title{" +
                "titleId='" + titleId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
