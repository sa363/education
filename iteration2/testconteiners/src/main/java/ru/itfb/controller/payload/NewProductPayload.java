package ru.itfb.controller.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductPayload(
    @NotNull
    @Size(min = 3, max = 150)
    @NotBlank
    String title,
    @Size(max = 2500)
    String details) {
    }

