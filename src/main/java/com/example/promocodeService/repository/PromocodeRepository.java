package com.example.promocodeService.repository;

import com.example.promocodeService.model.Promocode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocodeRepository extends JpaRepository<Promocode,Long> {
}
