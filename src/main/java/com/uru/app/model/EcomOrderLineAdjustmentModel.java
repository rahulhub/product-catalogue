package com.uru.app.model;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Girish.Yadav
 *
 */
public class EcomOrderLineAdjustmentModel {
	private String orderLineAdjustmentId;

	private double adjustedUnitPrice;

	private double adjustmentAmount;

	private double adjustmentQuantity;

	private String adjustmentType;

	private String computation;

	private Date creationDate;

	private String displayDescription;

	private Date modifiedDate;

	private BigInteger orderLineId;

	private EcomDiscountModel discount;

	public String getOrderLineAdjustmentId() {
		return orderLineAdjustmentId;
	}

	public void setOrderLineAdjustmentId(String orderLineAdjustmentId) {
		this.orderLineAdjustmentId = orderLineAdjustmentId;
	}

	public double getAdjustedUnitPrice() {
		return adjustedUnitPrice;
	}

	public void setAdjustedUnitPrice(double adjustedUnitPrice) {
		this.adjustedUnitPrice = adjustedUnitPrice;
	}

	public double getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public double getAdjustmentQuantity() {
		return adjustmentQuantity;
	}

	public void setAdjustmentQuantity(double adjustmentQuantity) {
		this.adjustmentQuantity = adjustmentQuantity;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public String getComputation() {
		return computation;
	}

	public void setComputation(String computation) {
		this.computation = computation;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDisplayDescription() {
		return displayDescription;
	}

	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public BigInteger getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(BigInteger orderLineId) {
		this.orderLineId = orderLineId;
	}

	public EcomDiscountModel getDiscount() {
		return discount;
	}

	public void setDiscount(EcomDiscountModel discount) {
		this.discount = discount;
	}
	
	
	
	
}
