package com.example.promocodeService.repository;

import com.example.promocodeService.model.Promocode;
import com.example.promocodeService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromocodeRepository extends JpaRepository<Promocode,Long> {

    Optional<Promocode> findPromocodeByUser(User user);
}
