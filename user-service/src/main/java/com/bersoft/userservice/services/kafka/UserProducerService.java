package com.bersoft.userservice.services.kafka;

import com.bersoft.basemodels.models.User;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class UserProducerService {

    private KafkaTemplate<String, User> kafkaTemplate;
    private NewTopic topic;

    public void sendMessage(User user) {
        //logs
        log.info("User sent => {}", user);

        //decide where partition this user belong
        int partitionId = partitionDestination(user);

        //create message
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .setHeader(KafkaHeaders.PARTITION, partitionId)
                .build();

        //send the message
        kafkaTemplate.send(message);
    }

    private int partitionDestination(User user) {
        return user.getName().matches("^[A-Ma-m]\\w+$") ? 0 : 1;
    }
}
