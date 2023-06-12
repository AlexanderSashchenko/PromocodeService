package com.example.promocodeService.controller;

import com.example.promocodeService.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promocode")
public class PromocodeController {

    private final OrderService orderService;

    public PromocodeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Long getNewPromocode() {
        return orderService.createNewOrder().getId();
    }
}
