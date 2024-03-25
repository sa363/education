package ru.itfb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itfb.entity.Product;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
    Iterable<Product> findAllByTitleLikeIgnoreCase(String filter);
}