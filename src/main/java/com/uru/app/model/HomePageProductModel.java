package com.uru.app.model;

import com.uru.app.entity.EcomProduct;

public class HomePageProductModel {

	private Long hpproductId;
	private EcomProductModel hpProduct;
	
	private Long categoryId;

	public Long getHpproductId() {
		return hpproductId;
	}

	public void setHpproductId(Long hpproductId) {
		this.hpproductId = hpproductId;
	}

	public EcomProductModel getHpProduct() {
		return hpProduct;
	}

	public void setHpProduct(EcomProductModel hpProduct) {
		this.hpProduct = hpProduct;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	

}
