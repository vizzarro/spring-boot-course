package it.aesys.course.library.demo.springboot.hybernate.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="title")
public class Title {

    @Id
    @Column(name="title_id")
    private String titleId;
    @Column(name="name")
    private String name;
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private TypeTitle type;

    @OneToMany(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy="title")
    private List<Reservation> titleReservations;


    public Title() {
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeTitle getType() {
        return type;
    }

    public void setType(TypeTitle type) {
        this.type = type;
    }

    public void addTitle(Reservation reservation){
        this.titleReservations.add(reservation);
    }

    public List<Reservation> getTitleReservations(){
        return this.titleReservations;
    }
}
