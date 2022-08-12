package com.example.cashierless_store.web.dto;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.service.ProductService;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private int price;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
