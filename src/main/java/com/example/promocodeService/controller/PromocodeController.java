package com.example.promocodeService.controller;

import com.example.promocodeService.service.PromocodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/promocode")
public class PromocodeController {

    private final PromocodeService promocodeService;

    public PromocodeController(PromocodeService promocodeService) {
        this.promocodeService = promocodeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> createPromocode() {
        return promocodeService.createPromocode();
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String checkAndReturnIfExists(@PathVariable("userId") Long userId) {
        return promocodeService.getPromocodeValueByUserId(userId);
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleException(RuntimeException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
