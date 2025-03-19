package mk.ukim.finki.emt.lab1grb.service;

import mk.ukim.finki.emt.lab1grb.model.Host;
import mk.ukim.finki.emt.lab1grb.model.dto.HostDto;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Optional<Host> update(Long id, HostDto hostDto);
    Optional<Host> save(HostDto hostDto);
    void deleteById(Long id);
}
