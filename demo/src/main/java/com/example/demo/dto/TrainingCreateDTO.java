package com.example.demo.dto;

import com.example.demo.model.TrainingType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record TrainingCreateDTO(
        @NotBlank(message = "Title is required") String title,

        @NotBlank(message = "Description is required") String description,

        @NotNull(message = "Type is required") TrainingType type,

        @NotNull(message = "Date is required")
        @FutureOrPresent(message = "Date must be in the present or future") LocalDate date,

        @JsonProperty("duration")
        @Min(value = 1, message = "Duration must be at least 1 hour") int durationInHours
) {
    // No need for explicit getters or setters as records provide them automatically.
}