package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ecom_order database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomOrder")
@Table(name="ecom_order")
@NamedQueries(value={
		@NamedQuery(name="EcomOrder.findAll", query="SELECT e FROM EcomOrder e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
		@NamedQuery(name="EcomOrder.findOrderForCustomer", query="SELECT e FROM EcomOrder e WHERE e.ecomCustomer.customerId=:n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
		@NamedQuery(name="EcomOrder.findOrderForCustomerNStatus", query="SELECT e FROM EcomOrder e WHERE e.ecomCustomer.customerId=:n AND e.status=:m", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
		@NamedQuery(name="EcomOrder.findOrderForStatus", query="SELECT e FROM EcomOrder e WHERE e.status=:s", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
		
})
public class EcomOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private Long orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_DATE")
	private Date orderDate;

	@Column(name="ORDER_SUBTOTAL")
	private double orderSubtotal;

	@Column(name="PRICE_AMOUNT")
	private double priceAmount;

	@Column(name="PRICE_CURRENCY")
	private String priceCurrency;

	@Column(name="SHIPPING_AMOUNT")
	private double shippingAmount;

	@Column(name="SHIPPING_CITY")
	private String shippingCity;

	@Column(name="SHIPPING_COUNTRY")
	private String shippingCountry;

	@Column(name="SHIPPING_CURRENCY")
	private String shippingCurrency;

	@Column(name="SHIPPING_GEOGODE")
	private String shippingGeogode;

	@Column(name="SHIPPING_METHOD")
	private String shippingMethod;

	@Column(name="SHIPPING_POBOX")
	private String shippingPobox;

	@Column(name="SHIPPING_POSTAL_CODE")
	private String shippingPostalCode;

	@Column(name="SHIPPING_STATE")
	private String shippingState;

	@Column(name="SHIPPING_STREET1")
	private String shippingStreet1;

	@Column(name="SHIPPING_STREET2")
	private String shippingStreet2;

	@Column(name="SPECIAL_INSTRUCTIONS")
	private String specialInstructions;

	@Column(name="SPLITTING_PREFERENCE")
	private String splittingPreference;

	@Column(name="STATUS")
	private String status;
	
	@Column(name="LONG_DESC")
	private String longDesc;

	@Column(name="MSRP_AMOUNT")
	private Double msrpAmount=0.0;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SHORT_DESC")
	private String shortDesc;
	
	@Column(name="TAX_CODE")
	private Integer taxCode=0;
	
	@Column(name="SKU")
	private Long skuId;
	
	@Column(name="DISCOUNT_PERCENTAGE")
	private Integer discount=0;
	
	@Column(name="QUANTITY")
	private Integer quantity=0;
	
	@Column(name="DISCOUNT_PRICE")
	private Double discountPrice=0.0;
	
	@Column(name="order_type")
	private String orderType;

	//bi-directional many-to-one association to EcomCustomer
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private EcomCustomer ecomCustomer;

	//bi-directional many-to-one association to EcomTransaction
//	@ManyToOne
//	@JoinColumn(name="TRANSACTION_ID")
//	private EcomTransaction ecomTransaction;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomOrder",cascade={CascadeType.ALL})
	private List<EcomPayment> paymentDetails;
	
	@Column(name="payment_mode")
	private String paymentMode;

	//bi-directional many-to-one association to EcomOrderAdjustment
//	@OneToMany(mappedBy="ecomOrder")
//	private List<EcomOrderAdjustment> ecomOrderAdjustments;

	//bi-directional many-to-one association to EcomOrderLine
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomOrder",cascade={CascadeType.ALL})
	private List<EcomOrderLine> ecomOrderLines;
	
	@Column(name="json_data",length = 4000)
	private String jsonData;

	public EcomOrder() {
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate==null?new Date():orderDate;
	}

	public double getOrderSubtotal() {
		return this.orderSubtotal;
	}

	public void setOrderSubtotal(double orderSubtotal) {
		this.orderSubtotal = orderSubtotal;
	}

	public double getPriceAmount() {
		return this.priceAmount;
	}

	public void setPriceAmount(double priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getPriceCurrency() {
		return this.priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public double getShippingAmount() {
		return this.shippingAmount;
	}

	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public String getShippingCity() {
		return this.shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingCountry() {
		return this.shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingCurrency() {
		return this.shippingCurrency;
	}

	public void setShippingCurrency(String shippingCurrency) {
		this.shippingCurrency = shippingCurrency;
	}

	public String getShippingGeogode() {
		return this.shippingGeogode;
	}

	public void setShippingGeogode(String shippingGeogode) {
		this.shippingGeogode = shippingGeogode;
	}

	public String getShippingMethod() {
		return this.shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShippingPobox() {
		return this.shippingPobox;
	}

	public void setShippingPobox(String shippingPobox) {
		this.shippingPobox = shippingPobox;
	}

	public String getShippingPostalCode() {
		return this.shippingPostalCode;
	}

	public void setShippingPostalCode(String shippingPostalCode) {
		this.shippingPostalCode = shippingPostalCode;
	}

	public String getShippingState() {
		return this.shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingStreet1() {
		return this.shippingStreet1;
	}

	public void setShippingStreet1(String shippingStreet1) {
		this.shippingStreet1 = shippingStreet1;
	}

	public String getShippingStreet2() {
		return this.shippingStreet2;
	}

	public void setShippingStreet2(String shippingStreet2) {
		this.shippingStreet2 = shippingStreet2;
	}

	public String getSpecialInstructions() {
		return this.specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public String getSplittingPreference() {
		return this.splittingPreference;
	}

	public void setSplittingPreference(String splittingPreference) {
		this.splittingPreference = splittingPreference;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EcomCustomer getEcomCustomer() {
		return this.ecomCustomer;
	}

	public void setEcomCustomer(EcomCustomer ecomCustomer) {
		this.ecomCustomer = ecomCustomer;
	}

//	public EcomTransaction getEcomTransaction() {
//		return this.ecomTransaction;
//	}
//
//	public void setEcomTransaction(EcomTransaction ecomTransaction) {
//		this.ecomTransaction = ecomTransaction;
//	}

//	public List<EcomOrderAdjustment> getEcomOrderAdjustments() {
//		return this.ecomOrderAdjustments;
//	}
//
//	public void setEcomOrderAdjustments(List<EcomOrderAdjustment> ecomOrderAdjustments) {
//		this.ecomOrderAdjustments = ecomOrderAdjustments;
//	}

//	public EcomOrderAdjustment addEcomOrderAdjustment(EcomOrderAdjustment ecomOrderAdjustment) {
//		getEcomOrderAdjustments().add(ecomOrderAdjustment);
//		ecomOrderAdjustment.setEcomOrder(this);
//
//		return ecomOrderAdjustment;
//	}
//
//	public EcomOrderAdjustment removeEcomOrderAdjustment(EcomOrderAdjustment ecomOrderAdjustment) {
//		getEcomOrderAdjustments().remove(ecomOrderAdjustment);
//		ecomOrderAdjustment.setEcomOrder(null);
//
//		return ecomOrderAdjustment;
//	}

	public List<EcomOrderLine> getEcomOrderLines() {
		return this.ecomOrderLines;
	}

	public void setEcomOrderLines(List<EcomOrderLine> ecomOrderLines) {
		this.ecomOrderLines = ecomOrderLines;
	}

	public EcomOrderLine addEcomOrderLine(EcomOrderLine ecomOrderLine) {
		getEcomOrderLines().add(ecomOrderLine);
		ecomOrderLine.setEcomOrder(this);

		return ecomOrderLine;
	}

	public EcomOrderLine removeEcomOrderLine(EcomOrderLine ecomOrderLine) {
		getEcomOrderLines().remove(ecomOrderLine);
		ecomOrderLine.setEcomOrder(null);

		return ecomOrderLine;
	}

	/**
	 * @return the transactionId
	 */
	public List<EcomPayment> getTransactionId() {
		return paymentDetails;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(List<EcomPayment> paymentDetails) {
		this.paymentDetails = paymentDetails;
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

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the paymentDetails
	 */
	public List<EcomPayment> getPaymentDetails() {
		return paymentDetails;
	}

	/**
	 * @param paymentDetails the paymentDetails to set
	 */
	public void setPaymentDetails(List<EcomPayment> paymentDetails) {
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