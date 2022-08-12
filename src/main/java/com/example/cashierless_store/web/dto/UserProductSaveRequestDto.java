package com.example.cashierless_store.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserProductSaveRequestDto {
    private Long userId;
    private Long productId;

    @Builder
    public UserProductSaveRequestDto(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

}