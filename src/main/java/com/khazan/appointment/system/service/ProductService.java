package com.khazan.appointment.system.service;

import com.khazan.appointment.system.dto.CreateProductDto;
import com.khazan.appointment.system.dto.PagebleDto;
import com.khazan.appointment.system.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

/*    private final ProductRepository productRepository;
    private final ProductAssembler productAssembler;

    public PagebleDto<List<ProductDto>> getAllProductsFiltered(String name, Integer size, Integer page) {
        Pageable paging = PageRequest.of(page, size);

        Page<Product> productsPage = getProducts(name, paging);
        List<ProductDto> products = productsPage.getContent()
            .stream()
            .map(ProductAssembler::toDto)
            .toList();

        return productAssembler.toPagableDto(productsPage, products);
    }

    public Long addProduct(CreateProductDto productDto) {
        return productRepository.save(productAssembler.toEntity(productDto)).getId();
    }

    private Page<Product> getProducts(String name, Pageable paging) {
        if (name == null || name.isBlank()) {
            return productRepository.findAll(paging);
        } else {
            return productRepository.findByNameContaining(name, paging);
        }
    }*/
}
