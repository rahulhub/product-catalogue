package com.uru.app.model;


public class CategoryRates {
	
	private Long categoryId;
	private double tBaseRate;
	
	private double tCutRate;
	
	private double specGravity;
	
	private double minDimension;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public double gettBaseRate() {
		return tBaseRate;
	}

	public void settBaseRate(double tBaseRate) {
		this.tBaseRate = tBaseRate;
	}

	public double gettCutRate() {
		return tCutRate;
	}

	public void settCutRate(double tCutRate) {
		this.tCutRate = tCutRate;
	}

	public double getSpecGravity() {
		return specGravity;
	}

	public void setSpecGravity(double specGravity) {
		this.specGravity = specGravity;
	}

	public double getMinDimension() {
		return minDimension;
	}

	public void setMinDimension(double minDimension) {
		this.minDimension = minDimension;
	}
	
	

}
