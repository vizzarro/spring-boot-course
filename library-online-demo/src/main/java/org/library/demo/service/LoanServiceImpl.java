package org.library.demo.service;

import org.library.demo.dao.*;
import org.library.demo.models.Loan;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoanServiceImpl implements LoanService {
    private LoanDao loanDao;
    private TitleDao titleDao;
    private UserLibraryDao ulDao;

    @Autowired
    public LoanServiceImpl(
            LoanDao loanDao,
            TitleDao titleDao,
            UserLibraryDao ulDao
    ) {
        this.loanDao = loanDao;
        this.titleDao = titleDao;
        this.ulDao = ulDao;
    }

    @Override
    public Loan addLoan(Loan newLoan) throws Exception {
        if (newLoan == null)
            throw new Exception("No request");

        try {
            UserLibrary u = ulDao.get(newLoan.getLoanid().getTaxCode());
        } catch (Exception e) {
            throw new Exception("No Borrower found for id " + newLoan.getLoanid().getTaxCode());
        }

        Title exists = titleDao.get(newLoan.getLoanid().getTitleId());
        if (exists == null)
            throw new Exception("No Title found for id " + newLoan.getLoanid().getTitleId());


        loanDao.create(newLoan);
        return newLoan;
    }

    @Override
    public Loan getLoan(String id) throws SQLException {
        return loanDao.get(id);
    }

    @Override
    public Loan deleteLoan(String id) throws SQLException {
        this.loanDao.delete(id);
        return null;
    }

    @Override
    public void updateLoan(Loan updeted) throws SQLException {
        this.loanDao.update(updeted);
    }
}
