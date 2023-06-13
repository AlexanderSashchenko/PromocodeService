package com.example.promocodeService.controller;

import com.example.promocodeService.service.PromocodeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/promocode")
public class PromocodeController {

    private final PromocodeService promocodeService;

    public PromocodeController(PromocodeService promocodeService) {
        this.promocodeService = promocodeService;
    }

    @GetMapping
    public Mono<String> getNewPromocode() {
        return promocodeService.createNewPromocode();
    }

    @GetMapping("/user/{userId}")
    public String checkAndReturnIfExists(@PathVariable("userId") Long userId) {
        return "";
    }
}
