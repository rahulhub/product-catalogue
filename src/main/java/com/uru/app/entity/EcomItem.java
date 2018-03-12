package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the ecom_item database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region="EcomItem")
@Table(name="ecom_item")
@NamedQueries({
@NamedQuery(name="EcomItem.findAll", query="SELECT e FROM EcomItem e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomItem.findItemById", query="SELECT e FROM EcomItem e where e.sku = :sku", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})})
public class EcomItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sku;

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

	@Column(name="SOURCE")
	private String source;

	@Column(name="SPECIAL_NOTES")
	private String specialNotes;

	@Column(name="SUM_DISPLAY_JSP_URL")
	private String sumDisplayJspUrl;

	@Column(name="TAX_CODE")
	private String taxCode;

	@Column(name="TYPE")
	private String type;

	@Column(name="VISIBLE")
	private int visible;
	
	@Column(name="DISCOUNT_PERCENTAGE")
	private String discount;
	
	@Column(name="MIN_ORDER_QTY")
	private Integer minOrderQty=0;

	@Column(name="MAX_ORDER_QTY")
	private Integer maxOrderQty=0;
	
	@Column(name="LEAD_TIME")
	private Integer leadTime=0;
	
	@Column(name="EXCISE_DUTY")
    private Integer exciseDuty=0;
	
	@Column(name="TAX_AMOUNT")
    private Double taxAmount=0.0;
	
	@Column(name="TAX_RETAIL_AMOUNT")
    private Double taxRetailAmount=0.0;
	
	@Column(name="IS_DELETED")
    private Integer isDeleted=0;
	
	//bi-directional many-to-one association to CatalogPropertyValue
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomItem", cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<CatalogPropertyValue> catalogPropertyValues;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomItem", cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<EcomItemMedia> itemMediaList;

	//bi-directional many-to-one association to EcomProduct
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="PRODUCT_ID")
	private EcomProduct ecomProduct;

	public EcomItem() {
	}

	public Long getSku() {
		return this.sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
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

	public String getTaxCode() {
		return this.taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
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

	public List<CatalogPropertyValue> getCatalogPropertyValues() {
		return this.catalogPropertyValues;
	}

	public void setCatalogPropertyValues(List<CatalogPropertyValue> catalogPropertyValues) {
		this.catalogPropertyValues = catalogPropertyValues;
	}

	public CatalogPropertyValue addCatalogPropertyValue(CatalogPropertyValue catalogPropertyValue) {
		getCatalogPropertyValues().add(catalogPropertyValue);
		catalogPropertyValue.setEcomItem(this);

		return catalogPropertyValue;
	}

	public CatalogPropertyValue removeCatalogPropertyValue(CatalogPropertyValue catalogPropertyValue) {
		getCatalogPropertyValues().remove(catalogPropertyValue);
		catalogPropertyValue.setEcomItem(null);

		return catalogPropertyValue;
	}

	public EcomProduct getEcomProduct() {
		return this.ecomProduct;
	}

	public void setEcomProduct(EcomProduct ecomProduct) {
		this.ecomProduct = ecomProduct;
	}

	/**
	 * @return the itemMediaList
	 */
	public List<EcomItemMedia> getItemMediaList() {
		return itemMediaList;
	}

	/**
	 * @param itemMediaList the itemMediaList to set
	 */
	public void setItemMediaList(List<EcomItemMedia> itemMediaList) {
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
		this.taxRetailAmount = taxRetailAmount==null?0.0:taxRetailAmount;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted==null?0:isDeleted;
	}
	
	
	
}