package org.library.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_library")
public class UserLibrary {

    @Id
    @Column(name = "tax_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String taxCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "reservationId.taxCode")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "reservationId.taxCode")
    private List<Loan> loans;

    public UserLibrary() {
    }

    public UserLibrary(String firstName, String lastName, String taxCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxCode = taxCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
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
