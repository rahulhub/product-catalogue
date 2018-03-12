package com.uru.app.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import com.uru.app.entity.EcomItemMedia;

/**
 * @author Girish.Yadav
 *
 */
public class EcomItemModel {
	private Long sku;

	private Date creationDate;

	private String creator;

	private String detDisplayJspUrl;

	private String estimateShipTime;

	private int inStock;

	private String lang;

	private String longDesc;

	private Date modifiedDate;

	private BigInteger msrpAmount;

	private String msrpCurrency;

	private String name;

	private BigInteger priceAmount;

	private String priceCurrency;

	private String shippingCode;

	private String shortDesc;

	private String source;

	private String specialNotes;

	private String sumDisplayJspUrl;

	private String taxCode;

	private String type;

	private int visible;
	
	private String discount;
	
	private Integer minOrderQty=0;
	
	private Integer maxOrderQty=0;
	
	private Integer leadTime=0;
	
	private Integer exciseDuty=0;
	
	private Double taxAmount=0.0;
	 
	private Double taxRetailAmount=0.0;
	
	private Integer isDeleted=0;

	@JsonManagedReference(value="item-propertyValue")
	private List<CatalogPropertyValueModel> catalogPropertyValues;

	@JsonBackReference(value="product-item")
	private EcomProductModel ecomProduct;
	
	@JsonManagedReference(value="item-media")
	private List<EcomItemMediaModel> itemMediaList;

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate==null?new Date():creationDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDetDisplayJspUrl() {
		return detDisplayJspUrl;
	}

	public void setDetDisplayJspUrl(String detDisplayJspUrl) {
		this.detDisplayJspUrl = detDisplayJspUrl;
	}

	public String getEstimateShipTime() {
		return estimateShipTime;
	}

	public void setEstimateShipTime(String estimateShipTime) {
		this.estimateShipTime = estimateShipTime;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}


	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public BigInteger getMsrpAmount() {
		return msrpAmount;
	}

	public void setMsrpAmount(BigInteger msrpAmount) {
		this.msrpAmount = msrpAmount;
	}

	public String getMsrpCurrency() {
		return msrpCurrency;
	}

	public void setMsrpCurrency(String msrpCurrency) {
		this.msrpCurrency = msrpCurrency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getPriceAmount() {
		return priceAmount;
	}

	public void setPriceAmount(BigInteger priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSpecialNotes() {
		return specialNotes;
	}

	public void setSpecialNotes(String specialNotes) {
		this.specialNotes = specialNotes;
	}

	public String getSumDisplayJspUrl() {
		return sumDisplayJspUrl;
	}

	public void setSumDisplayJspUrl(String sumDisplayJspUrl) {
		this.sumDisplayJspUrl = sumDisplayJspUrl;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	public List<CatalogPropertyValueModel> getCatalogPropertyValues() {
		return catalogPropertyValues;
	}

	public void setCatalogPropertyValues(
			List<CatalogPropertyValueModel> catalogPropertyValues) {
		this.catalogPropertyValues = catalogPropertyValues;
	}

	public EcomProductModel getEcomProduct() {
		return ecomProduct;
	}

	public void setEcomProduct(EcomProductModel ecomProduct) {
		this.ecomProduct = ecomProduct;
	}

	/**
	 * @return the itemMediaList
	 */
	public List<EcomItemMediaModel> getItemMediaList() {
		return itemMediaList;
	}

	/**
	 * @param itemMediaList the itemMediaList to set
	 */
	public void setItemMediaList(List<EcomItemMediaModel> itemMediaList) {
		this.itemMediaList = itemMediaList;
	}

	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Integer getMinOrderQty() {
		return minOrderQty;
	}

	public void setMinOrderQty(Integer minOrderQty) {
		this.minOrderQty = minOrderQty==null?0:minOrderQty;
	}

	public Integer getMaxOrderQty() {
		return maxOrderQty;
	}

	public void setMaxOrderQty(Integer maxOrderQty) {
		this.maxOrderQty = maxOrderQty==null?0:maxOrderQty;
	}

	public Integer getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime==null?0:leadTime;
	}

	public Integer getExciseDuty() {
		return exciseDuty;
	}

	public void setExciseDuty(Integer exciseDuty) {
		this.exciseDuty = exciseDuty==null?0:exciseDuty;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount==null?0.0:taxAmount;
	}

	public Double getTaxRetailAmount() {
		return taxRetailAmount;
	}

	public void setTaxRetailAmount(Double taxRetailAmount) {
		this.taxRetailAmount = taxRetailAmount==null?0:taxRetailAmount;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted==null?0:isDeleted;
	}

	
	
}
