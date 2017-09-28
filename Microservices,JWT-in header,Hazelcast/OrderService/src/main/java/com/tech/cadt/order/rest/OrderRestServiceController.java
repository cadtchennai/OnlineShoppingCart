package com.tech.cadt.order.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import javax.ws.rs.Consumes;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.tech.cadt.OrderRepository;
//import com.tech.cadt.OrderRepository;
import com.tech.cadt.hystrixdashboard.CreateOrderService;
import com.tech.cadt.hystrixdashboard.GetOrderByCustomer;
import com.tech.cadt.hystrixdashboard.GetOrderService;
import com.tech.cadt.kafka.ConfigProperties;
import com.tech.cadt.kafka.FundTransferRequest;
import com.tech.cadt.kafka.JsonConfiguration;
import com.tech.cadt.kafka.Sender;
import com.tech.cadt.order.entity.OrderProduct;

@EnableKafka
@Import({ JsonConfiguration.class, ConfigProperties.class })
@RestController
@RequestMapping("/orders")
@Component
public class OrderRestServiceController {
	@Autowired
	private Sender sender;

	@Autowired
	private ConfigProperties configProperties;

	@Autowired
	private ConcurrentKafkaListenerContainerFactory<String, Object> con;

	ConsumerRecord<String, Object> objects = null;

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	FundTransferRequest fundTransferRequest;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrderRestServiceController.class);
	private static final String signingKey = "signingKey";


	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public OrderProduct createOrder(@Valid @RequestBody OrderProduct order,
			HttpServletResponse httpServletResponse,
			@RequestHeader HttpHeaders headers,
			HttpServletRequest httpServletRequest) throws Exception {
		CreateOrderService createOrderService = new CreateOrderService();
		createOrderService.execute();
		System.out.println("inside create");
		/*
		String ipAddressOrder = httpServletRequest.getRemoteAddr();
		List<String> strlistAuthentication = new ArrayList<String>();
		strlistAuthentication.addAll(0, headers.get("jwtToken"));
		strlistAuthentication.add(1, ipAddressOrder);
		String kafkaRes = null;
		List<String> strlist = new ArrayList<String>();
		strlist.addAll(0, headers.get("jwtToken"));
		strlist.addAll(1, headers.get("email"));
		strlist.addAll(2, headers.get("phNumber"));
		strlist.addAll(3, headers.get("customerName"));

		String str = strlist.get(0).toString();
		String email = strlist.get(1).toString();
		String phNumberString = strlist.get(2).toString();
		long phNumber = Long.parseLong(phNumberString);
		String customerName = strlist.get(3).toString();
		RestTemplate restTemplate = new RestTemplate();
		String res = restTemplate.postForObject(getDynamicIp()
				+ "/jwt-service/loginService/isValid", strlistAuthentication,
				String.class);
		System.out.println("value of res= " + res);

		if (res.equalsIgnoreCase("validToken")) {
			System.out.println("inside if validToken");*/

			
			order.getOrderDate();
			order = orderRepository.save(order);

		/*	fundTransferRequest.setOrderId(order.getOrderId());
			fundTransferRequest.setCustomerId(order.getCustomerId());
			fundTransferRequest.setDeliveryAddr(order.getDeliveryAddr());
			fundTransferRequest.setEmail(email);
			fundTransferRequest.setPhNumber(phNumber);
			fundTransferRequest.setCustomerName(customerName);

			sender.sendMessage(this.configProperties.getTopic(),
					fundTransferRequest);*/

	//	}
	
		
		return order;
	
	}

	

	@KafkaListener(topics = "fundTransferResponseTopic")
	public void listen(ConsumerRecord<String, Object> object) {
		objects = object;
		System.out.println("Received: Value: " + object.value() + " Key : "
				+ object.key() + " Offset : " + object.offset());
	}

	@KafkaListener(topics = "fundTransferResponseTopicShipping")
	public void listen1(ConsumerRecord<String, Object> object) {
		objects = object;
		System.out.println("Received: Value: " + object.value() + " Key : "
				+ object.key() + " Offset : " + object.offset());
	}

	@RequestMapping("/kafkaProducerSuccess")
	public String kafkaSuccess() {

		listen(objects);
		return "Message Received Successfully";
	}

	@RequestMapping(value = "/getOrderByCustomer", method = RequestMethod.POST, produces = "application/json")
	public List<OrderProduct> getOrderBasedOnCustomerId(
			@RequestBody long customerIdValue,
			HttpServletResponse httpServletResponse,
			@RequestHeader HttpHeaders headers,
			HttpServletRequest httpServletRequest) throws Exception {
		List<OrderProduct> getCustomer = null;
		long customerId = customerIdValue;
		GetOrderByCustomer getOrderByCustomer = new GetOrderByCustomer();
		getOrderByCustomer.execute();
		/*

		String ipAddressOrder = httpServletRequest.getRemoteAddr();
		List<String> strlist = new ArrayList<String>();
		strlist.addAll(0, headers.get("jwtToken"));
		strlist.add(1, ipAddressOrder);
		RestTemplate restTemplate = new RestTemplate();
		String res = restTemplate.postForObject(getDynamicIp()
				+ "/jwt-service/loginService/isValid", strlist, String.class);
		System.out.println("value of res= " + res);

		if (res.equalsIgnoreCase("validToken")) {*/
			getCustomer = orderRepository.findByCustomerId(customerId);
		//}
		return getCustomer;

	}

	@RequestMapping("/getOrder")
	@ResponseBody
	public List<OrderProduct> getAll() {

		GetOrderService getOrderService = new GetOrderService();
		getOrderService.execute();
		Iterable<OrderProduct> getCustomer = null;
		getCustomer = orderRepository.findAll();
		List<OrderProduct> list = new ArrayList<OrderProduct>();
		if (getCustomer != null) {
			for (OrderProduct e : getCustomer) {
				list.add(e);
			}
		}

		return list;

	}

}