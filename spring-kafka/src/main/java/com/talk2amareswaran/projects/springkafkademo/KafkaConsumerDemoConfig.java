package com.talk2amareswaran.projects.springkafkademo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConsumerDemoConfig {

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> consumerconfigProperties = new HashMap<>();
		consumerconfigProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		consumerconfigProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
		consumerconfigProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerconfigProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(consumerconfigProperties);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> kafkaFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		kafkaFactory.setConsumerFactory(consumerFactory());
		return kafkaFactory;
	}

}
