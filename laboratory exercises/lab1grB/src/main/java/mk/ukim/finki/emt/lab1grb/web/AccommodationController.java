package mk.ukim.finki.emt.lab1grb.web;

import mk.ukim.finki.emt.lab1grb.model.Accommodation;
import mk.ukim.finki.emt.lab1grb.model.dto.AccommodationDto;
import mk.ukim.finki.emt.lab1grb.service.AccommodationService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    //findAll
    @GetMapping
    public List<Accommodation> findAll(){
        return accommodationService.findAll();
    }

    //findById
    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id){
        return accommodationService.findById(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    //save
    @PostMapping("/add")
    public ResponseEntity<Accommodation> save(@RequestBody AccommodationDto accommodationDto){
        return accommodationService.save(accommodationDto)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    //update
    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto){
        return accommodationService.update(id, accommodationDto)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Accommodation> delete(@PathVariable Long id){
        if(accommodationService.findById(id).isPresent()){
            accommodationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //rent
    @PatchMapping("/rent/{id}")
    public ResponseEntity<Accommodation> markAsRented(@PathVariable Long id){
        if(accommodationService.findById(id).isPresent()){
            accommodationService.markAsRented(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
