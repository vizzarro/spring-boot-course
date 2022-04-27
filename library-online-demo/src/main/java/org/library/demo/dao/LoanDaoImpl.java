package org.library.demo.dao;

import org.library.demo.models.Loan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanDaoImpl extends BaseDaoImpl<Loan, Loan> implements LoanDao {

  @Override
  public Loan get(Loan id) {
    return null;
  }

  @Override
  public Loan create(Loan obj) {
    return null;
  }

  @Override
  public Loan update(Loan obj, Loan id) {
  return null;
  }

  @Override
  public void delete(Loan obj) {

  }
}

