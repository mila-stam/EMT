package mk.ukim.finki.emt.lab1grb.service.impl;

import mk.ukim.finki.emt.lab1grb.model.Reservation;
import mk.ukim.finki.emt.lab1grb.model.dto.ReservationDto;
import mk.ukim.finki.emt.lab1grb.repository.ReservationRepository;
import mk.ukim.finki.emt.lab1grb.service.AccommodationService;
import mk.ukim.finki.emt.lab1grb.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final AccommodationService accommodationService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, AccommodationService accommodationService) {
        this.reservationRepository = reservationRepository;
        this.accommodationService = accommodationService;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Optional<Reservation> update(Long id, ReservationDto reservationDto) {
        return reservationRepository.findById(id).map(existingReservation -> {
            if (reservationDto.getStartDate() != null){
                existingReservation.setStartDate(reservationDto.getStartDate());
            }
            if (reservationDto.getEndDate() != null){
                existingReservation.setEndDate(reservationDto.getEndDate());
            }
            if(reservationDto.getGuests() != null) {
                existingReservation.setGuests(reservationDto.getGuests());
            }
            if(reservationDto.getPrice() != null) {
                existingReservation.setPrice(reservationDto.getPrice());
            }
            if(reservationDto.getAccommodationId() != null && accommodationService.findById(reservationDto.getAccommodationId()).isPresent()) {
                existingReservation.setAccommodation(accommodationService.findById(reservationDto.getAccommodationId()).get());
            }
            return reservationRepository.save(existingReservation);
        });
    }

    @Override
    public Optional<Reservation> save(ReservationDto reservationDto) {
        if(reservationDto.getAccommodationId() != null && accommodationService.findById(reservationDto.getAccommodationId()).isPresent()){
            return Optional.of(
                    reservationRepository.save(new Reservation(
                            reservationDto.getStartDate(),
                            reservationDto.getEndDate(),
                            reservationDto.getGuests(),
                            reservationDto.getPrice(),
                            accommodationService.findById(reservationDto.getAccommodationId()).get()
                            )
                    )
            );
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
