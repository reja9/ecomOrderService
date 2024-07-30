package dev.reja.orderService.orderService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateOrderDto {

    private String token;
    private UUID cartId;
    private BigDecimal totalAmt;

}
