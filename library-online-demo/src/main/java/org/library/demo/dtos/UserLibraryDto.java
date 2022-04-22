package org.library.demo.dtos;

import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import java.util.List;

public class UserLibraryDto {

    private PersonDto personDto;
    private List<Reservation> reservations;
    private List<Title> titles;

    public UserLibraryDto() {
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

}
