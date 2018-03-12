package com.uru.app.model;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Girish.Yadav
 *
 */
public class EcomOrderAdjustmentModel {
	private String orderAdjustmentId;

	private double adjustmentAmount;

	private String adjustmentType;

	private String computation;

	private Date creationDate;

	private BigInteger discountId;

	private String displayDescription;

	private Date modifiedDate;

	private EcomOrderModel ecomOrder;

	public String getOrderAdjustmentId() {
		return orderAdjustmentId;
	}

	public void setOrderAdjustmentId(String orderAdjustmentId) {
		this.orderAdjustmentId = orderAdjustmentId;
	}

	public double getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
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

	public BigInteger getDiscountId() {
		return discountId;
	}

	public void setDiscountId(BigInteger discountId) {
		this.discountId = discountId;
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

	public EcomOrderModel getEcomOrder() {
		return ecomOrder;
	}

	public void setEcomOrder(EcomOrderModel ecomOrder) {
		this.ecomOrder = ecomOrder;
	}
	
	
}
