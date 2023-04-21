package com.bersoft.notificationservice.services.kafka;

import com.bersoft.basemodels.models.User;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserConsumerService {

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(ConsumerRecord<String, User> record) {
        log.info("User event received in notification service => {}", record.value());
        log.info("Topic: {}",record.topic());
        log.info("Offset: {}",record.offset());
        log.info("Partition: {}",record.partition());

        //implements the logic to send the notification;
    }

}
