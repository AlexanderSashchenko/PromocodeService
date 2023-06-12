package com.example.promocodeService.controller;

import com.example.promocodeService.service.PromocodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promocode")
public class PromocodeController {

    private final PromocodeService promocodeService;

    public PromocodeController(PromocodeService promocodeService) {
        this.promocodeService = promocodeService;
    }

    @GetMapping//to be changed to POST
    public String getNewPromocode() {
        return "+";
    }
}
