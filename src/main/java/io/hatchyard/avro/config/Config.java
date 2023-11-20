package io.hatchyard.avro.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import io.hatchyard.avro.schema.HelloMessage;

@Configuration
public class Config {

	@Bean
    public ConsumerFactory<String, HelloMessage> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }
	
	@Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, HelloMessage>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, HelloMessage> factory = new ConcurrentKafkaListenerContainerFactory<String, HelloMessage>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }
}
