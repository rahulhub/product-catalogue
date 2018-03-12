package com.uru.app.model;

/**
 * @author Girish.Yadav
 *
 */
public class EcomDiscountAssociationModel {
	private Long discountAssociationId;

	private String displayDescription;

	private int useCount;

	private EcomDiscountSetModel discountSet;	

	private EcomCustomerModel ecomCustomer;

	public Long getDiscountAssociationId() {
		return discountAssociationId;
	}

	public void setDiscountAssociationId(Long discountAssociationId) {
		this.discountAssociationId = discountAssociationId;
	}

	public String getDisplayDescription() {
		return displayDescription;
	}

	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}

	public int getUseCount() {
		return useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

	public EcomDiscountSetModel getDiscountSet1() {
		return discountSet;
	}

	public void setDiscountSet1(EcomDiscountSetModel discountSet) {
		this.discountSet = discountSet;
	}	

	public EcomCustomerModel getEcomCustomer() {
		return ecomCustomer;
	}

	public void setEcomCustomer(EcomCustomerModel ecomCustomer) {
		this.ecomCustomer = ecomCustomer;
	}
	
	
}
