package mk.ukim.finki.emt.lab1gra.service;

import mk.ukim.finki.emt.lab1gra.model.Author;
import mk.ukim.finki.emt.lab1gra.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(long id);

    Optional<Author> update(Long id, AuthorDto authorDto);

    Optional<Author> save(AuthorDto authorDto);

    void deleteById(Author author);
}
