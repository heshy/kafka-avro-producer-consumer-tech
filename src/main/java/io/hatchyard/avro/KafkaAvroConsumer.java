package io.hatchyard.avro;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.hatchyard.avro.schema.HelloMessage;

@Service
public class KafkaAvroConsumer {
	
	@KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<String, HelloMessage> record){
        String key=record.key();
        HelloMessage hello=record.value();
        System.out.println("Avro message received for key : "+key+ " value : "+hello.toString());
    }
}
