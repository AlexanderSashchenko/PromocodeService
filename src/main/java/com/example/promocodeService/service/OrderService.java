package com.example.promocodeService.service;

import com.example.promocodeService.model.Order;
import com.example.promocodeService.model.Promocode;
import com.example.promocodeService.model.User;
import com.example.promocodeService.model.constants.Status;
import com.example.promocodeService.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final UserService userService;
    private final PromocodeService promocodeService;
    private final OrderRepository orderRepository;

    public OrderService(UserService userService,
                        PromocodeService promocodeService,
                        OrderRepository orderRepository) {
        this.userService = userService;
        this.promocodeService = promocodeService;
        this.orderRepository = orderRepository;
    }
    public Order createNewOrder() {
        User user = userService.saveUser();
        Promocode promocode = promocodeService.savePromocode();
        return orderRepository.save(new Order(user, promocode, Status.NEW));

        //call method for generating promocode from 3rd party service
    }

}
