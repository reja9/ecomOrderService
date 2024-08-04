package dev.reja.orderService.orderService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreatePaymentDto {
    private UUID userId;
    private BigDecimal amount;
    private String orderId;
    private String description;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
}
