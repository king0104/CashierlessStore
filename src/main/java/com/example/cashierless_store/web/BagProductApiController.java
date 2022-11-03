package com.example.cashierless_store.web;

import com.example.cashierless_store.service.BagProductService;
import com.example.cashierless_store.web.dto.BagProductDeleteRequestDto;
import com.example.cashierless_store.web.dto.BagProductSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class BagProductApiController {

    private final BagProductService bagProductService;

    // create
    // json : (userId, productId)
    @PostMapping("api/v1/bagProduct")
    public Long save(@RequestBody BagProductSaveRequestDto requestDto) {
        return bagProductService.save(requestDto);
    }

    // delete
    // json : (userId, productId)
    @PostMapping("api/v1/bagProduct/delete")
    public void delete(@RequestBody BagProductDeleteRequestDto requestDto) {
        bagProductService.delete(requestDto);
    }

    // deleteAll
    // json : (userId)
    @PostMapping("api/v1/bagProduct/{bagId}/deleteAll")
    public void deleteAllByBagId(@PathVariable Long bagId) {
        bagProductService.deleteAllByBagId(bagId);
    }

}
