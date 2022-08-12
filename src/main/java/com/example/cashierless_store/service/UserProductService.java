package com.example.cashierless_store.service;

import com.example.cashierless_store.domain.product.Product;
import com.example.cashierless_store.domain.product.ProductRepository;
import com.example.cashierless_store.domain.user.User;
import com.example.cashierless_store.domain.user.UserRepository;
import com.example.cashierless_store.domain.userProduct.UserProduct;
import com.example.cashierless_store.domain.userProduct.UserProductRepository;
import com.example.cashierless_store.web.dto.UserProductSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final UserProductRepository userProductRepository;

    @Transactional
    public Long save(UserProductSaveRequestDto requestDto) {
        Long userId = requestDto.getUserId();
        Long productId = requestDto.getProductId();

        User user = userRepository.findById(userId).get();
        Product product = productRepository.findById(productId).get();
        return userProductRepository.save(UserProduct.builder()
                .user(user)
                .product(product)
                .build()).getId();

    }

    @Transactional
    public void deleteAllByUserId(Long userId) {
        // 1. 쿼리문으로 해당 up 리턴받아서
        // 2. delete로 해당 up 삭제
        List<UserProduct> userProductList = userProductRepository.findByUserId(userId);
        if (userProductList != null && !userProductList.isEmpty()) {
            for (UserProduct userProduct : userProductList) {
                userProductRepository.delete(userProduct);
            }
        }
    }



}
