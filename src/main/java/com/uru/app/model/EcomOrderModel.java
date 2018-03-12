package com.uru.app.model;

import java.util.Date;
import java.util.List;

import com.uru.app.entity.EcomPayment;

/**
 * @author Girish.Yadav
 *
 */
public class EcomOrderModel {
	private Long orderId;

	private Date orderDate;

	private double orderSubtotal;

	private double priceAmount;

	private String priceCurrency;

	private double shippingAmount;

	private String shippingCity;

	private String shippingCountry;

	private String shippingCurrency;

	private String shippingGeogode;

	private String shippingMethod;

	private String shippingPobox;

	private String shippingPostalCode;

	private String shippingState;

	private String shippingStreet1;

	private String shippingStreet2;

	private String specialInstructions;

	private String splittingPreference;

	private String status;
	
	private Long skuId;
	
	private String longDesc;
	
	private Double msrpAmount=0.0;
	
	private String name;
	
	private String shortDesc;
	
	private Integer taxCode=0;
	
	private Integer discount=0;
	
	private Integer quantity=0;
	
	private Double discountPrice=0.0;

	private EcomCustomerModel ecomCustomer;

//	private EcomTransactionModel ecomTransaction;
	
	private List<EcomPaymentModel> paymentDetails;

//	private List<EcomOrderAdjustmentModel> ecomOrderAdjustments;
	
	private List<EcomOrderLineModel> ecomOrderLines;
	
	private String jsonData;
	
	private String orderType;
	
	private String paymentMode;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate==null?new Date():orderDate;
	}

	public double getOrderSubtotal() {
		return orderSubtotal;
	}

	public void setOrderSubtotal(double orderSubtotal) {
		this.orderSubtotal = orderSubtotal;
	}

	public double getPriceAmount() {
		return priceAmount;
	}

	public void setPriceAmount(double priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingCurrency() {
		return shippingCurrency;
	}

	public void setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
	}

	public String getShippingGeogode() {
		return shippingGeogode;
	}

	public void setShippingGeogode(String shippingGeogode) {
		this.shippingGeogode = shippingGeogode;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShippingPobox() {
		return shippingPobox;
	}

	public void setShippingPobox(String shippingPobox) {
		this.shippingPobox = shippingPobox;
	}

	public String getShippingPostalCode() {
		return shippingPostalCode;
	}

	public void setShippingPostalCode(String shippingPostalCode) {
		this.shippingPostalCode = shippingPostalCode;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingStreet1() {
		return shippingStreet1;
	}

	public void setShippingStreet1(String shippingStreet1) {
		this.shippingStreet1 = shippingStreet1;
	}

	public String getShippingStreet2() {
		return shippingStreet2;
	}

	public void setShippingStreet2(String shippingStreet2) {
		this.shippingStreet2 = shippingStreet2;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public String getSplittingPreference() {
		return splittingPreference;
	}

	public void setSplittingPreference(String splittingPreference) {
		this.splittingPreference = splittingPreference;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EcomCustomerModel getEcomCustomer() {
		return ecomCustomer;
	}

	public void setEcomCustomer(EcomCustomerModel ecomCustomer) {
		this.ecomCustomer = ecomCustomer;
	}

//	public EcomTransactionModel getEcomTransaction() {
//		return ecomTransaction;
//	}
//
//	public void setEcomTransaction(EcomTransactionModel ecomTransaction) {
//		this.ecomTransaction = ecomTransaction;
//	}

//	public List<EcomOrderAdjustmentModel> getEcomOrderAdjustments() {
//		return ecomOrderAdjustments;
//	}
//
//	public void setEcomOrderAdjustments(
//			List<EcomOrderAdjustmentModel> ecomOrderAdjustments) {
//		this.ecomOrderAdjustments = ecomOrderAdjustments;
//	}

	public List<EcomOrderLineModel> getEcomOrderLines() {
		return ecomOrderLines;
	}

	public void setEcomOrderLines(List<EcomOrderLineModel> ecomOrderLines) {
		this.ecomOrderLines = ecomOrderLines;
	}


	/**
	 * @return the jsonData
	 */
	public String getJsonData() {
		return jsonData;
	}

	/**
	 * @param jsonData the jsonData to set
	 */
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the paymentDetails
	 */
	public List<EcomPaymentModel> getPaymentDetails() {
		return paymentDetails;
	}

	/**
	 * @param paymentDetails the paymentDetails to set
	 */
	public void setPaymentDetails(List<EcomPaymentModel> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public Double getMsrpAmount() {
		return msrpAmount;
	}

	public void setMsrpAmount(Double msrpAmount) {
		this.msrpAmount = msrpAmount==null?0.0:msrpAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Integer getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(Integer taxCode) {
		this.taxCode = taxCode==null?0:taxCode;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount==null?0:discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity==null?0:quantity;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice==null?0.0:discountPrice;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	
	
	
	
}
