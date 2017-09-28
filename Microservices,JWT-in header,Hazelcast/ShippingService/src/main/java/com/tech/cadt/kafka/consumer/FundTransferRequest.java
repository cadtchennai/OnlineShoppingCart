package com.tech.cadt.kafka.consumer;

import java.sql.Date;

public class FundTransferRequest {

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
	/* long millis=System.currentTimeMillis();  
	 
	 private Date orderDate = new java.sql.Date(millis);*/
	 private String orderDate;
	public FundTransferRequest(){
		
	}
public FundTransferRequest(String value){
		this.value=value;
	}	
	public FundTransferRequest(Integer orderId, long productId, long customerId,
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

	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the billingAddress
	 */
	public String getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the deliveryAddr
	 */
	public String getDeliveryAddr() {
		return deliveryAddr;
	}

	/**
	 * @param deliveryAddr the deliveryAddr to set
	 */
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}

	/**
	 * @return the orderQuantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * @param orderQuantity the orderQuantity to set
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * @return the totalAmt
	 */
	public long getTotalAmt() {
		return totalAmt;
	}

	/**
	 * @param totalAmt the totalAmt to set
	 */
	public void setTotalAmt(long totalAmt) {
		this.totalAmt = totalAmt;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FundTransferRequest [orderId=" + orderId + ", productId="
				+ productId + ", customerId=" + customerId + ", username="
				+ username + ", paymentMode=" + paymentMode
				+ ", billingAddress=" + billingAddress + ", deliveryAddr="
				+ deliveryAddr + ", orderQuantity=" + orderQuantity
				+ ", totalAmt=" + totalAmt + ", orderDate=" + orderDate + "]";
	}

	
}
