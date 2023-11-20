package io.hatchyard.avro.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.hatchyard.avro.dto.HelloMessageDTO;
import io.hatchyard.avro.producer.KafkaAvroProducer;
import io.hatchyard.avro.schema.HelloMessage;

@RestController
public class KafkaAvroController {
	
	@Autowired
	KafkaAvroProducer kafkaProducer;
	
	@PostMapping(value="/send")
	public void sendMessage(@RequestBody HelloMessageDTO helloMessageDTO) {
		
		HelloMessage helloMessage = HelloMessage.newBuilder().build();
		
		helloMessage.setId(String.valueOf(new Random(1000).nextInt()));
		helloMessage.setTo(helloMessageDTO.getTo());
		helloMessage.setFrom(helloMessageDTO.getFrom());
		helloMessage.setMessage(helloMessageDTO.getMessage());
		
		kafkaProducer.send(helloMessage);
	}
}
