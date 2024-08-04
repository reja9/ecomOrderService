package dev.reja.orderService.orderService.controllers;

import dev.reja.orderService.orderService.dtos.CreateOrderDto;
import dev.reja.orderService.orderService.servics.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/createOrder")// used to hit by product Service
    public ResponseEntity createOrder(@RequestBody CreateOrderDto createOrderDto){
        return ResponseEntity.ok(orderService.createOrder(createOrderDto));
    }
}
