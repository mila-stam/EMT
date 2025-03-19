package mk.ukim.finki.emt.lab1gra.service.impl;

import mk.ukim.finki.emt.lab1gra.model.Book;
import mk.ukim.finki.emt.lab1gra.model.Category;
import mk.ukim.finki.emt.lab1gra.model.dto.BookDto;
import mk.ukim.finki.emt.lab1gra.repository.BookRepository;
import mk.ukim.finki.emt.lab1gra.service.AuthorService;
import mk.ukim.finki.emt.lab1gra.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        return bookRepository.findById(id).map(existingBook -> {
            if(bookDto.getName() != null){
                existingBook.setName(bookDto.getName());
            }
//            if(bookDto.getCategory() != null){
//                existingBook.setCategory(Category.valueOf(bookDto.getCategory()));
//            }
            if(bookDto.getAvailableCopies() != null){
                existingBook.setAvailableCopies(bookDto.getAvailableCopies());
            }
//            if(bookDto.getAuthorId() != null && authorService.findById(bookDto.getAuthorId()).isPresent()){
//                existingBook.setAuthor(authorService.findById(bookDto.getAuthorId()).get());
//            }
            return bookRepository.save(existingBook);
        });
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        if(bookDto.getAuthorId() != null &&
                authorService.findById(bookDto.getAuthorId()).isPresent()) {
            return Optional.of(
                    bookRepository.save(new Book(
                            bookDto.getName(),
                            Category.valueOf(bookDto.getCategory().toUpperCase()),
                            authorService.findById(bookDto.getAuthorId()).get(),
                            bookDto.getAvailableCopies()))
            );
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markAsRented(Long id) {
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        if(book.getAvailableCopies() > 0){
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
    }
}
