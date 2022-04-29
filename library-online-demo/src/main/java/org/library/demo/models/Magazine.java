package org.library.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "title")
public class Magazine implements Title {

    @Id
    @Column(name = "title_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String titleId;

    @Column(name = "name")
    private String name;

    private static int lendingTime = 10;

    @OneToMany(mappedBy = "reservationId.titleId")
//    @JoinTable(name = "reservation",
//            joinColumns = @JoinColumn(name = "tax_code"),
//            inverseJoinColumns = @JoinColumn(name = "title_id"))
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "loanId.titleId")
//    @JoinTable(name = "reservation",
//            joinColumns = @JoinColumn(name = "tax_code"),
//            inverseJoinColumns = @JoinColumn(name = "title_id"))
    private List<Loan> loans;

    public Magazine() {
    }

    public Magazine(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    public void addReservation(Reservation tempReservation) {

        if (null == reservations) {
            reservations = new ArrayList<>();
        }

        reservations.add(tempReservation);
        tempReservation.setTitle(this);
    }

    public void addLoan(Loan tempLoan) {

        if (null == loans) {
            loans = new ArrayList<>();
        }

        loans.add(tempLoan);
        tempLoan.setTitle(this);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public Magazine(List<Loan> loans) {
        this.loans = loans;
    }


}
