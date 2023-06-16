package com.example.promocodeService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/generator")
public class ThirdPartyApiStub {

    /**
     * Third party API imitation that generates and returns promocodes but works unstable,
     * and it takes from 100 to 10000 ms to handle the request.
     * @param userId, never used
     * @return promocode value
     */
    @GetMapping("/{userId}")
    public String generatePromocode(@PathVariable("userId") Long userId) throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        TimeUnit.MILLISECONDS.sleep((long) ((Math.random() * (10000 - 100)) + 100));
        return uuid;
    }
}
