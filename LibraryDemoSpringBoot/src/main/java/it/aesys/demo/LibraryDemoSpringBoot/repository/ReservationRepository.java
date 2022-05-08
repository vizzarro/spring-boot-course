package it.aesys.demo.LibraryDemoSpringBoot.repository;

import java.util.ArrayList;
import java.util.List;
import org.library.demo.models.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository implements GenericRepository<Reservation> {
  private List<Reservation> mockedTable;

  public ReservationRepository() {
    this.mockedTable = new ArrayList<>();
  }

  @Override
  public Reservation getById(int id) {
    return this.mockedTable.get(id - 1);
  }

  @Override
  public void add(Reservation entity) {
    this.mockedTable.add(entity);
  }

  @Override
  public void delete(int id) {
    this.mockedTable.remove(id - 1);
  }

  @Override
  public Reservation update(int id, Reservation updated) {
    Reservation found = getById(id);

    if (found != null)
      this.mockedTable.set(id - 1, updated);

    return getById(id);
  }
}
