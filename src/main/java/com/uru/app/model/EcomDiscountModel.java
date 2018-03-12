package com.uru.app.model;

import java.util.Date;
import java.util.List;

/**
 * @author Girish.Yadav
 *
 */
public class EcomDiscountModel {
	private Long discountId;

	private int allowedUsers;

	private String description;

	private String discountName;

	private byte[] discountRule;

	private String discountType;

	private String displayDescription;

	private Date endDate;

	private int isActive;

	private int isGlobal;

	private String modifier;

	private int priority;

	private Date startDate;

	private EcomDiscountSetModel discountSet;

	private List<EcomOrderLineAdjustmentModel> ecomOrderLineAdjustments;

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public int getAllowedUsers() {
		return allowedUsers;
	}

	public void setAllowedUsers(int allowedUsers) {
		this.allowedUsers = allowedUsers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public byte[] getDiscountRule() {
		return discountRule;
	}

	public void setDiscountRule(byte[] discountRule) {
		this.discountRule = discountRule;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDisplayDescription() {
		return displayDescription;
	}

	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsGlobal() {
		return isGlobal;
	}

	public void setIsGlobal(int isGlobal) {
		this.isGlobal = isGlobal;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public EcomDiscountSetModel getDiscountSet() {
		return discountSet;
	}

	public void setDiscountSet(EcomDiscountSetModel discountSet) {
		this.discountSet = discountSet;
	}

	public List<EcomOrderLineAdjustmentModel> getEcomOrderLineAdjustments() {
		return ecomOrderLineAdjustments;
	}

	public void setEcomOrderLineAdjustments(
			List<EcomOrderLineAdjustmentModel> ecomOrderLineAdjustments) {
		this.ecomOrderLineAdjustments = ecomOrderLineAdjustments;
	}
	
	
}
