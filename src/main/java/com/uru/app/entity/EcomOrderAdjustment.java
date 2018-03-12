package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the ecom_order_adjustment database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomOrderAdjustment")
@Table(name="ecom_order_adjustment")
@NamedQuery(name="EcomOrderAdjustment.findAll", query="SELECT e FROM EcomOrderAdjustment e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class EcomOrderAdjustment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ADJUSTMENT_ID")
	private Long orderAdjustmentId;

	@Column(name="ADJUSTMENT_AMOUNT")
	private double adjustmentAmount;

	@Column(name="ADJUSTMENT_TYPE")
	private String adjustmentType;

	@Column(name="COMPUTATION")
	private String computation;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="DISCOUNT_ID")
	private BigInteger discountId;

	@Column(name="DISPLAY_DESCRIPTION")
	private String displayDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	//bi-directional many-to-one association to EcomOrder
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private EcomOrder ecomOrder;

	public EcomOrderAdjustment() {
	}

	public Long getOrderAdjustmentId() {
		return this.orderAdjustmentId;
	}

	public void setOrderAdjustmentId(Long orderAdjustmentId) {
		this.orderAdjustmentId = orderAdjustmentId;
	}

	public double getAdjustmentAmount() {
		return this.adjustmentAmount;
	}

	public void setAdjustmentAmount(double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public String getAdjustmentType() {
		return this.adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public String getComputation() {
		return this.computation;
	}

	public void setComputation(String computation) {
		this.computation = computation;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BigInteger getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(BigInteger discountId) {
		this.discountId = discountId;
	}

	public String getDisplayDescription() {
		return this.displayDescription;
	}

	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public EcomOrder getEcomOrder() {
		return this.ecomOrder;
	}

	public void setEcomOrder(EcomOrder ecomOrder) {
		this.ecomOrder = ecomOrder;
	}

}