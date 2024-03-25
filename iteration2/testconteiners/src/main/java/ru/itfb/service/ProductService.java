package ru.itfb.service;

import ru.itfb.entity.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Iterable<Product> findAllProducts(String filter);
    Product createProduct(String title, String details);
    Optional<Product> findProduct(UUID id);

    void updateProduct(UUID id, String title, String details);

    void deleteProduct(UUID id);

}
