package dev.reja.orderService.orderService.Clent;

import dev.reja.orderService.orderService.dtos.UserResponseDto;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class UserClent {

    @Value("${user.service.findByToken.url")
    String findByTokenUrl;
    @Autowired
    RestTemplate restTemplate;
    public UserResponseDto getUserByToken(String token){

        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> entity=new HttpEntity(headers);
        ResponseEntity response=restTemplate.exchange(findByTokenUrl, HttpMethod.GET,entity,String.class);

        JSONObject jsonObject=new JSONObject(response.getBody());
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setUserId(UUID.fromString(jsonObject.getString("id")));
        userResponseDto.setName(jsonObject.getString("name"));
        userResponseDto.setUserName(jsonObject.getString("userName"));
        userResponseDto.setContactNo(jsonObject.getString("contactNo"));
        userResponseDto.setEmail(jsonObject.getString("email"));
        return userResponseDto;

    }
}
