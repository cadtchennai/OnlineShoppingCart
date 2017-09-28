package com.tech.cadt.kafka;

import java.util.List;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;

import com.tech.cadt.order.entity.OrderProduct;

public class Sender {
	
	    @Autowired
	    private Producer<String,FundTransferRequest> producer;    
	    
	    //public void sendMessage(String topic,String topic1,FundTransferRequest object) throws InterruptedException { 
	    public void sendMessage(String topic,FundTransferRequest object) throws InterruptedException { 
	 	         producer.send(new ProducerRecord<String, FundTransferRequest>(topic, object));
	 	       // producer.send(new ProducerRecord<String, FundTransferRequest>(topic1, object));
	 	         System.out.println("Message sent successfully and topic value = "+ topic);
	 	        System.out.println("object= "+object);	 	
	 	      // System.out.println("Message sent successfully and topic1 value = "+ topic1);
	 	      //  System.out.println("object= "+object);	 	
	 	         producer.flush();
	      
	    }
	 
}

