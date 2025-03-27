package mk.ukim.finki.emt.lab1grb.service;

import mk.ukim.finki.emt.lab1grb.model.Accommodation;
import mk.ukim.finki.emt.lab1grb.model.dto.AccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> update(Long id, AccommodationDto accommodationDto);
    Optional<Accommodation> save(AccommodationDto accommodationDto);
    void deleteById(Long id);
    //void markAsRented(Long id);
}
