package com.example.cashierless_store.service;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.domain.product.ProductRepository;
import com.example.cashierless_store.domain.bag.Bag;
import com.example.cashierless_store.domain.bag.BagRepository;
import com.example.cashierless_store.domain.bagProduct.BagProduct;
import com.example.cashierless_store.domain.bagProduct.BagProductRepository;
import com.example.cashierless_store.web.dto.BagProductDeleteRequestDto;
import com.example.cashierless_store.web.dto.BagProductSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BagProductService {

    private final BagRepository bagRepository;
    private final ProductRepository productRepository;
    private final BagProductRepository bagProductRepository;

    @Transactional
    public Long save(BagProductSaveRequestDto requestDto) {
        Long bagId = requestDto.getBagId();
        Long productId = requestDto.getProductId();

        Bag bag = bagRepository.findById(bagId).get();
        Product product = productRepository.findById(productId).get();
        return bagProductRepository.save(BagProduct.builder()
                .bag(bag)
                .product(product)
                .build()).getId();
    }

    @Transactional
    public void deleteAllByBagId(Long bagId) {
        // 1. 쿼리문으로 해당 up 리턴받아서
        // 2. delete로 해당 up 삭제
        List<BagProduct> bagProductList = bagProductRepository.findByBagId(bagId);
        if (bagProductList != null && !bagProductList.isEmpty()) {
            for (BagProduct bagProduct : bagProductList) {
                bagProductRepository.delete(bagProduct);
            }
        }
    }

    @Transactional
    public void delete(BagProductDeleteRequestDto requestDto) {
        Long bagId = requestDto.getBagId();
        Long productId = requestDto.getProductId();

        Long newBagProductId = bagProductRepository.find(bagId, productId);
        bagProductRepository.deleteById(newBagProductId);

    }



}
