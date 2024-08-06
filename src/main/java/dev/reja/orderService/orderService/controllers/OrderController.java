package dev.reja.orderService.orderService.controllers;

import dev.reja.orderService.orderService.dtos.CreateOrderDto;
import dev.reja.orderService.orderService.servics.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/createOrder")// used to hit by product Service
    public ResponseEntity createOrder(@RequestBody CreateOrderDto createOrderDto){
        return ResponseEntity.ok(orderService.createOrder(createOrderDto));
    }

    @PutMapping("/updateOrder")
    public ResponseEntity updateOrder(@RequestParam("orderId")UUID orderId){
        return ResponseEntity.ok(orderService.updateOrderByOrderId(orderId));
    }
}
