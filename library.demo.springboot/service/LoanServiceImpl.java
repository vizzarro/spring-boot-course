package org.library.demo.service;

import org.library.demo.dao.LoanDao;
import org.library.demo.dtos.LoanDto;
import org.library.demo.models.Loan;
import org.library.demo.service.mapper.LoanModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoanServiceImpl implements GenericService<LoanDto, LoanDto>{
    @Autowired
    private LoanDao loanDao;
    @Autowired
    private LoanModelMapper modelMapper;

    @Override
    public LoanDto add(LoanDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(loanDao.add(modelMapper.toModelObject(dtoObject, Loan.class)), LoanDto.class);
    }

    @Override
    public LoanDto get(LoanDto id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(loanDao.get(modelMapper.toModelObject(id, Loan.class)), LoanDto.class);
    }

    @Override
    public LoanDto update(LoanDto id, LoanDto dtoObject) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(loanDao.update(modelMapper.toModelObject(id, Loan.class), modelMapper.toModelObject(dtoObject, Loan.class)), LoanDto.class);

    }

    @Override
    public LoanDto delete(LoanDto id) throws SQLException, ClassNotFoundException {
        return modelMapper.toDtoObject(loanDao.delete(modelMapper.toModelObject(id, Loan.class)), LoanDto.class);
    }
}
