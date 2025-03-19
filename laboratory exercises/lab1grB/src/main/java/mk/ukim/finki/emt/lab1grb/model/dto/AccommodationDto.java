package mk.ukim.finki.emt.lab1grb.model.dto;

import lombok.Data;

@Data
public class AccommodationDto {
    private String name;
    private String category;
    private Long hostId;
    private Integer numRooms;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Long getHostId() {
        return hostId;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }
}
