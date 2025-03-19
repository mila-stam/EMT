package mk.ukim.finki.emt.lab1gra.service;

import mk.ukim.finki.emt.lab1gra.model.Book;
import mk.ukim.finki.emt.lab1gra.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, BookDto bookDto);

    Optional<Book> save(BookDto bookDto);

    void deleteById(Long id);

    void markAsRented(Long id);
}
