package com.tech.cadt.kafka.consumer;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.kafka.common.KafkaException;
import org.omg.IOP.Codec;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class OrderProduct  {
	
	
	 private Integer orderId;
	
	

	
	 private long productId;
	
	

	private long customerId;	
	 
	 private String username;	
	
	 private String paymentMode;	

	 private String billingAddress;	 
	 
	 private String deliveryAddr;	 
	 
	 private int orderQuantity;
	 
	 private long totalAmt;
	 private String value;
	 //private Date orderDate = new Date();
	 
	 public OrderProduct(){
			
		}
			
	 public OrderProduct(String value){
			this.value=value;
		}
	 
		public OrderProduct(Integer orderId, long productId, long customerId,
				String username, String paymentMode, String billingAddress,String deliveryAddr,int orderQuantity,long totalAmt) {
			
			this.orderId = orderId;
			this.productId = productId;
			this.customerId = customerId;
			this.username = username;
			this.paymentMode = paymentMode;
			this.billingAddress = billingAddress;
			this.deliveryAddr = deliveryAddr;
			this.orderQuantity = orderQuantity;
			this.totalAmt = totalAmt;
		}

	
	 private Date orderDate = new java.sql.Date(System.currentTimeMillis());

	 public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getCustomerId() {
			return customerId;
		}

	public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getDeliveryAddr() {
		return deliveryAddr;
	}

	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public long getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(long totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	 
	 /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	 @Override
		public String toString() {
			return "OrderProduct [orderId=" + orderId + ", productId=" + productId
					+ ", customerId=" + customerId + ", username=" + username
					+ ", paymentMode=" + paymentMode + ", billingAddress="
					+ billingAddress + ", deliveryAddr=" + deliveryAddr
					+ ", orderQuantity=" + orderQuantity + ", totalAmt=" + totalAmt
					+ ", orderDate=" + orderDate + "]";
		}
	
	

	
}
