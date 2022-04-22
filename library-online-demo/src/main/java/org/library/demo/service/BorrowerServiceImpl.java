package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BorrowerServiceImpl implements BorrowerService {
  private GenericRepository<UserLibrary> repo;

  public BorrowerServiceImpl(GenericRepository<UserLibrary> borrowerRepository) {
    this.repo = borrowerRepository;
  }

  @Override
  public void addBorrower(UserLibrary newUserLibrary) throws Exception {
    if (!StringUtils.hasLength(newUserLibrary.getFirstName()))
      throw new Exception("New UserLibrary must have a valid name!");

    if (!StringUtils.hasLength(newUserLibrary.getLastName()))
      throw new Exception("New UserLibrary must have a valid surname!");

    if (!StringUtils.hasLength(newUserLibrary.getTaxCode()))
      throw new Exception("New UserLibrary must have a valid tax code!");

    repo.add(newUserLibrary);
  }

  @Override
  public UserLibrary getBorrower(int id) {
    return repo.getById(id);
  }
}
