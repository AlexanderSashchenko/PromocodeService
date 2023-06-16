package com.example.promocodeService.controller;

import com.example.promocodeService.service.PromocodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/promocode")
public class PromocodeController {

    private final PromocodeService promocodeService;

    public PromocodeController(PromocodeService promocodeService) {
        this.promocodeService = promocodeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> createPromocode() {
        return promocodeService.createPromocode();
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String checkAndReturnIfExists(@PathVariable("userId") Long userId) {
        return promocodeService.getPromocodeValueByUserId(userId);
    }
}
