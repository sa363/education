package ru.itfb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itfb.entity.Product;
import ru.itfb.entity.Product.ProductBuilder;
import ru.itfb.repository.ProductRepository;
import ru.itfb.service.ProductService;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public Iterable<Product> findAllProducts(String filter) {
        if (filter != null && !filter.isBlank()) {
            return productRepository.findAllByTitleLikeIgnoreCase("%"+filter+"%");
        }
        return null;
    }

    @Override
    @Transactional
    public Product createProduct(String title, String details) {
        return this.productRepository.save(
                new ProductBuilder()
                        .setTitle(title)
                        .setDetails(details)
                        .build()
        );
    }

    @Override
    public Optional<Product> findProduct(UUID id) {
        return this.productRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateProduct(UUID id, String title, String details) {
        this.productRepository.findById(id)
                .ifPresentOrElse(product -> {
                    product.setTitle(title);
                    product.setDetails(details);
                }, () -> {
                    throw new NoSuchElementException();
                        }
                );
    }

    @Override
    public void deleteProduct(UUID id) {
        this.productRepository.deleteById(id);
    }
}
