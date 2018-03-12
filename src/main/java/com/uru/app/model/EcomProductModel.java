package com.uru.app.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * @author Girish.Yadav
 *
 */
public class EcomProductModel {
	private Long productId;

	private Date creationDate;

	private String creator;

	private String detDisplayJspUrl;

	private String estimateShipTime;

	private int inStock;

	private String lang;

	private String largeImgAltText;

	private String largeImgLang;

	private String largeImgName;

	private int largeImgType;

	private String largeImgUrl;

	private String longDesc;

	private Date modifiedDate;

	private BigInteger msrpAmount;

	private String msrpCurrency;

	private String name;

	private BigInteger priceAmount;

	private String priceCurrency;

	private String shippingCode;

	private String shortDesc;

	private String smallImgAltText;

	private String smallImgLang;

	private String smallImgName;

	private int smallImgType;

	private String smallImgUrl;

	private String source;

	private String specialNotes;

	private String sumDisplayJspUrl;

	private double taxCode;

	private String type;

	private int visible;
	
	private String calcTemplate;
	
	private String discount;
	
	private Integer exciseDuty=0;
	
	private Double taxAmount=0.0;
	 
	private Double taxRetailAmount=0.0;
	
	private Integer minOrderQty=0;
	
	private Integer maxOrderQty=0;
	
	private Integer leadTime=0;
	
	private Integer isDeleted=0;
	
	private Integer estock=0;

	@JsonManagedReference(value="product-item")
	private List<EcomItemModel> ecomItems;

	@JsonBackReference(value="product-catagory")
	private EcomCatalogModel ecomCategory;

	@JsonManagedReference(value="product-keyword")
	private List<EcomProductKeywordModel> ecomProductKeywords;
	
	private String metalForm;
	
	private String rootCategory;

	private IziWearDataModel iziWearData;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getLargeImgAltText() {
		return largeImgAltText;
	}

	public void setLargeImgAltText(String largeImgAltText) {
		this.largeImgAltText = largeImgAltText;
	}

	public String getLargeImgLang() {
		return largeImgLang;
	}

	public void setLargeImgLang(String largeImgLang) {
		this.largeImgLang = largeImgLang;
	}

	public String getLargeImgName() {
		return largeImgName;
	}

	public void setLargeImgName(String largeImgName) {
		this.largeImgName = largeImgName;
	}

	public int getLargeImgType() {
		return largeImgType;
	}

	public void setLargeImgType(int largeImgType) {
		this.largeImgType = largeImgType;
	}

	public String getLargeImgUrl() {
		return largeImgUrl;
	}

	public void setLargeImgUrl(String largeImgUrl) {
		this.largeImgUrl = largeImgUrl;
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

	public String getSmallImgAltText() {
		return smallImgAltText;
	}

	public void setSmallImgAltText(String smallImgAltText) {
		this.smallImgAltText = smallImgAltText;
	}

	public String getSmallImgLang() {
		return smallImgLang;
	}

	public void setSmallImgLang(String smallImgLang) {
		this.smallImgLang = smallImgLang;
	}

	public String getSmallImgName() {
		return smallImgName;
	}

	public void setSmallImgName(String smallImgName) {
		this.smallImgName = smallImgName;
	}

	public int getSmallImgType() {
		return smallImgType;
	}

	public void setSmallImgType(int smallImgType) {
		this.smallImgType = smallImgType;
	}

	public String getSmallImgUrl() {
		return smallImgUrl;
	}

	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
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

	/**
	 * @return the calcTemplate
	 */
	public String getCalcTemplate() {
		return calcTemplate;
	}

	/**
	 * @param calcTemplate the calcTemplate to set
	 */
	public void setCalcTemplate(String calcTemplate) {
		this.calcTemplate = calcTemplate;
	}

	public List<EcomItemModel> getEcomItems() {
		return ecomItems;
	}

	public void setEcomItems(List<EcomItemModel> ecomItems) {
		this.ecomItems = ecomItems;
	}

	public EcomCatalogModel getEcomCategory() {
		return ecomCategory;
	}

	public void setEcomCategory(EcomCatalogModel ecomCategory) {
		this.ecomCategory = ecomCategory;
	}

	public List<EcomProductKeywordModel> getEcomProductKeywords() {
		return ecomProductKeywords;
	}

	public void setEcomProductKeywords(
			List<EcomProductKeywordModel> ecomProductKeywords) {
		this.ecomProductKeywords = ecomProductKeywords;
	}

	/**
	 * @return the metalForm
	 */
	public String getMetalForm() {
		return metalForm;
	}

	/**
	 * @param metalForm the metalForm to set
	 */
	public void setMetalForm(String metalForm) {
		this.metalForm = metalForm;
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

	/**
	 * @return the rootCategory
	 */
	public String getRootCategory() {
		return rootCategory;
	}

	/**
	 * @param rootCategory the rootCategory to set
	 */
	public void setRootCategory(String rootCategory) {
		this.rootCategory = rootCategory;
	}

	public IziWearDataModel getIziWearData() {
		return iziWearData;
	}

	public void setIziWearData(IziWearDataModel iziWearDataModel) {
		this.iziWearData = iziWearDataModel;
	}

	/**
	 * @return the taxCode
	 */
	public double getTaxCode() {
		return taxCode;
	}

	/**
	 * @param taxCode the taxCode to set
	 */
	public void setTaxCode(double taxCode) {
		this.taxCode = taxCode;
	}

	/**
	 * @return the exciseDuty
	 */
	public Integer getExciseDuty() {
		return exciseDuty;
	}

	/**
	 * @param exciseDuty the exciseDuty to set
	 */
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
		this.taxRetailAmount = taxRetailAmount==null?0.0:taxRetailAmount;
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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted==null?0:isDeleted;
	}

	public Integer getEstock() {
		return estock;
	}

	public void setEstock(Integer estock) {
		this.estock = estock;
	}

	
}
