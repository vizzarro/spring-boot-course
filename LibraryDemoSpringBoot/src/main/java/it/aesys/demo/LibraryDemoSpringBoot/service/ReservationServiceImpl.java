package it.aesys.demo.LibraryDemoSpringBoot.service;

import it.aesys.demo.LibraryDemoSpringBoot.models.Borrower;
import it.aesys.demo.LibraryDemoSpringBoot.models.Title;
import org.library.demo.models.Reservation;
import it.aesys.demo.LibraryDemoSpringBoot.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
  private GenericRepository<Reservation> repo;
  private GenericRepository<Title> titleRepo;
  private GenericRepository<Borrower> borrowerRepo;

  @Autowired
  public ReservationServiceImpl(
      GenericRepository<Reservation> repository,
      GenericRepository<Title> titleRepository,
      GenericRepository<Borrower> borrowerRepository
  ) {
    this.repo = repository;
    this.titleRepo = titleRepository;
    this.borrowerRepo = borrowerRepository;
  }

  @Override
  public void addReservation(Reservation newReservation) throws Exception {
    if (newReservation == null)
      throw new Exception("No request");

    try {
      Borrower b = borrowerRepo.getById(newReservation.getBorrowerId());
    } catch (Exception e) {
      throw new Exception("No Borrower found for id " + newReservation.getBorrowerId());
    }

    Title exists = titleRepo.getById(newReservation.getTitleId());
    if (exists == null)
      throw new Exception("No Title found for id " + newReservation.getTitleId());

    repo.add(newReservation);
  }

  @Override
  public Reservation getReservation(int id) {
    return repo.getById(id);
  }

  @Override
  public void deleteReservation(int id) {
    this.repo.delete(id);
  }
}
