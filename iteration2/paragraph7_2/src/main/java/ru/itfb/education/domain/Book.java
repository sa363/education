package ru.itfb.education.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Version
    @Column(name = "ver", nullable = false)
    private Integer version;

    public Book(String name) {
        this.name = name;
    }
}
