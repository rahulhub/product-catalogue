package com.uru.app.model;

import java.util.Date;

public class EcomPaymentModel {
	
	private Long id;
	
	private String transactionId;
	
	private String type;
	
	private String tranEntryStatus;
	
	private String transactionAmount;
	
	private String imageUrl;
	
	private String bankName;
	
	private String ifscCode;
	
	private EcomOrderModel ecomOrder;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private String createdBy;
	
	private String modifiedBy;
	
	//private Long version;

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the tranEntryStatus
	 */
	public String getTranEntryStatus() {
		return tranEntryStatus;
	}

	/**
	 * @param tranEntryStatus the tranEntryStatus to set
	 */
	public void setTranEntryStatus(String tranEntryStatus) {
		this.tranEntryStatus = tranEntryStatus;
	}

	/**
	 * @return the ecomOrder
	 */
	public EcomOrderModel getEcomOrder() {
		return ecomOrder;
	}

	/**
	 * @param ecomOrder the ecomOrder to set
	 */
	public void setEcomOrder(EcomOrderModel ecomOrder) {
		this.ecomOrder = ecomOrder;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

//	public Long getVersion() {
//		return version;
//	}
//
//	public void setVersion(Long version) {
//		this.version = version;
//	}
	
	
	
	
	
}
