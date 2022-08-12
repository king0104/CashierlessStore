package com.example.cashierless_store.web;

import com.example.cashierless_store.service.BagProductService;
import com.example.cashierless_store.web.dto.BagProductSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class BagProductApiController {

    private final BagProductService bagProductService;

    // (유저 아이디, 물건 아이디 필요)
    // 유저프로덕트 추가
    @PostMapping("api/v1/bagProduct")
    public Long save(@RequestBody BagProductSaveRequestDto requestDto) {
        return bagProductService.save(requestDto);
    }

    // 한 유저의 유저프로덕트 전부 삭제
    // userId 전달하면 됨
    @PostMapping("api/v1/bagProduct/{bagId}/deleteAll")
    public void deleteAllByBagId(@PathVariable Long bagId) {
        bagProductService.deleteAllByBagId(bagId);
    }



}
