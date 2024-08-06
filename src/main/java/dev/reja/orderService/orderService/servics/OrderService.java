package dev.reja.orderService.orderService.servics;

import dev.reja.orderService.orderService.dtos.CreateOrderDto;
import dev.reja.orderService.orderService.models.Order;

import java.util.UUID;

public interface OrderService {
    public Order createOrder(CreateOrderDto createOrderDto);
    public Order updateOrderByOrderId(UUID orderId);
}
