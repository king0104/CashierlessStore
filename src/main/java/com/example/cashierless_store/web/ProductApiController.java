package com.example.cashierless_store.web;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.service.ProductService;
import com.example.cashierless_store.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    // 유저가 현재 장바구니에 담은 물건 목록 보여주기
    @GetMapping("api/v1/product/{bagId}")
    public List<ProductResponseDto> getProductListByBagId(@PathVariable Long bagId) {
        List<Product> productList = productService.getProductListByBagId(bagId);

        // entity -> dto 변환
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for (Product product : productList) {
            productResponseDtoList.add(new ProductResponseDto(product));
        }

        // 물건 정보인 dto들을 담은 리스트를 반환
        return productResponseDtoList;
    }

}
