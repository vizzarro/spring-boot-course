package it.aesys.demo.LibraryDemoSpringBoot.repository;

import java.util.ArrayList;
import java.util.List;

import it.aesys.demo.LibraryDemoSpringBoot.models.Borrower;
import org.springframework.stereotype.Repository;


@Repository
public class BorrowerRepository implements GenericRepository<Borrower> {
  private List<Borrower> mockedTable;

  public BorrowerRepository() {
    this.mockedTable = new ArrayList<>();
  }

  @Override
  public Borrower getById(int id) {
    return this.mockedTable.get(id - 1);
  }

  @Override
  public void add(Borrower entity) {
    this.mockedTable.add(entity);
  }

  @Override
  public void delete(int id) {
    this.mockedTable.remove(id - 1);
  }

  @Override
  public Borrower update(int id, Borrower updated) {
    Borrower found = getById(id);

    if (found != null)
      this.mockedTable.set(id - 1, updated);

    return getById(id);
  }
}
