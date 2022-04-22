package org.library.demo.service;

import org.library.demo.models.Borrower;
import org.library.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BorrowerServiceImpl implements BorrowerService {
  private GenericRepository<Borrower> repo;

  public BorrowerServiceImpl(GenericRepository<Borrower> borrowerRepository) {
    this.repo = borrowerRepository;
  }

  @Override
  public void addBorrower(Borrower newBorrower) throws Exception {
    if (!StringUtils.hasLength(newBorrower.getFirstName()))
      throw new Exception("New Borrower must have a valid name!");

    if (!StringUtils.hasLength(newBorrower.getLastName()))
      throw new Exception("New Borrower must have a valid surname!");

    if (!StringUtils.hasLength(newBorrower.getTaxCode()))
      throw new Exception("New Borrower must have a valid tax code!");

    repo.add(newBorrower);
  }

  @Override
  public Borrower getBorrower(int id) {
    return repo.getById(id);
  }
}
