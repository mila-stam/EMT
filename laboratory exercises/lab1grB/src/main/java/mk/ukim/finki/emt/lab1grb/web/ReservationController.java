package mk.ukim.finki.emt.lab1grb.web;

import mk.ukim.finki.emt.lab1grb.model.Accommodation;
import mk.ukim.finki.emt.lab1grb.model.Reservation;
import mk.ukim.finki.emt.lab1grb.model.dto.AccommodationDto;
import mk.ukim.finki.emt.lab1grb.model.dto.ReservationDto;
import mk.ukim.finki.emt.lab1grb.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    //findAll
    @GetMapping
    public List<Reservation> findAll(){
        return reservationService.findAll();
    }

    //findById
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Long id){
        return reservationService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    //save
    @PostMapping("/add")
    public ResponseEntity<Reservation> save(@RequestBody ReservationDto reservationDto){
        return reservationService.save(reservationDto)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    //update
    @PutMapping("/edit/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody ReservationDto reservationDto){
        return reservationService.update(id, reservationDto)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Reservation> delete(@PathVariable Long id){
        if(reservationService.findById(id).isPresent()){
            reservationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
