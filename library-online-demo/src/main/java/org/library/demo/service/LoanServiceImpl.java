package org.library.demo.service;

import org.library.demo.models.Loan;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.library.demo.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanServiceImpl implements LoanService {
  private BaseDao<Loan, Date> loanDao;
  private BaseDao<Title, String> titleDao;
  private BaseDao<UserLibrary, String> userLibraryDao;

  @Autowired
  public LoanServiceImpl(
      BaseDao<Loan, Date> loanDao,
      BaseDao<Title, String> titleDao,
      BaseDao<UserLibrary, String> userLibraryDao
  ) {
    this.loanDao = loanDao;
    this.titleDao = titleDao;
    this.userLibraryDao = userLibraryDao;
  }

  @Override
  public void addLoan(Loan newLoan) throws Exception {
    if (newLoan == null)
      throw new Exception("No request");

    try {
      UserLibrary u = userLibraryDao.getById(newLoan.getTaxCode());
    } catch (Exception e) {
      throw new Exception("No Borrower found for id " + newLoan.getTaxCode());
    }

    Title exists = titleDao.getById(newLoan.getTitleId());
    if (exists == null)
      throw new Exception("No Title found for id " + newLoan.getTitleId());

    loanDao.add(newLoan);
  }

  @Override
  public Loan getLoan(Date id) {
    return loanDao.getById(id);
  }

  @Override
  public void deleteLoan(Date id) {
    this.loanDao.delete(id);
  }

  @Override
  public Loan updateLoan(Date id, Loan updated) {
    return this.loanDao.update(id, updated);
  }
}
