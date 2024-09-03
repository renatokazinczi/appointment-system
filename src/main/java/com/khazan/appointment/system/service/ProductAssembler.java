package com.khazan.appointment.system.service;

import com.khazan.appointment.system.dto.CreateProductDto;
import com.khazan.appointment.system.dto.PagebleDto;
import com.khazan.appointment.system.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAssembler {

/*    public static ProductDto toDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getQuantity(),
            product.getArchived()
        );
    }

    public Product toEntity(CreateProductDto productDto) {
        return Product.builder()
            .name(productDto.getName())
            .price(productDto.getPrice())
            .quantity(productDto.getQuantity() == null ? 0 : productDto.getQuantity())
            .build();
    }

    public PagebleDto<List<ProductDto>> toPagableDto(Page<Product> productsPage, List<ProductDto> products) {
        Integer nextPageNumber = productsPage.hasNext() ? productsPage.nextPageable().getPageNumber() : null;
        Integer previousPageNumber = productsPage.hasPrevious() ? productsPage.previousPageable().getPageNumber() : null;

        return new PagebleDto<>(
            productsPage.getNumber(),
            productsPage.getTotalElements(),
            productsPage.getTotalPages(),
            nextPageNumber,
            previousPageNumber,
            products
        );
    }*/
}
