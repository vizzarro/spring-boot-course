package org.library.demo.repository;

import org.library.demo.models.Loan;
import org.library.demo.models.Storage;
import org.library.demo.models.Title;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanRepository implements GenericRepository<Loan> {
  private List<Loan> mockedTable;
  @Autowired
  private Storage storage;
  @Autowired
  private LoanDao loanDao;

  public LoanRepository() {
    this.mockedTable = new ArrayList<>();
  }

  @Override
  public Loan getById(int id) {
    try {
      return this.mockedTable.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

    @Override
  public void add(Loan entity) {;
    this.mockedTable.add(entity);
  }

  @Override
  public void delete(int id) {
      this.mockedTable.remove(id);
    }

  @Override
  public Loan update(int id, Loan updated) {
      return getById(id);
    }

  public Loan getByTitleId(String titleId) {
    try {
      return this.loanDao.get(titleId);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  }

