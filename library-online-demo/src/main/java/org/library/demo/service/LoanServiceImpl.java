package org.library.demo.service;

import org.library.demo.models.Loan;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericDao;
import org.library.demo.repository.exception.DaoException;
import org.library.demo.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class LoanServiceImpl implements LoanService {
  private GenericDao<Loan,Loan> repo;
  private GenericDao<Title,String> titleRepo;
  private GenericDao<UserLibrary,String> userRepo;

  @Autowired
  public LoanServiceImpl(
      GenericDao<Loan,Loan> repository,
      GenericDao<Title,String> titleRepository,
      GenericDao<UserLibrary,String> userLibraryRepository
  ) {
    this.repo = repository;
    this.titleRepo = titleRepository;
    this.userRepo = userLibraryRepository;
  }

  @Override
  public Loan addLoan(Loan newLoan) throws Exception {
    if (newLoan == null)
      throw new Exception("No request");

    try {
      UserLibrary u = userRepo.getById(newLoan.getUserTaxCode());
    } catch (Exception e) {
      throw new Exception("No Borrower found for id " + newLoan.getUserTaxCode());
    }

    Title exists = titleRepo.getById(newLoan.getTitleId());
    if (exists == null)
      throw new Exception("No Title found for id " + newLoan.getTitleId());


    repo.add(newLoan);
    return newLoan;
  }

  @Override
  public Loan getLoan(Loan id) {
    return repo.getById(id);
  }

  @Override
  public void deleteLoan(Loan id) throws SQLException, ClassNotFoundException {
   try {
     this.repo.delete(id);
   } catch (DaoException e) {
     e.printStackTrace();
   }
  }
}
