package dev.reja.orderService.orderService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "ecom_order")
@Getter
@Setter
public class Order extends BaseModel {

    private UUID cartId;
    private UUID userId;
    private BigDecimal totalAmt;
    private String transactionId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
