package dev.reja.orderService.orderService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {
    private UUID userId;
    private  String name;
    private String email;
    private String contactNo;
    private String userName;
}
