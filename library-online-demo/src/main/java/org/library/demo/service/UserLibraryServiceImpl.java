package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserLibraryServiceImpl implements UserLibraryService {
  private GenericRepository<UserLibrary> repo;

  public UserLibraryServiceImpl(GenericRepository<UserLibrary> userLibraryRepository) {
    this.repo = userLibraryRepository;
  }

  @Override
  public void addUserLibrary(UserLibrary newUserLibrary) throws Exception {
    if (!StringUtils.hasLength(newUserLibrary.getFirstName()))
      throw new Exception("New UserLibrary must have a valid name!");

    if (!StringUtils.hasLength(newUserLibrary.getLastName()))
      throw new Exception("New UserLibrary must have a valid surname!");

    if (!StringUtils.hasLength(newUserLibrary.getTaxCode()))
      throw new Exception("New UserLibrary must have a valid tax code!");

    repo.add(newUserLibrary);
  }

  @Override
  public UserLibrary getUserLibrary(int id) {
    return repo.getById(id);
  }
}
