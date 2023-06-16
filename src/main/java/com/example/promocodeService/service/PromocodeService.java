package com.example.promocodeService.service;

import com.example.promocodeService.exception.ApiException;
import com.example.promocodeService.exception.ExceptionType;
import com.example.promocodeService.model.Promocode;
import com.example.promocodeService.repository.PromocodeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Objects;

@Service
public class PromocodeService {

    private final UserService userService;
    private final RequestHandler requestHandler;
    private final PromocodeRepository promocodeRepository;

    public PromocodeService(UserService userService,
                            PromocodeRepository promocodeRepository,
                            RequestHandler requestHandler) {
        this.userService = userService;
        this.requestHandler = requestHandler;
        this.promocodeRepository = promocodeRepository;
    }

    /**
     * Using .block() in non-blocking context for convenience as far as we are creating users on flight
     * during promocode generation and not receiving userId from client
     */
    public Mono<String> createPromocode() {
        Long userId = Objects.requireNonNull(userService.saveUser().block()).getId();
        return requestHandler.requestPromocode(userId)
                .doOnNext(promocodeValue -> {
                    promocodeRepository.save(new Promocode(promocodeValue, userId)).subscribe();
                });
    }

    public String getPromocodeValueByUserId(Long userId) {
        return promocodeRepository.findPromocodeByUserId(userId).blockOptional()
                .orElseThrow(() -> new ApiException("This user has not generated a promocode yet!",
                        ExceptionType.NO_RESULT)).getValue();
    }
}
