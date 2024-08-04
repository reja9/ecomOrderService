package dev.reja.orderService.orderService.servics;

import dev.reja.orderService.orderService.Clent.UserClent;
import dev.reja.orderService.orderService.dtos.CreateOrderDto;
import dev.reja.orderService.orderService.dtos.CreatePaymentDto;
import dev.reja.orderService.orderService.dtos.UserResponseDto;
import dev.reja.orderService.orderService.exceptions.RandomException;
import dev.reja.orderService.orderService.models.Order;
import dev.reja.orderService.orderService.models.OrderStatus;
import dev.reja.orderService.orderService.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${create.payment.url")
    String createPaymentUrl;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClent userClent;
    @Override
    public Order createOrder(CreateOrderDto createOrderDto) {


        UserResponseDto userResponseDto=userClent.getUserByToken(createOrderDto.getToken());
        UUID userId=userResponseDto.getUserId();
        Order order=new Order();
        order.setUserId(userId);
        order.setCartId(createOrderDto.getCartId());
        order.setTotalAmt(createOrderDto.getTotalAmt());
        String transactionId=UUID.randomUUID().toString();
        order.setTransactionId(transactionId);
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        order=orderRepository.save(order);


        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization", createOrderDto.getToken());
        CreatePaymentDto createPaymentDto=new CreatePaymentDto();
        createPaymentDto.setOrderId(String.valueOf(order.getId()));
        createPaymentDto.setAmount(order.getTotalAmt());
        createPaymentDto.setDescription("order id : "+order.getId());

        createPaymentDto.setCustomerName(userResponseDto.getName());
        createPaymentDto.setCustomerPhone(userResponseDto.getContactNo());
        createPaymentDto.setCustomerEmail(userResponseDto.getEmail());
        HttpEntity<CreatePaymentDto> entity =new HttpEntity<CreatePaymentDto>(createPaymentDto,headers);
        ResponseEntity response=restTemplate.exchange(createPaymentUrl, HttpMethod.POST, entity, String.class);
        if(response.getStatusCode()!= HttpStatusCode.valueOf(200)){
            throw new RandomException("response inValid");
        }
        return order;
    }
}
