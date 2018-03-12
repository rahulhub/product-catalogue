package com.uru.app.entity;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;


/**
 * The persistent class for the ecom_product database table.
 * 
 */
@Entity
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="ecom_product")
//@NamedQuery(name="EcomProduct.findAll", query="SELECT e FROM EcomProduct e")
@NamedQueries({
@NamedQuery(name="EcomProduct.findAll", query="SELECT e FROM EcomProduct e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomProduct.findProductById", query="Select p from EcomProduct p where p.productId= :productId", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),})
public class EcomProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private Long productId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="DET_DISPLAY_JSP_URL")
	private String detDisplayJspUrl;

	@Column(name="ESTIMATE_SHIP_TIME")
	private String estimateShipTime;

	@Column(name="IN_STOCK")
	private int inStock;

	@Column(name="LANG")
	private String lang;

	@Column(name="LARGE_IMG_ALT_TEXT")
	private String largeImgAltText;

	@Column(name="LARGE_IMG_LANG")
	private String largeImgLang;

	@Column(name="LARGE_IMG_NAME")
	private String largeImgName;

	@Column(name="LARGE_IMG_TYPE")
	private int largeImgType;

	@Column(name="LARGE_IMG_URL")
	private String largeImgUrl;

	@Column(name="LONG_DESC")
	private String longDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="MSRP_AMOUNT")
	private BigInteger msrpAmount;

	@Column(name="MSRP_CURRENCY")
	private String msrpCurrency;

	@Column(name="NAME")
	private String name;

	@Column(name="PRICE_AMOUNT")
	private BigInteger priceAmount;

	@Column(name="PRICE_CURRENCY")
	private String priceCurrency;

	@Column(name="SHIPPING_CODE")
	private String shippingCode;

	@Column(name="SHORT_DESC")
	private String shortDesc;

	@Column(name="SMALL_IMG_ALT_TEXT")
	private String smallImgAltText;

	@Column(name="SMALL_IMG_LANG")
	private String smallImgLang;

	@Column(name="SMALL_IMG_NAME")
	private String smallImgName;

	@Column(name="SMALL_IMG_TYPE")
	private int smallImgType;

	@Column(name="SMALL_IMG_URL")
	private String smallImgUrl;

	@Column(name="SOURCE")
	private String source;

	@Column(name="SPECIAL_NOTES")
	private String specialNotes;

	@Column(name="SUM_DISPLAY_JSP_URL")
	private String sumDisplayJspUrl;

	@Column(name="TAX_CODE")
	private double taxCode;

	@Column(name="TYPE")
	private String type;

	@Column(name="VISIBLE")
	private int visible;
	
	@Column(name="CALC_TEMPLATE")
	private String calcTemplate;
	
	@Column(name="DISCOUNT_PERCENTAGE")
	private String discount;
	
	@Column(name="EXCISE_DUTY")
	private Integer exciseDuty=0;

	@Column(name="TAX_AMOUNT")
	private Double taxAmount=0.0;

	@Column(name="TAX_RETAIL_AMOUNT")
	private Double taxRetailAmount=0.0;

	@Column(name="MIN_ORDER_QTY")
	private Integer minOrderQty=0;

	@Column(name="MAX_ORDER_QTY")
	private Integer maxOrderQty=0;

	@Column(name="LEAD_TIME")
	private Integer leadTime=0;
	
	@Column(name="ESTOCK")
	private Integer estock=0;

	
	//bi-directional many-to-one association to EcomItem
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomProduct",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<EcomItem> ecomItems;

	//bi-directional many-to-one association to EcomCategory
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="CATEGORY_ID")
	private EcomCategory ecomCategory;

	//bi-directional many-to-one association to EcomProductKeyword
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomProduct",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<EcomProductKeyword> ecomProductKeywords;
	
	@Column(name="metalForm")
	private String metalForm;
	
	@Column(name="rootCategory")
	private String rootCategory;
	
	@Column(name="IS_DELETED")
	private Integer isDeleted;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "IZIWEAR_ID", nullable = true)
	private IziWearData iziWearData;

	public EcomProduct() {
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate==null?new Date():creationDate;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDetDisplayJspUrl() {
		return this.detDisplayJspUrl;
	}

	public void setDetDisplayJspUrl(String detDisplayJspUrl) {
		this.detDisplayJspUrl = detDisplayJspUrl;
	}

	public String getEstimateShipTime() {
		return this.estimateShipTime;
	}

	public void setEstimateShipTime(String estimateShipTime) {
		this.estimateShipTime = estimateShipTime;
	}

	public int getInStock() {
		return this.inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLargeImgAltText() {
		return this.largeImgAltText;
	}

	public void setLargeImgAltText(String largeImgAltText) {
		this.largeImgAltText = largeImgAltText;
	}

	public String getLargeImgLang() {
		return this.largeImgLang;
	}

	public void setLargeImgLang(String largeImgLang) {
		this.largeImgLang = largeImgLang;
	}

	public String getLargeImgName() {
		return this.largeImgName;
	}

	public void setLargeImgName(String largeImgName) {
		this.largeImgName = largeImgName;
	}

	public int getLargeImgType() {
		return this.largeImgType;
	}

	public void setLargeImgType(int largeImgType) {
		this.largeImgType = largeImgType;
	}

	public String getLargeImgUrl() {
		return this.largeImgUrl;
	}

	public void setLargeImgUrl(String largeImgUrl) {
		this.largeImgUrl = largeImgUrl;
	}

	public String getLongDesc() {
		return this.longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public BigInteger getMsrpAmount() {
		return this.msrpAmount;
	}

	public void setMsrpAmount(BigInteger msrpAmount) {
		this.msrpAmount = msrpAmount;
	}

	public String getMsrpCurrency() {
		return this.msrpCurrency;
	}

	public void setMsrpCurrency(String msrpCurrency) {
		this.msrpCurrency = msrpCurrency;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getPriceAmount() {
		return this.priceAmount;
	}

	public void setPriceAmount(BigInteger priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getPriceCurrency() {
		return this.priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public String getShippingCode() {
		return this.shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getSmallImgAltText() {
		return this.smallImgAltText;
	}

	public void setSmallImgAltText(String smallImgAltText) {
		this.smallImgAltText = smallImgAltText;
	}

	public String getSmallImgLang() {
		return this.smallImgLang;
	}

	public void setSmallImgLang(String smallImgLang) {
		this.smallImgLang = smallImgLang;
	}

	public String getSmallImgName() {
		return this.smallImgName;
	}

	public void setSmallImgName(String smallImgName) {
		this.smallImgName = smallImgName;
	}

	public int getSmallImgType() {
		return this.smallImgType;
	}

	public void setSmallImgType(int smallImgType) {
		this.smallImgType = smallImgType;
	}

	public String getSmallImgUrl() {
		return this.smallImgUrl;
	}

	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSpecialNotes() {
		return this.specialNotes;
	}

	public void setSpecialNotes(String specialNotes) {
		this.specialNotes = specialNotes;
	}

	public String getSumDisplayJspUrl() {
		return this.sumDisplayJspUrl;
	}

	public void setSumDisplayJspUrl(String sumDisplayJspUrl) {
		this.sumDisplayJspUrl = sumDisplayJspUrl;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVisible() {
		return this.visible;
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

	public List<EcomItem> getEcomItems() {
		return this.ecomItems;
	}

	public void setEcomItems(List<EcomItem> ecomItems) {
		this.ecomItems = ecomItems;
	}

	public EcomItem addEcomItem(EcomItem ecomItem) {
		getEcomItems().add(ecomItem);
		ecomItem.setEcomProduct(this);

		return ecomItem;
	}

	/*public EcomItem removeEcomItem(EcomItem ecomItem) {
		getEcomItems().remove(ecomItem);
		//ecomItem.setEcomProduct(null);
		return ecomItem;
	}*/

	public EcomCategory getEcomCategory() {
		return this.ecomCategory;
	}

	public void setEcomCategory(EcomCategory ecomCategory) {
		this.ecomCategory = ecomCategory;
	}

	public List<EcomProductKeyword> getEcomProductKeywords() {
		return this.ecomProductKeywords;
	}

	public void setEcomProductKeywords(List<EcomProductKeyword> ecomProductKeywords) {
		this.ecomProductKeywords = ecomProductKeywords;
	}

	public EcomProductKeyword addEcomProductKeyword(EcomProductKeyword ecomProductKeyword) {
		getEcomProductKeywords().add(ecomProductKeyword);
		ecomProductKeyword.setEcomProduct(this);

		return ecomProductKeyword;
	}

	public EcomProductKeyword removeEcomProductKeyword(EcomProductKeyword ecomProductKeyword) {
		getEcomProductKeywords().remove(ecomProductKeyword);
		ecomProductKeyword.setEcomProduct(null);

		return ecomProductKeyword;
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

	public IziWearData getIziWearData() {
		return iziWearData;
	}

	public void setIziWearData(IziWearData iziWearData) {
		this.iziWearData = iziWearData;
	}

	public double getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(double taxCode) {
		this.taxCode = taxCode;
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