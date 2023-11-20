package io.hatchyard.avro.producer;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import io.hatchyard.avro.schema.HelloMessage;

@Service
public class KafkaAvroProducer {
	
	 @Value("${avro.topic.name}")
	 String topicName;
	 
	 @Autowired
	 private KafkaTemplate<String, HelloMessage> kafkaTemplate;
	 
	 
	 public void send(HelloMessage helloMessage) {
		 	
		 CompletableFuture<SendResult<String,HelloMessage>> future=  kafkaTemplate.send(topicName,String.valueOf(helloMessage.getId()),helloMessage);
		 
		future.whenComplete((sr,ex)->{
	        	if (ex != null) {
	                System.out.println("Error in Sending Message");
	            }
	            else {
	            	System.out.println("Sent Sucessfully");
	            }
	    });
	 }
}
