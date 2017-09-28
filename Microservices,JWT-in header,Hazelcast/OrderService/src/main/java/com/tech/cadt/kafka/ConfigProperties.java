package com.tech.cadt.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public class ConfigProperties {

	private String brokerAddress;

	private String topic;
	private String topic1;
	
	public String getTopic1() {
		return topic1;
	}

	public void setTopic1(String topic1) {
		this.topic1 = topic1;
	}

	public String getBrokerAddress() {
		return this.brokerAddress;
	}

	public void setBrokerAddress(String brokerAddress) {
		this.brokerAddress = brokerAddress;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}


}
