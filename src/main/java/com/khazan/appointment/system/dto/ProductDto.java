package com.khazan.appointment.system.dto;

import java.math.BigDecimal;

public record ProductDto(
    Long id,
    String name,
    BigDecimal price,
    Integer quantity,
    Boolean archived
) {
}
