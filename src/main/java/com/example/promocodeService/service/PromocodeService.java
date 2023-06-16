package com.example.promocodeService.service;

import com.example.promocodeService.exception.ApiException;
import com.example.promocodeService.exception.ExceptionType;
import com.example.promocodeService.model.Promocode;
import com.example.promocodeService.model.Status;
import com.example.promocodeService.repository.PromocodeRepository;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import java.util.Objects;
import java.util.Optional;

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
    public Mono<String> createPromocode(Long userId) {
        Optional<Promocode> promocodeOptional = promocodeRepository.findPromocodeByUserId(userId).blockOptional();
        if (promocodeOptional.isEmpty()) {
            Promocode promocode = promocodeRepository.save(new Promocode(userId, Status.NEW)).block();
            return requestHandler.requestPromocode(userId).doOnNext(promocodeValue -> {
                promocode.setValue(promocodeValue);
                promocode.setStatus(Status.GENERATED);
                promocodeRepository.save(promocode).subscribe();
            });
        } else if (promocodeOptional.get().getStatus().equals(Status.NEW)) {
            throw new ApiException("You have already created request for promocode generation. Please wait a " +
                    "little bit and check again.", ExceptionType.TOO_MANY_REQUESTS);
        }
        throw new ApiException("Your have already generated a promocode: " +
                promocodeRepository.findPromocodeByUserId(userId).block().getValue(), ExceptionType.CONFLICT);
    }

    public String getPromocodeValueByUserId(Long userId) {
        return promocodeRepository.findPromocodeByUserId(userId).blockOptional()
                .orElseThrow(() -> new ApiException("This user has not generated a promocode yet!",
                        ExceptionType.NO_RESULT)).getValue();
    }
}
