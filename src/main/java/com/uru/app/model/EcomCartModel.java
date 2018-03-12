package com.uru.app.model;

/**
 * @author Rahul Dev
 *
 */
public class EcomCartModel {
	private Long id;

	private Long custId;
	
	private Long sku;
	
	private Long qty;
	
	private String json_data;
	
	private String rootCategory;
	
	private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the custId
	 */
	public Long getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(Long custId) {
		this.custId = custId;
	}

	/**
	 * @return the sku
	 */
	public Long getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(Long sku) {
		this.sku = sku;
	}

	/**
	 * @return the qty
	 */
	public Long getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(Long qty) {
		this.qty = qty;
	}

	/**
	 * @return the json_data
	 */
	public String getJson_data() {
		return json_data;
	}

	/**
	 * @param json_data the json_data to set
	 */
	public void setJson_data(String json_data) {
		this.json_data = json_data;
	}

	public String getRootCategory() {
		return rootCategory;
	}

	public void setRootCategory(String rootCategory) {
		this.rootCategory = rootCategory;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
