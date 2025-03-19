package mk.ukim.finki.emt.lab1gra.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.lab1gra.model.Author;
import mk.ukim.finki.emt.lab1gra.model.Book;
import mk.ukim.finki.emt.lab1gra.model.Category;
import mk.ukim.finki.emt.lab1gra.model.Country;
import mk.ukim.finki.emt.lab1gra.repository.AuthorRepository;
import mk.ukim.finki.emt.lab1gra.repository.BookRepository;
import mk.ukim.finki.emt.lab1gra.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init() {
        Country USD = countryRepository.save(new Country("United States of America", "North America"));

        Author author1 = authorRepository.save(new Author("Suzanne", "Collins", USD));
        Author author2 = authorRepository.save(new Author("Louisa", "Alcott", USD));
        Author author3 = authorRepository.save(new Author("Harper", "Lee", USD));


        Book book1 = bookRepository.save(new Book("Hunger Games", Category.FANTASY, author1, 455));
        Book book2 = bookRepository.save(new Book("Little Women", Category.DRAMA, author2, 1367));
        Book book3 = bookRepository.save(new Book("To Kill a Mockingbird", Category.NOVEL, author1, 872));

        bookRepository.saveAll(List.of(book1, book2, book3));
    }
}
