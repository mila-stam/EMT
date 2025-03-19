package mk.ukim.finki.emt.lab1grb.model.dto;

import lombok.Data;

@Data
public class HostDto {
    private String name;
    private String surname;
    private Long countryId;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
