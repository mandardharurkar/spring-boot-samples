package com.ucan.userservice;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ucan.userservice.model.CustomMessage;

@Service
public class CustomMessageSender {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CustomMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

  //  @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        final CustomMessage message = new CustomMessage("Hello there!", new Random().nextInt(50), false);
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(RegistrationApplication.EXCHANGE_NAME, RegistrationApplication.ROUTING_KEY, message);
    }
}