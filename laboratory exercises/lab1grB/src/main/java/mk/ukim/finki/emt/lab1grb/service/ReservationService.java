package mk.ukim.finki.emt.lab1grb.service;

import mk.ukim.finki.emt.lab1grb.model.Accommodation;
import mk.ukim.finki.emt.lab1grb.model.Reservation;
import mk.ukim.finki.emt.lab1grb.model.dto.AccommodationDto;
import mk.ukim.finki.emt.lab1grb.model.dto.ReservationDto;
import mk.ukim.finki.emt.lab1grb.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> findAll();
    Optional<Reservation> findById(Long id);
    Optional<Reservation> update(Long id, ReservationDto reservationDto);
    Optional<Reservation> save(ReservationDto reservationDto);
    void deleteById(Long id);
}
