package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;


/**
 * The persistent class for the ecom_order_line database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomOrderLine")
@Table(name="ecom_order_line")
@NamedQueries({
@NamedQuery(name="EcomOrderLine.findAll", query="SELECT e FROM EcomOrderLine e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomOrderLine.findById", query="SELECT e FROM EcomOrderLine e WHERE e.orderLineId=:n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),})
public class EcomOrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_LINE_ID")
	private Long orderLineId;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="MSRP_AMOUNT")
	private double msrpAmount;

	@Column(name="MSRP_CURRENCY")
	private String msrpCurrency;

	@Column(name="QUANTITY")
	private int quantity;

	@Column(name="SHIPPING_AMOUNT")
	private double shippingAmount;

	@Column(name="SHIPPING_CURRENCY")
	private String shippingCurrency;

	@Column(name="SKU")
	private String sku;

	@Column(name="TAX_AMOUNT")
	private double taxAmount;

	@Column(name="TAX_CURRENCY")
	private String taxCurrency;

	@Column(name="UNIT_PRICE_AMOUNT")
	private double unitPriceAmount;

	@Column(name="UNIT_PRICE_CURRENCY")
	private String unitPriceCurrency;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DISCOUNT_PERCENTAGE")
	private Integer discount=0;
	
	@Column(name="DISCOUNT_PRICE")
	private Double discountPrice=0.0;
	
	@Column(name="CALCULATED_AMOUNT")
	private Double calculatedAmount=0.0;

	//bi-directional many-to-one association to EcomOrder
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private EcomOrder ecomOrder;

	public EcomOrderLine() {
	}

	public Long getOrderLineId() {
		return this.orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMsrpAmount() {
		return this.msrpAmount;
	}

	public void setMsrpAmount(double msrpAmount) {
		this.msrpAmount = msrpAmount;
	}

	public String getMsrpCurrency() {
		return this.msrpCurrency;
	}

	public void setMsrpCurrency(String msrpCurrency) {
		this.msrpCurrency = msrpCurrency;
	}

	public double getShippingAmount() {
		return this.shippingAmount;
	}

	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public String getShippingCurrency() {
		return this.shippingCurrency;
	}

	public void setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxCurrency() {
		return this.taxCurrency;
	}

	public void setTaxCurrency(String taxCurrency) {
		this.taxCurrency = taxCurrency;
	}

	public double getUnitPriceAmount() {
		return this.unitPriceAmount;
	}

	public void setUnitPriceAmount(double unitPriceAmount) {
		this.unitPriceAmount = unitPriceAmount;
	}

	public String getUnitPriceCurrency() {
		return this.unitPriceCurrency;
	}

	public void setUnitPriceCurrency(String unitPriceCurrency) {
		this.unitPriceCurrency = unitPriceCurrency;
	}

	public EcomOrder getEcomOrder() {
		return this.ecomOrder;
	}

	public void setEcomOrder(EcomOrder ecomOrder) {
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