package mk.ukim.finki.emt.lab1grb.service;

import mk.ukim.finki.emt.lab1grb.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> update(Long id, Country country);
    Optional<Country> save(Country country);
    void deleteById(Long id);
}
