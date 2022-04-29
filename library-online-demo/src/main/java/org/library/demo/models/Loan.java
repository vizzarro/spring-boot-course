package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table( name = "loans")
public class Loan {

    @EmbeddedId
    private LoanId loanid;

    public LoanId getLoanid() {
        return loanid;
    }

    public void setLoanid(LoanId loanid) {
        this.loanid = loanid;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @MapsId("taxCode")
    @JoinColumn(name = "tax_code")
    private UserLibrary userLibrary;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @MapsId("titleId")
    @JoinColumn(name = "title_id")
    private Title title;

    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
    private Date creationDate;


    public Loan() {
        this.creationDate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate != null) this.creationDate = creationDate;
    }

}
