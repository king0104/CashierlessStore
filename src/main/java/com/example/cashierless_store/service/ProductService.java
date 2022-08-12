package com.example.cashierless_store.service;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    // 물건 이름
    // 물건 수량
    // 총 가격 구하기
    public List<Product> getProductListByBagId(Long bagId) {
        List<Product> productList = productRepository.getProductListByBagId(bagId);

        return productList;
    }
}
