package ru.itfb.education.component;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itfb.education.domain.Book;
import ru.itfb.education.repository.BookRepository;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DBOperation implements CommandLineRunner {

    private final BookRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.saveAll(Arrays.asList(
                new Book("book1"),
                new Book("book2"),
                new Book("book3"),
                new Book("book4"),
                new Book("book5"),
                new Book("book6"),
                new Book("book7"),
                new Book("book8")
        ));
    }
}
