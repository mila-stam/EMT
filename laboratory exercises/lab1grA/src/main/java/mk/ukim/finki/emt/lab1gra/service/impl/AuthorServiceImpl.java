package mk.ukim.finki.emt.lab1gra.service.impl;

import mk.ukim.finki.emt.lab1gra.model.Author;
import mk.ukim.finki.emt.lab1gra.model.dto.AuthorDto;
import mk.ukim.finki.emt.lab1gra.repository.AuthorRepository;
import mk.ukim.finki.emt.lab1gra.service.AuthorService;
import mk.ukim.finki.emt.lab1gra.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, AuthorDto authorDto) {
        return authorRepository.findById(id).map(existingAuthor -> {
            if(authorDto.getName() != null) {
                existingAuthor.setName(authorDto.getName());
            }
            if(authorDto.getSurname() != null) {
                existingAuthor.setSurname(authorDto.getSurname());
            }
            if (authorDto.getCountryId() != null && countryService.findById(authorDto.getCountryId()).isPresent()) {
                existingAuthor.setCountry(countryService.findById(authorDto.getCountryId()).get());
            }
            return authorRepository.save(existingAuthor);
        });
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        if (authorDto.getCountryId() != null && countryService.findById(authorDto.getCountryId()).isPresent()) {
            return Optional.of(
                    authorRepository.save(new Author(
                            authorDto.getName(),
                            authorDto.getSurname(),
                            countryService.findById(authorDto.getCountryId()).get()))
            );
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Author author) {
        authorRepository.delete(author);
    }
}
