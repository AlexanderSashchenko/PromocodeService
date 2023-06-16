package com.example.promocodeService.repository;

import com.example.promocodeService.model.Promocode;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PromocodeRepository extends ReactiveCrudRepository<Promocode,Long> {

    @Query("FROM promocodes p WHERE p.user_id = ?1")
    Mono<Promocode> findPromocodeByUserId(Long userId);
}
