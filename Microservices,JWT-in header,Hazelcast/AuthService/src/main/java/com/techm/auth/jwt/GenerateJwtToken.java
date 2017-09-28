package com.techm.auth.jwt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.techm.auth.hystrix.GenerateToken;
import com.techm.auth.hystrix.TokenIsValid;




@RestController
@RequestMapping(value="/loginService")
@Component

public class GenerateJwtToken {		
	
	
	

	/*@RequestMapping(value= "/isValid",method = RequestMethod.POST, produces = "text/plain")	


	public String isValid(@RequestBody List<String> listToken ,HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest){
		
		System.out.println( "isValid() starts" );
		String result="";
		String tokenResult="";
		
		TokenIsValid tokenIsValid=new TokenIsValid();
		tokenIsValid.execute();
		
		String token = listToken.get(0) ;
		String ipAddressOrder = listToken.get(1);
		
		System.out.println("check token from header: "+token+"   "+"ip= "+ipAddressOrder);
		
		System.out.println("ipAddressOrder: "+ipAddressOrder);

		String ipAddressOrder1 =  httpServletRequest.getRemoteAddr();
		System.out.println("IP Address: "+ipAddressOrder);
		
		ClientConfig clientConfig = new ClientConfig();
		
			clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
			clientConfig.getNetworkConfig().addAddress("172.18.32.167:5701", "172.18.32.167:5702");
			
			HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
			IMap<String, String> map = client.getMap( "jwttoken" );	

			
			  String authvalue= map.keySet().toString();
	    	
	    	  result= authvalue.replaceAll("[\\[\\]]","");
	    	
	    	  String replace = map.values().toString();
	    	  tokenResult = replace.replaceAll("[\\[\\]]","");
	    
	    	System.out.println("authvalue--"+result);
	    	System.out.println("tokenResult--"+tokenResult);
			
			
			String jwtUsername = JwtUtil.getSubject(httpServletResponse,token, signingKey);
			String jwtPassword = JwtUtil.getPassword(httpServletResponse,token, signingKey);
			LOGGER.info("::::::Jwt User credentials after Parsing:::::");
			LOGGER.info("username::" + jwtUsername);
			LOGGER.info("password::" + jwtPassword);

		
			LOGGER.info("Customer Object from Customer Service ::::");
			 String valueOrder = new StringBuilder(ipAddressOrder).append("-").append(jwtUsername).toString();
			
				boolean validation=false;
				if (jwtUsername != null) {
					
					if ((token.equals(tokenResult)) && (result.equals(valueOrder)) ) {
						validation = true;
						result="validToken";
						LOGGER.info("JWT Token Validataion Sucessful in Service.");
						return result;
					} 
						
			
					else if(result.equals(null)||result.equals("")){
						result="notValid";
						System.out.println("inside result null");
						return result;
					}
					else
					{
						
						result="notValid";
						LOGGER.info("JWT Token Validataion failed in Service.");
							
						validation = false;
						return result;
					}
					
					
				} 
				else {
					result="username is not valid";
					validation = false;
					return result;
				}			
				
		
	}*/
	    private static final String signingKey = "signingKey";
	    String token = null ;
	    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateJwtToken.class);
	    String customlogger ="ADMS Loger::::";
	   
		@RequestMapping(value="/generateToken",method = RequestMethod.POST, produces = "application/json")	

		public String generateToken(HttpServletResponse httpServletResponse,@RequestBody String userCredentials,HttpServletRequest httpServletRequest) {
			GenerateToken generateToken=new GenerateToken();
			generateToken.execute();
			String result=null;
			System.out.println("inside generateToken");
			
			
			String javaHome = System.getenv("eurekahost");
			
			
			System.out.println("eurekahost: "+javaHome);
			return javaHome;	
			/*String ipAddress =  httpServletRequest.getRemoteAddr();	    	
	    	System.out.println("IP Address: "+ipAddress);
	    	*/
	    	
			
	    	
	    	/*RestTemplate restTemplate = new RestTemplate();	
			System.out.println("userCredentials: "+userCredentials);
			
			
			String res=restTemplate.postForObject("http://localhost:9090/customer-service/customer/getCustomer", userCredentials, String.class);
			System.out.println("value of res= "+res);	
			*/
			
			
			
	    	/*ClientConfig clientConfig = new ClientConfig();
	    	System.out.println("clientConfig----"+clientConfig);
	       
			clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
			
			clientConfig.getNetworkConfig().addAddress("172.18.32.167:5701", "172.18.32.167:5702");			
			
		    HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);	    
		   
	        IMap<String, String> jwttoken = client.getMap("jwttoken");      
	    	
	        jwttoken.evictAll();
			LOGGER.info(customlogger+"GenerateJwtToken Started");
			LOGGER.info(customlogger+"Loggedin User Credentials ::" + userCredentials);
			JSONObject userCredjson = null;
			String username = null;
			String password = null;*/
			
			
			
			/*try {
				
					
					
				if (userCredentials != null)
					userCredjson = new JSONObject(userCredentials.toString());
				if (userCredjson != null) {
					username = userCredjson.optString("userName");
					System.out.println("username------"+username);
					System.out.println("username--aaa----"+userCredjson);
					password = userCredjson.optString("password");
					LOGGER.info(customlogger+"Entered username ::"+username+"\t Entered password ::"+password);
					
					if(res.equals("success")){
					
					token = JwtUtil.generateToken(signingKey, username,password);
					LOGGER.info(customlogger+"Generated JwtToken:::" +token);
					System.out.println("success");
					String value = new StringBuilder(ipAddress).append("-").append(username).toString();
					System.out.println(value);
					jwttoken.put(value,token);
					
				
				}
					}
			} catch (Exception e) {
				LOGGER.error(customlogger+"Exception Occured in generateToken() method");
				e.printStackTrace();
			}*/
			
			
			//return token;
		}
		


}
