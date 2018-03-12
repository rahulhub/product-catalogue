package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the ecom_order_line_adjustment database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomOrderLineAdjustment")
@Table(name="ecom_order_line_adjustment")
@NamedQuery(name="EcomOrderLineAdjustment.findAll", query="SELECT e FROM EcomOrderLineAdjustment e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class EcomOrderLineAdjustment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_LINE_ADJUSTMENT_ID")
	private Long orderLineAdjustmentId;

	@Column(name="ADJUSTED_UNIT_PRICE")
	private double adjustedUnitPrice;

	@Column(name="ADJUSTMENT_AMOUNT")
	private double adjustmentAmount;

	@Column(name="ADJUSTMENT_QUANTITY")
	private double adjustmentQuantity;

	@Column(name="ADJUSTMENT_TYPE")
	private String adjustmentType;

	@Column(name="COMPUTATION")
	private String computation;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="DISPLAY_DESCRIPTION")
	private String displayDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="ORDER_LINE_ID")
	private BigInteger orderLineId;

	//bi-directional many-to-one association to Discount
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="DISCOUNT_ID")
	private Discount discount;

	public EcomOrderLineAdjustment() {
	}

	public Long getOrderLineAdjustmentId() {
		return this.orderLineAdjustmentId;
	}

	public void setOrderLineAdjustmentId(Long orderLineAdjustmentId) {
		this.orderLineAdjustmentId = orderLineAdjustmentId;
	}

	public double getAdjustedUnitPrice() {
		return this.adjustedUnitPrice;
	}

	public void setAdjustedUnitPrice(double adjustedUnitPrice) {
		this.adjustedUnitPrice = adjustedUnitPrice;
	}

	public double getAdjustmentAmount() {
		return this.adjustmentAmount;
	}

	public void setAdjustmentAmount(double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public double getAdjustmentQuantity() {
		return this.adjustmentQuantity;
	}

	public void setAdjustmentQuantity(double adjustmentQuantity) {
		this.adjustmentQuantity = adjustmentQuantity;
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

	public BigInteger getOrderLineId() {
		return this.orderLineId;
	}

	public void setOrderLineId(BigInteger orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}