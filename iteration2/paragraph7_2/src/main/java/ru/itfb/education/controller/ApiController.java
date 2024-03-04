package ru.itfb.education.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itfb.education.domain.Book;
import ru.itfb.education.service.BookService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ApiController {
    private final BookService service;

    @GetMapping("/")
    public Iterable<Book> getAllBook() {
        return service.getAllBook();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(name = "id") Long id) {
        return service.getBookById(id).map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
