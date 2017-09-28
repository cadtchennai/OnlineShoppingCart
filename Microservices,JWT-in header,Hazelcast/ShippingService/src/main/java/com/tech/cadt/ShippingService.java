package com.tech.cadt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.common.util.concurrent.Service.Listener;
import com.tech.cadt.entity.Shipping;
import com.tech.cadt.kafka.consumer.ConfigProperties;
import com.tech.cadt.kafka.consumer.JsonConfiguration;
import com.tech.cadt.kafka.consumer.OrderProduct;
import com.tech.cadt.kafka.consumer.Sender;
import com.tech.cadt.repository.ShippingRepository;

@SpringBootApplication
@EnableKafka
@Import({ JsonConfiguration.class, ConfigProperties.class })
@EnableEurekaClient
@EnableWebMvc

@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@Component
@ComponentScan("com.tech.cadt.*")
public class ShippingService {
	public static void main(String[] args) {
		SpringApplication.run(ShippingService.class, args);
	}

  @Bean
	public Listener listener() {
			
			return new Listener() {
			};
		}
	
public static class Listener {		
	/*@Autowired
	OrderProduct orderProduct;*/
	@Autowired
	ShippingRepository shippingRepository;
	
	
	@Autowired
	private Sender sender;
	
	
		
	
	@Autowired
	private ConfigProperties configProperties;
	
	@Autowired
	private RestTemplate restTemplate;		

	
	
	//@KafkaListener(topics = "fundTransferRequestTopicShipping")
	@KafkaListener(topics = "fundTransferRequestTopic")
	public void listen(Shipping object) throws Exception {
		System.out.println("Received: Value: " + object);
		//java.sql.Date sqlStartDate = new java.sql.Date(object.getOrderDate().getTime());
		//object.setOrderDate(sqlStartDate);
		try {
		Map<String, Object> jsonValues = new HashMap<String, Object>();
	    jsonValues.put("ReferenceId", object.getOrderId());
	    jsonValues.put("ErrorCode", "1245");
	    jsonValues.put("Error_Desc" , "Success");			    
	    Object objectreturn=jsonValues;			    
		sender.sendMessage(this.configProperties.getResponseTopic(),objectreturn);				
		String msg=	restTemplate.getForObject(this.configProperties.getRestURL(),String.class);
		System.out.println("In Consumer second msg : "+msg);
		object.setStatus("Shipped");
		if(msg.equals("Message Received Successfully")){	
			shippingRepository.save(object);
		}
		
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

}

		
}