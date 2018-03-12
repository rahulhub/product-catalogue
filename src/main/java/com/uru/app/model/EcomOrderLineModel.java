package com.uru.app.model;

import javax.persistence.Column;

/**
 * @author Girish.Yadav
 *
 */
public class EcomOrderLineModel {
	private Long orderLineId;

	private String description;

	private double msrpAmount;

	private String msrpCurrency;

	private int quantity;

	private double shippingAmount;

	private String shippingCurrency;

	private String sku;

	private double taxAmount;

	private String taxCurrency;

	private double unitPriceAmount;

	private String unitPriceCurrency;

	private EcomOrderModel ecomOrder;
	
	private String status;
	
	private Integer discount=0;
	
	private Double discountPrice=0.0;
	
	private Double calculatedAmount=0.0;

	public Long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMsrpAmount() {
		return msrpAmount;
	}

	public void setMsrpAmount(double msrpAmount) {
		this.msrpAmount = msrpAmount;
	}

	public String getMsrpCurrency() {
		return msrpCurrency;
	}

	public void setMsrpCurrency(String msrpCurrency) {
		this.msrpCurrency = msrpCurrency;
	}

	public double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public String getShippingCurrency() {
		return shippingCurrency;
	}

	public void setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxCurrency() {
		return taxCurrency;
	}

	public void setTaxCurrency(String taxCurrency) {
		this.taxCurrency = taxCurrency;
	}

	public double getUnitPriceAmount() {
		return unitPriceAmount;
	}

	public void setUnitPriceAmount(double unitPriceAmount) {
		this.unitPriceAmount = unitPriceAmount;
	}

	public String getUnitPriceCurrency() {
		return unitPriceCurrency;
	}

	public void setUnitPriceCurrency(String unitPriceCurrency) {
		this.unitPriceCurrency = unitPriceCurrency;
	}

	public EcomOrderModel getEcomOrder() {
		return ecomOrder;
	}

	public void setEcomOrder(EcomOrderModel ecomOrder) {
		this.ecomOrder = ecomOrder;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(Double calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
}
