package com.example.promocodeService.service;

import com.example.promocodeService.model.Promocode;
import com.example.promocodeService.model.User;
import com.example.promocodeService.repository.PromocodeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

    public Mono<String> createNewPromocode() {
        User user = userService.saveUser();
        Mono<String> promocodeMono = requestHandler.requestPromocode(user.getId());
        savePromocode(user.getId(), promocodeMono);
        return promocodeMono;
    }

    public void savePromocode(Long userId, Mono<String> promocodeMono) {
        User user = userService.getById(userId);
        promocodeMono.subscribe(promocodeValue -> {
            Promocode promocode = new Promocode(promocodeValue, user);
            promocodeRepository.save(promocode);
        });

    }
}
