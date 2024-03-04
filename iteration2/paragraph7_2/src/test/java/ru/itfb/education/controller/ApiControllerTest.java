package ru.itfb.education.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.itfb.education.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllBook() {
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/api/", String.class)).contains("book1");

    }

    @Test
    void getBookById() {
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/api/1", String.class)).contains("book1");
    }
}