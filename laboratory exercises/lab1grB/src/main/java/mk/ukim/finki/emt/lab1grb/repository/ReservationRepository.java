package mk.ukim.finki.emt.lab1grb.repository;

import mk.ukim.finki.emt.lab1grb.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
