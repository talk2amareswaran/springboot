package com.talk2amareswaran.projects.springkafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringKafkaDemoApplication {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@RequestMapping(value="/produce", method=RequestMethod.GET)
	public String produceKafkaMessage() {
		kafkaTemplate.send("messenger", "This message is coming from Producer - Hello Kafka");
		return "Message succcessfully Produced to Kafka";
	}
	
	@KafkaListener(topics="messenger", group="group-id")
	public void kafkaListener1(String message) {
		System.out.println("Message received from Producer to Consumer");
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaDemoApplication.class, args);
	}
}
