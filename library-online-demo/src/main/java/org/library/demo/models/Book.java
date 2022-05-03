package org.library.demo.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "title")
public class Book implements Title {

    @Id
    @Column(name = "title_id")
    private String titleId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    private static int lendingTime = 30;

    @OneToMany(mappedBy =  "reservationId.titleId")
    private List<Reservation> reservations;

    @OneToMany(mappedBy =  "loanId.titleId")
    private List<Loan> loans;

    public Book() {
    }

    public Book(String name, String titleId) {
        this.name = name;
        this.titleId = titleId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getType(){
        return type;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void addReservation(Reservation reservation){
        if(null == reservations){
            reservations = new ArrayList<>();
        }

        reservations.add(reservation);
    }

    public void addLoans(Loan loan){
        if(null == loans){
            loans = new ArrayList<>();
        }

        loans.add(loan);
    }
}
