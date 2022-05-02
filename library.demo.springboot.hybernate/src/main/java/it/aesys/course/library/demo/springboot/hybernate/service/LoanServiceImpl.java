package it.aesys.course.library.demo.springboot.hybernate.service;



import it.aesys.course.library.demo.springboot.hybernate.dao.LoanDao;
import it.aesys.course.library.demo.springboot.hybernate.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.hybernate.dto.LoanDto;
import it.aesys.course.library.demo.springboot.hybernate.models.Loan;
import it.aesys.course.library.demo.springboot.hybernate.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements GenericService<LoanDto, LoanDto>{
    private LoanDao loanDao;

    private ModelMapper modelMapper;


    @Autowired
    public LoanServiceImpl(){
        this.loanDao = new LoanDao();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<LoanDto> getAll() throws ServiceException {
        return null;
    }

    @Override
    public LoanDto add(LoanDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(loanDao.add(modelMapper.map(dtoObject, Loan.class)), LoanDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public LoanDto get(LoanDto id) throws ServiceException {
        try {
            return modelMapper.map(loanDao.get(modelMapper.map(id, Loan.class)), LoanDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public LoanDto update(LoanDto id, LoanDto dtoObject) throws ServiceException {
        try {
            return modelMapper.map(loanDao.update(modelMapper.map(id, Loan.class), modelMapper.map(dtoObject, Loan.class)), LoanDto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public void delete(LoanDto id) throws ServiceException {
        try {
            loanDao.delete(modelMapper.map(id, Loan.class));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
