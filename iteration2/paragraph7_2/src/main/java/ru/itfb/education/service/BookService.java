package ru.itfb.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itfb.education.domain.Book;
import ru.itfb.education.repository.BookRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;


    public Iterable<Book> getAllBook() {
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }
}
