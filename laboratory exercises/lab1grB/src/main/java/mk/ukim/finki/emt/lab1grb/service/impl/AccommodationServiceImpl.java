package mk.ukim.finki.emt.lab1grb.service.impl;

import mk.ukim.finki.emt.lab1grb.model.Accommodation;
import mk.ukim.finki.emt.lab1grb.model.Category;
import mk.ukim.finki.emt.lab1grb.model.Host;
import mk.ukim.finki.emt.lab1grb.model.dto.AccommodationDto;
import mk.ukim.finki.emt.lab1grb.repository.AccommodationRepository;
import mk.ukim.finki.emt.lab1grb.service.AccommodationService;
import mk.ukim.finki.emt.lab1grb.service.HostService;
import mk.ukim.finki.emt.lab1grb.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;
//    private final ReservationService reservationService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
//        this.reservationService = reservationService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> update(Long id, AccommodationDto accommodationDto) {
        return accommodationRepository.findById(id).map(existingAcc -> {
            if(accommodationDto.getName() != null) {
                existingAcc.setName(accommodationDto.getName());
            }
            if(accommodationDto.getCategory() != null) {
                existingAcc.setCategory(Category.valueOf(accommodationDto.getCategory()));
            }
            if (accommodationDto.getNumRooms() != null) {
                existingAcc.setNumRooms(accommodationDto.getNumRooms());
            }
            if(accommodationDto.getHostId() != null && hostService.findById(accommodationDto.getHostId()).isPresent()) {
                existingAcc.setHost(hostService.findById(accommodationDto.getHostId()).get());
            }
//            if(accommodationDto.getReservationId() != null && reservationService.findById(accommodationDto.getReservationId()).isPresent()) {
//                existingAcc.setReservation(reservationService.findById(accommodationDto.getReservationId()).get());
//            }
            return accommodationRepository.save(existingAcc);
        });

    }

    @Override
    public Optional<Accommodation> save(AccommodationDto accommodationDto) {
        if(accommodationDto.getHostId() != null && hostService.findById(accommodationDto.getHostId()).isPresent()) {
            return Optional.of(
                    accommodationRepository.save(new Accommodation(
                            accommodationDto.getName(),
                            Category.valueOf(accommodationDto.getCategory()),
                            hostService.findById(accommodationDto.getHostId()).get(),
                            accommodationDto.getNumRooms()
//                            reservationService.findById(accommodationDto.getReservationId()).get()
                    ))
            );
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

//    @Override
//    public void markAsRented(Long id) {
//        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
//        if(accommodation.getNumRooms() > 0){
//            accommodation.setNumRooms(accommodation.getNumRooms() - 1);
//            accommodationRepository.save(accommodation);
//        }
//    }
}
