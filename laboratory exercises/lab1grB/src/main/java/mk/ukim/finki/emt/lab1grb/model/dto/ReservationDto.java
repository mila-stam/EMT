package mk.ukim.finki.emt.lab1grb.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer guests;
    private Integer price;
    private Long accommodationId;

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

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }
}
