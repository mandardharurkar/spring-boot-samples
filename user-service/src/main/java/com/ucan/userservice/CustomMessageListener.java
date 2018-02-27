package com.ucan.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.ucan.userservice.model.CustomMessage;

@Service
public class CustomMessageListener {

	private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

	@RabbitListener(queues = RegistrationApplication.QUEUE_GENERIC_NAME)
	public void receiveMessage(final Message message) {
		log.info("Received message as generic: {}", message.toString());
	}

	@RabbitListener(queues = RegistrationApplication.QUEUE_SPECIFIC_NAME)
	public void receiveMessage(final CustomMessage customMessage) {
		log.info("Received message as specific class: {}", customMessage.toString());
	}
}