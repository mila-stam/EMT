package mk.ukim.finki.emt.lab1grb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

//pocheten kraen gosti cena
@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer guests;
    private Integer price;
    @ManyToOne
    private Accommodation accommodation;

    public Reservation() {
    }

    public Reservation(LocalDateTime startDate, LocalDateTime endDate, Integer guests, Integer price, Accommodation accommodation) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.guests = guests;
        this.price = price;
        this.accommodation = accommodation;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getGuests() {
        return guests;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
