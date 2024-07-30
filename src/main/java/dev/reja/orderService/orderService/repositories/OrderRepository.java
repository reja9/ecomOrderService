package dev.reja.orderService.orderService.repositories;

import dev.reja.orderService.orderService.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
