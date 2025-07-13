package com.eduardo.avaliacao_calezani.dtos;

import com.eduardo.avaliacao_calezani.entities.Assessment;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AssessmentDTO(
        Long id,
        @NotBlank(message = "Campo obrigatório") String stationName,
        @NotBlank(message = "Campo obrigatório") String driverName,
        @Min(value = 0, message = "A nota deve ser de 0 a 10") @Max(value = 10, message = "A nota deve ser de 0 a 10") int score,
        @NotBlank(message = "Campo obrigatório") String comment
) {

    public AssessmentDTO(Assessment assessment) {
        this(
                assessment.getId(),
                assessment.getStation().getName(),
                assessment.getDriver().getName(),
                assessment.getScore(),
                assessment.getComment());
    }
}
