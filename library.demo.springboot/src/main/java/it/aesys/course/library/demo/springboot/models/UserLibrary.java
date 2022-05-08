package it.aesys.course.library.demo.springboot.models;


import javax.persistence.*;

@Entity
@Table(name = "user_library")
public class UserLibrary {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

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


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
