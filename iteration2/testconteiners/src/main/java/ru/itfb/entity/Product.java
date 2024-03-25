package ru.itfb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "sandbox", name = "t_product")
public class Product implements Model<UUID>{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "c_depricated")
    private Boolean depricated = false;

    @Column(name = "c_title")
    @NotNull
    @Size(min = 3, max = 150)
    private String title;

    @Column(name = "c_detail")
    @Size(max = 2500)
    private String details;

    public Product(ProductBuilder productBuilder) {
        this.title = productBuilder.title;
        this.details = productBuilder.details;
    }
    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public Boolean isDepricated() {
        return depricated;
    }

    public static class ProductBuilder {
        private String details;
        private String title;

        public ProductBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder setDetails(String details) {
            this.details = details;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
