package com.bersoft.userservice.restcontrollers;

import com.bersoft.basemodels.models.User;
import com.bersoft.userservice.services.kafka.UserProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserProducerService producerService;

    @PostMapping
    public String createUser(@RequestBody User user) {

        //generate random id
        user.setId(UUID.randomUUID().toString());

        //send the order to kafka topic
        producerService.sendMessage(user);

        return "User created susccesfully";
    }

}
