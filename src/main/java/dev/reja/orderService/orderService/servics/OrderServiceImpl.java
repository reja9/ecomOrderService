package dev.reja.orderService.orderService.servics;

import dev.reja.orderService.orderService.dtos.CreateOrderDto;
import dev.reja.orderService.orderService.models.Order;
import dev.reja.orderService.orderService.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order createOrder(CreateOrderDto createOrderDto) {
        UUID userId=UUID.randomUUID();//used to get fropm usertoken
        Order order=new Order();
        order.setUserId(userId);
        order.setCartId(createOrderDto.getCartId());
        order.setTotalAmt(createOrderDto.getTotalAmt());
        String transactionId=UUID.randomUUID().toString();
        order.setTransactionId(transactionId);
        orderRepository.save(order);
        return order;
    }
}
