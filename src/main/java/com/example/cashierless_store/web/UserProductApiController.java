package com.example.cashierless_store.web;

import com.example.cashierless_store.service.UserProductService;
import com.example.cashierless_store.web.dto.UserProductSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class UserProductApiController {

    private final UserProductService userProductService;

    // (유저 아이디, 물건 아이디 필요)
    // 유저프로덕트 추가
    @PostMapping("api/v1/userProduct")
    public Long save(@RequestBody UserProductSaveRequestDto requestDto) {
        return userProductService.save(requestDto);
    }

    // 한 유저의 유저프로덕트 전부 삭제
    // userId 전달하면 됨
    @PostMapping("api/v1/userProduct/{userId}/deleteAll")
    public void deleteAllByUserId(@PathVariable Long userId) {
        userProductService.deleteAllByUserId(userId);
    }



}
