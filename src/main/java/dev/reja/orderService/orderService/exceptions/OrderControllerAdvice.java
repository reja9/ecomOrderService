package dev.reja.orderService.orderService.exceptions;

import dev.reja.orderService.orderService.controllers.OrderController;
import dev.reja.orderService.orderService.dtos.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = OrderController.class)
public class OrderControllerAdvice {
    @ExceptionHandler
    public ResponseEntity orderNotFoundExceptionHandler(OrderNotFoundException e){
        ExceptionDto exceptionDto=new ExceptionDto(e.getMessage(), 404);
        return ResponseEntity.ok(exceptionDto);
    }
}
