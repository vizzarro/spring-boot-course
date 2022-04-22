package org.library.demo.service;

import org.library.demo.models.UserLibrary;
import org.library.demo.models.Reservation;
import org.library.demo.models.Title;
import org.library.demo.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
  private GenericRepository<Reservation> repo;
  private GenericRepository<Title> titleRepo;
  private GenericRepository<UserLibrary> borrowerRepo;

  @Autowired
  public ReservationServiceImpl(
      GenericRepository<Reservation> repository,
      GenericRepository<Title> titleRepository,
      GenericRepository<UserLibrary> borrowerRepository
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
      UserLibrary b = borrowerRepo.getById(newReservation.getBorrowerId());
    } catch (Exception e) {
      throw new Exception("No UserLibrary found for id " + newReservation.getBorrowerId());
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
