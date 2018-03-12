package com.uru.app.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonBackReference;

public class EcomPinCodeModel {
	
	private Long buyerId;

	private int buyerPincode;

	private String buyerHub;

	private String buyerState;

	private String buyerVillageName;

	private String buyerAreaDividion;

	private String buyerTaluka;

	private String buyerDistric;
	
	private long categoryId;
	
//	@JsonBackReference(value="pincode-catagory")
//	private EcomCatalogModel ecomCategory;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public int getBuyerPincode() {
		return buyerPincode;
	}

	public void setBuyerPincode(int buyerPincode) {
		this.buyerPincode = buyerPincode;
	}

	public String getBuyerHub() {
		return buyerHub;
	}

	public void setBuyerHub(String buyerHub) {
		this.buyerHub = buyerHub;
	}

	public String getBuyerState() {
		return buyerState;
	}

	public void setBuyerState(String buyerState) {
		this.buyerState = buyerState;
	}

	public String getBuyerVillageName() {
		return buyerVillageName;
	}

	public void setBuyerVillageName(String buyerVillageName) {
		this.buyerVillageName = buyerVillageName;
	}

	public String getBuyerAreaDividion() {
		return buyerAreaDividion;
	}

	public void setBuyerAreaDividion(String buyerAreaDividion) {
		this.buyerAreaDividion = buyerAreaDividion;
	}

	public String getBuyerTaluka() {
		return buyerTaluka;
	}

	public void setBuyerTaluka(String buyerTaluka) {
		this.buyerTaluka = buyerTaluka;
	}

	public String getBuyerDistric() {
		return buyerDistric;
	}

	public void setBuyerDistric(String buyerDistric) {
		this.buyerDistric = buyerDistric;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	
}
