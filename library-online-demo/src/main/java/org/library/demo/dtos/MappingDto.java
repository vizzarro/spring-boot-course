package org.library.demo.dtos;

import org.library.demo.models.*;
import org.springframework.beans.BeanUtils;

public class MappingDto {

    public static Title refactor (TitleDto titleDto){
        Title newTitle;
        if(titleDto.getType().equals("BOOK"))
            newTitle = new Book();
        else newTitle = new Magazine();

        BeanUtils.copyProperties(titleDto, newTitle);
        return newTitle;
    }

    public static Loan refactor (LoanDto loanDto){

        Loan newLoan = new Loan();

        BeanUtils.copyProperties(loanDto, newLoan);
        return newLoan;
    }

    public static Reservation refactor (ReservationDto reservationDto){

        Reservation newReservation = new Reservation();

        BeanUtils.copyProperties(reservationDto, newReservation);
        return newReservation;
    }

    public static UserLibrary refactor (UserLibraryDto userLibraryDto){

        UserLibrary newUserLibrary = new UserLibrary();

        BeanUtils.copyProperties(userLibraryDto, newUserLibrary);
        return newUserLibrary;
    }

}
