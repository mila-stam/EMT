package mk.ukim.finki.emt.lab1gra.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class BookDto {

    private String name;

    private String category;

    private Long authorId;

    private Integer availableCopies;

    private String description;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
