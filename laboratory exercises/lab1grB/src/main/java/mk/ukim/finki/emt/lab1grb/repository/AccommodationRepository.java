package mk.ukim.finki.emt.lab1grb.repository;

import mk.ukim.finki.emt.lab1grb.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
