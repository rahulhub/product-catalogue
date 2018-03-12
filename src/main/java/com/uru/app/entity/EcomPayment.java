package com.uru.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="ecom_payments")
@NamedQuery(name="EcomPayment.findById", query="SELECT pay from EcomPayment pay where pay.id=:n",hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class EcomPayment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="TRASACTION_ID")
	private String transactionId;
	
	@Column(name="PAYMENT_TYPE")
	private String type;
	
	@Column(name="PAYMENT_STATUS")
	private String tranEntryStatus;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private EcomOrder ecomOrder;
	
    @Column(name="AMOUNT")
    private String transactionAmount;
    
    @Column(name="IMAGE_URL")
    private String imageUrl;
    
    @Column(name="BANK_NAME")
    private String bankName;
    
    @Column(name="BANK_IFSC")
    private String ifscCode;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@Column(name = "created_by", nullable = true)
	private String createdBy;
	
	@Column(name = "modified_by", nullable = true)
	private String modifiedBy;

//	@Version
//	private Long version;
	
	@PreUpdate
	public void setDefaultUpdates() {
		this.setModifiedDate(new Date());
	}

	@PrePersist
	public void setDefaultPersist() {
		this.setCreatedDate(new Date());
		this.setModifiedDate(new Date());
	}


	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

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
	public EcomOrder getEcomOrder() {
		return ecomOrder;
	}
	
	/**
	 * @param ecomOrder the ecomOrder to set
	 */
	public void setEcomOrder(EcomOrder ecomOrder) {
		this.ecomOrder = ecomOrder;
	}

	/**
	 * @return the transactionAmount
	 */
	public String getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
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
