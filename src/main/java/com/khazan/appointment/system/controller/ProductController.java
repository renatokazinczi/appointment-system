package com.khazan.appointment.system.controller;

import com.khazan.appointment.system.service.ProductService;
import com.khazan.appointment.system.dto.CreateProductDto;
import com.khazan.appointment.system.dto.PagebleDto;
import com.khazan.appointment.system.dto.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

/*    private final ProductService productService;

    @GetMapping
    public ResponseEntity<PagebleDto<List<ProductDto>>> getAllProductsFiltered(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "3") Integer size
    ) {
        return ResponseEntity.ok(productService.getAllProductsFiltered(name, size, page));
    }

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody @Valid CreateProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }*/
}
