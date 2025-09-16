package com.kafka_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void sendMessageToTopic(String message) {
		
	}
}
