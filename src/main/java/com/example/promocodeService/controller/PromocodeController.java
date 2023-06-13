package com.example.promocodeService.controller;

import com.example.promocodeService.service.PromocodeService;
import org.springframework.http.HttpStatusCode;
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
    public Mono<String> getNewPromocode() {
        return promocodeService.createNewPromocode();
    }

    @GetMapping("/user/{userId}")
    public String checkAndReturnIfExists(@PathVariable("userId") Long userId) {
        return promocodeService.getPromocodeValueByUserId(userId);
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleException(RuntimeException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.setStatus(HttpStatusCode.valueOf(200));
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
