package com.khazan.appointment.system.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PagebleDto<T>(
    Integer currentPage,
    Long size,
    Integer pagesSize,
    Integer nextPage,
    Integer previousPage,
    T elements
) {
}
