package ru.itfb.education.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itfb.education.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
