package com.tech.cadt.shipping.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
//import com.tech.cadt.ShippingService.Listener;
import com.tech.cadt.entity.Shipping;
import com.tech.cadt.hystrixdashboard.CreateShippingService;
import com.tech.cadt.hystrixdashboard.GetShippingStatus;
import com.tech.cadt.kafka.consumer.ConfigProperties;
import com.tech.cadt.kafka.consumer.Sender;
import com.tech.cadt.repository.ShippingRepository;

@RestController
@RequestMapping("/shipping")
public  class ShippingServiceController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShippingServiceController.class);
    private static final String signingKey = "signingKey";
	
	
	@Autowired
	ShippingRepository shippingRepository;
	
	
	
/*	@Bean
	public Listener listener() {
			
			return new Listener() {
			};
		}
	
public static class Listener {		
	@Autowired
	
	OrderProduct orderProduct;
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

}*/


	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	
	public Shipping createShipping(@RequestBody Shipping shipping,HttpServletResponse httpServletResponse,@RequestHeader HttpHeaders headers,HttpServletRequest httpServletRequest) throws Exception {
		CreateShippingService createShippingService = new CreateShippingService();
		createShippingService.execute();
		//Listener listener = new Listener();
		/*String ipAddressOrder =  httpServletRequest.getRemoteAddr();
		 List<String> strlist = new ArrayList<String>();
		  strlist.addAll(0, headers.get("jwtToken"));
		 strlist.add(1, ipAddressOrder);
		
		 ArrayList<String> strlist = new ArrayList<String>();
		  strlist.addAll(0, headers.get("jwtToken"));
		  //System.out.println("value of requested header strlist = "+strlist.get(0).toString());
		  String str = strlist.get(0).toString();
		 
		 // System.out.println("value of requested header strarray = "+str);
			RestTemplate restTemplate = new RestTemplate();	
			String res = restTemplate.postForObject(getDynamicIp()+"/jwt-service/loginService/isValid", strlist, String.class);
			System.out.println("value of res= "+res);
		        
		
			
			if(res.equalsIgnoreCase("validToken")){
				//listener.listen(shipping);*/
				
		shipping = shippingRepository.save(shipping);
		//}
	    return shipping;
	}
	
	
	@RequestMapping(value="/getShippingStatus",method = RequestMethod.POST, produces = "application/json")

	public Shipping getShippingStatus(@RequestBody long orderId,HttpServletResponse httpServletResponse,@RequestHeader HttpHeaders headers,HttpServletRequest httpServletRequest) throws Exception {
		
		GetShippingStatus getShippingStatus = new GetShippingStatus();
		getShippingStatus.execute();
		
		long orderIdValue = orderId;
		Shipping shipping=new Shipping();
		
		/*String ipAddressOrder =  httpServletRequest.getRemoteAddr();
		 List<String> strlist = new ArrayList<String>();
		  strlist.addAll(0, headers.get("jwtToken"));
		 strlist.add(1, ipAddressOrder);
		
	
			RestTemplate restTemplate = new RestTemplate();	
			String res = restTemplate.postForObject(getDynamicIp()+"/jwt-service/loginService/isValid", strlist, String.class);
			System.out.println("value of res= "+res);
		       
		
			
			if(res.equalsIgnoreCase("validToken")){ */
		shipping = shippingRepository.findByOrderId(orderIdValue);
		//}
	    return shipping;
	}


		
	}