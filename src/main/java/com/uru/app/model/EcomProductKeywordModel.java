package com.uru.app.model;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * @author Girish.Yadav
 *
 */
public class EcomProductKeywordModel {
	private String id;

	private String keyword;

	@JsonBackReference(value="product-keyword")
	private EcomProductModel ecomProduct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public EcomProductModel getEcomProduct() {
		return ecomProduct;
	}

	public void setEcomProduct(EcomProductModel ecomProduct) {
		this.ecomProduct = ecomProduct;
	}
	
}
