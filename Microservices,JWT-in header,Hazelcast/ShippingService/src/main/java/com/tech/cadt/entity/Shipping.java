package com.tech.cadt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shipping implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shippingId") 
	private Integer shippingId;
	private long orderId;
	private long  customerId;
	private String customerName;
	private String email;
	private String deliveryAddr;	
	private long phNumber;
	private String status;
	
	 public Shipping(){
			
		}
			
	 public Shipping(String value){
		// String value1=value;
		
		}
	 
	 
	 public Shipping(Integer shippingId, long orderId,long  customerId,String customerName,String email,String deliveryAddr,long phNumber,String status){
		this.shippingId= shippingId;
		this.orderId= orderId;
		this.customerId= customerId;
		this.email= email;
		this.customerName= customerName;
		this.deliveryAddr= deliveryAddr;
		this.phNumber= phNumber;
		this.status= status;
		
	 }

	public Integer getShippingId() {
		return shippingId;
	}
	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmailId(String email) {
		this.email = email;
	}
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public long getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", orderId=" + orderId
				+ ", customerId=" + customerId + ", customerName="
				+ customerName + ", email=" + email + ", deliveryAddr="
				+ deliveryAddr + ", phNumber=" + phNumber
				+ ", status=" + status + "]";
	}

}
