package mk.ukim.finki.emt.lab1gra.repository;

import mk.ukim.finki.emt.lab1gra.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCaseAndAuthor_NameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(
            String name, String authorName, String description);
}
