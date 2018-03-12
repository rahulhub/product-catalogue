package com.uru.app.model;

import java.util.List;

/**
 * @author Girish.Yadav
 *
 */
public class EcomDiscountSetModel {
	private Long discountSetId;

	private String discountSetName;

	private byte[] xmlDefinition;

	private List<EcomDiscountModel> discounts;

	private List<EcomDiscountAssociationModel> discountAssociations1;

	private List<EcomDiscountAssociationModel> discountAssociations2;

	public Long getDiscountSetId() {
		return discountSetId;
	}

	public void setDiscountSetId(Long discountSetId) {
		this.discountSetId = discountSetId;
	}

	public String getDiscountSetName() {
		return discountSetName;
	}

	public void setDiscountSetName(String discountSetName) {
		this.discountSetName = discountSetName;
	}

	public byte[] getXmlDefinition() {
		return xmlDefinition;
	}

	public void setXmlDefinition(byte[] xmlDefinition) {
		this.xmlDefinition = xmlDefinition;
	}

	public List<EcomDiscountModel> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<EcomDiscountModel> discounts) {
		this.discounts = discounts;
	}

	public List<EcomDiscountAssociationModel> getDiscountAssociations1() {
		return discountAssociations1;
	}

	public void setDiscountAssociations1(
			List<EcomDiscountAssociationModel> discountAssociations1) {
		this.discountAssociations1 = discountAssociations1;
	}

	public List<EcomDiscountAssociationModel> getDiscountAssociations2() {
		return discountAssociations2;
	}

	public void setDiscountAssociations2(
			List<EcomDiscountAssociationModel> discountAssociations2) {
		this.discountAssociations2 = discountAssociations2;
	}
	
	
}
