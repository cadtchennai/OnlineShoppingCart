package com.tech.cadt.kafka;
import java.sql.Date;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties(ignoreUnknown = false)
@Service("fundTransferRequest")
public class FundTransferRequest {

	 private Integer orderId;
	
	// private long productId;
	
	private long customerId;	
	 
	 private String customerName;	
	
	// private String paymentMode;	

	// private String billingAddress;	 
	 
	 private String deliveryAddr;	 
	 
	// private int orderQuantity;
	 
	// private long totalAmt;
	 
	 private String email;
	 private long phNumber;
	
	 private String status;

	// long millis=System.currentTimeMillis();  
	 //private Date orderDate = new java.sql.Date(millis);
	 //private String orderDate;
	public FundTransferRequest(){
		
	}
	
public FundTransferRequest(String value){
	 String value1= value;
		
	}
	
	public FundTransferRequest(Integer orderId,  long customerId,
			String customerName,String deliveryAddr,String email, long phNumber) {
		
		this.orderId = orderId;
	
		this.customerId = customerId;
		this.customerName = customerName;
		
		this.deliveryAddr = deliveryAddr;
		this.email= email;
		this.phNumber=phNumber;
	}

	@Override
	public String toString() {
		return "FundTransferRequest [orderId=" + orderId + ", customerId="
				+ customerId + ", customerName=" + customerName + ", deliveryAddr="
				+ deliveryAddr + ", email=" + email + ", phNumber=" + phNumber
				+ "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
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
	/*public long getProductId() {
		return productId;
	}

	*//**
	 * @param productId the productId to set
	 *//*
	public void setProductId(long productId) {
		this.productId = productId;
	}
*/
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
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param username the username to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the paymentMode
	 */
	/*public String getPaymentMode() {
		return paymentMode;
	}

	*//**
	 * @param paymentMode the paymentMode to set
	 *//*
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}*/

	/**
	 * @return the billingAddress
	 */
	/*public String getBillingAddress() {
		return billingAddress;
	}

	*//**
	 * @param billingAddress the billingAddress to set
	 *//*
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}*/

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
	/*public int getOrderQuantity() {
		return orderQuantity;
	}

	*//**
	 * @param orderQuantity the orderQuantity to set
	 *//*
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}*/

	/**
	 * @return the totalAmt
	 */
	/*public long getTotalAmt() {
		return totalAmt;
	}

	*//**
	 * @param totalAmt the totalAmt to set
	 *//*
	public void setTotalAmt(long totalAmt) {
		this.totalAmt = totalAmt;
	}*/

	/**
	 * @return the orderDate
	 */
	/*public String getOrderDate() {
		return orderDate;
	}

	*//**
	 * @param orderDate the orderDate to set
	 *//*
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
/*	@Override
	public String toString() {
		return "FundTransferRequest [orderId=" + orderId + ", productId="
				+ productId + ", customerId=" + customerId + ", username="
				+ username + ", paymentMode=" + paymentMode
				+ ", billingAddress=" + billingAddress + ", deliveryAddr="
				+ deliveryAddr + ", orderQuantity=" + orderQuantity
				+ ", totalAmt=" + totalAmt + ", orderDate=" + orderDate + "]";
	}*/

	
}
