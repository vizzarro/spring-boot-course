package org.library.demo.service.mapper;

import org.library.demo.dtos.LoanDto;
import org.library.demo.models.Loan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LoanModelMapper implements ModelMapper<Loan, LoanDto>{
    @Autowired
    ApplicationContext ctx;

    @Override
    public Loan toModelObject(LoanDto dtoObject, Class<Loan> reservationClass) {
        Loan objectModel = ctx.getBean(Loan.class);
        BeanUtils.copyProperties(dtoObject,objectModel);
        return objectModel;
    }

    @Override
    public LoanDto toDtoObject(Loan modelObject, Class<LoanDto> reservationDtoClass) {
        LoanDto dtoObject = ctx.getBean(LoanDto.class);
        BeanUtils.copyProperties(modelObject,dtoObject);
        return dtoObject;
    }
}
