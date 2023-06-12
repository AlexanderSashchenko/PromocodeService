package com.example.promocodeService.service;

import com.example.promocodeService.model.Promocode;
import com.example.promocodeService.repository.PromocodeRepository;
import org.springframework.stereotype.Service;

@Service
public class PromocodeService {

    private final PromocodeRepository promocodeRepository;

    public PromocodeService(PromocodeRepository promocodeRepository) {
        this.promocodeRepository = promocodeRepository;
    }

    public Promocode savePromocode() {
        return promocodeRepository.save(new Promocode());
    }
}
