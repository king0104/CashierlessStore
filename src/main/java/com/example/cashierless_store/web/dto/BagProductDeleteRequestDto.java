package com.example.cashierless_store.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BagProductDeleteRequestDto {
    private Long bagId;
    private Long productId;

    @Builder
    public BagProductDeleteRequestDto(Long bagId, Long productId) {
        this.bagId = bagId;
        this.productId = productId;
    }
}
