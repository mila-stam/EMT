package mk.ukim.finki.emt.lab1grb.service.impl;

import mk.ukim.finki.emt.lab1grb.model.Host;
import mk.ukim.finki.emt.lab1grb.model.dto.HostDto;
import mk.ukim.finki.emt.lab1grb.repository.HostRepository;
import mk.ukim.finki.emt.lab1grb.service.CountryService;
import mk.ukim.finki.emt.lab1grb.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> update(Long id, HostDto hostDto) {
        return hostRepository.findById(id).map(existingHost -> {
            if (hostDto.getCountryId() != null) {
                existingHost.setName(hostDto.getName());
            }
            if(hostDto.getSurname() != null) {
                existingHost.setSurname(hostDto.getSurname());
            }
            if(hostDto.getCountryId() != null && countryService.findById(hostDto.getCountryId()).isPresent()) {
                existingHost.setCountry(countryService.findById(hostDto.getCountryId()).get());
            }
            return hostRepository.save(existingHost);
        });
    }

    @Override
    public Optional<Host> save(HostDto hostDto) {
        if(hostDto.getCountryId() != null && countryService.findById(hostDto.getCountryId()).isPresent()) {
            return Optional.of(
                    hostRepository.save(new Host(
                            hostDto.getName(),
                            hostDto.getSurname(),
                            countryService.findById(hostDto.getCountryId()).get()
                    ))
            );
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
