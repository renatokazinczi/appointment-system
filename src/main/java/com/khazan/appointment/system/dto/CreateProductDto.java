package com.khazan.appointment.system.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProductDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Min(value = 1)
    private BigDecimal price;

    private Integer quantity;
}
