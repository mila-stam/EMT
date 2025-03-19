package mk.ukim.finki.emt.lab1grb.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.lab1grb.model.Accommodation;
import mk.ukim.finki.emt.lab1grb.model.Category;
import mk.ukim.finki.emt.lab1grb.model.Country;
import mk.ukim.finki.emt.lab1grb.model.Host;
import mk.ukim.finki.emt.lab1grb.repository.AccommodationRepository;
import mk.ukim.finki.emt.lab1grb.repository.CountryRepository;
import mk.ukim.finki.emt.lab1grb.repository.HostRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(AccommodationRepository accommodationRepository, HostRepository hostRepository, CountryRepository countryRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }
    @PostConstruct
    public void init(){
        Country USA =  countryRepository.save(new Country("United States", "North America"));


        Host host1 = hostRepository.save(new Host("Rebecca", "Yarros", USA));
        Host host2 = hostRepository.save(new Host("Kristin", "Hannah", USA));
        Host host3 = hostRepository.save(new Host("Rebecca", "Yarros", USA));


        Accommodation acc1 = accommodationRepository.save(new Accommodation("BlueSky", Category.APARTMENT, host1, 3));
        Accommodation acc2 = accommodationRepository.save(new Accommodation("Foxx", Category.HOUSE, host2, 7));
        Accommodation acc3 = accommodationRepository.save(new Accommodation("Hilton", Category.HOTEL, host3, 150));

        accommodationRepository.saveAll(List.of(acc1, acc2, acc3));
    }
}
