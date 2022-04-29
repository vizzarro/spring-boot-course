package org.library.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
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

    @ManyToMany
    @JoinTable(name = "reservation",
            joinColumns=@JoinColumn(name="tax_code"),
            inverseJoinColumns=@JoinColumn(name="title_id"))
    private List<Title> titlesR;

    @ManyToMany
    @JoinTable(name = "loan",
            joinColumns=@JoinColumn(name="tax_code"),
            inverseJoinColumns=@JoinColumn(name="title_id"))
    private List<Title> titlesL;

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

    public List<Title> getTitlesR() {
        return titlesR;
    }

    public void setTitlesR(List<Title> titlesR) {
        this.titlesR = titlesR;
    }

    public List<Title> getTitlesL() {
        return titlesL;
    }

    public void setTitlesL(List<Title> titlesL) {
        this.titlesL = titlesL;
    }


}
