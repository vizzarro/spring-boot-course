package it.aesys.course.library.demo.springboot.service;


import it.aesys.course.library.demo.springboot.dao.LoanDao;
import it.aesys.course.library.demo.springboot.dao.exception.DaoException;
import it.aesys.course.library.demo.springboot.dto.LoanDto;
import it.aesys.course.library.demo.springboot.models.Loan;
import it.aesys.course.library.demo.springboot.service.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements GenericService<LoanDto, LoanDto>{
    @Autowired
    private LoanDao loanDao;
    @Autowired
    private ModelMapper modelMapper;

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
