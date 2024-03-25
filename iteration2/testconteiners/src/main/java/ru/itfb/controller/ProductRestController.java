package ru.itfb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itfb.controller.payload.UpdateProductPayload;
import ru.itfb.entity.Product;
import ru.itfb.service.impl.ProductServiceImpl;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/products/{id:^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$}")
//@RequestMapping("api/products/{id}")
public class ProductRestController {

    private final ProductServiceImpl productService;

    @ModelAttribute("product")
    public Product getProduct(@PathVariable("id") UUID id) {
        return this.productService.findProduct(id)
                .orElseThrow(() -> new NoSuchElementException());
    }

    @GetMapping
    public Product findProduct(@ModelAttribute("product") Product product) {
        return product;
    }

    @PatchMapping
    public ResponseEntity<?> updateProduct(@PathVariable("id") UUID id,
                                           @Valid @RequestBody UpdateProductPayload payload,
                                           BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            this.productService.updateProduct(id, payload.title(), payload.details());
            return ResponseEntity.noContent()
                    .build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") UUID id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent()
                .build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(NoSuchElementException exception
                                                                      ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                                exception.getMessage()));
    }

}
