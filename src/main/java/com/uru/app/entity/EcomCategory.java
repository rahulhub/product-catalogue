package com.uru.app.entity;

import java.io.Serializable;
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
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;


/**
 * The persistent class for the ecom_category database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomCategory")

@Table(name="ecom_category")
//@NamedQuery(name="EcomCategory.findAll", query="SELECT e FROM EcomCategory e WHERE parentEcomCategory = null")
@NamedQueries({
@NamedQuery(name="EcomCategory.findAll", query="SELECT c FROM EcomCategory c WHERE c.parentEcomCategory = null", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomCategory.findCategoryById", query="Select c from EcomCategory c where c.categoryId= :categoryId", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})})
public class EcomCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORY_ID")
	private Long categoryId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="DISPLAY_JSP_URL")
	private String displayJspUrl;
	
//	@Column(name="LANG")
//	private String lang;

	@Column(name="LARGE_IMG_ALT_TEXT")
	private String largeImgAltText;

//	@Column(name="LARGE_IMG_LANG")
//	private String largeImgLang;

	@Column(name="LARGE_IMG_NAME")
	private String largeImgName;

	@Column(name="LARGE_IMG_TYPE")
	private Integer largeImgType=0;

	@Column(name="LARGE_IMG_URL")
	private String largeImgUrl;

	@Column(name="LONG_DESC")
	private String longDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="NAME")
	private String name;

	@Column(name="RELATION")
	private String relation;

	@Column(name="SHORT_DESC")
	private String shortDesc;

	@Column(name="SMALL_IMG_ALT_TEXT")
	private String smallImgAltText;

	@Column(name="SMALL_IMG_LANG")
	private String smallImgLang;

	@Column(name="SMALL_IMG_NAME")
	private String smallImgName;

	@Column(name="SMALL_IMG_TYPE")
	private Integer smallImgType=0;

	@Column(name="SMALL_IMG_URL")
	private String smallImgUrl;

	@Column(name="SOURCE")
	private String source;
	
	@Column(name="TD_BASE_RATE")
	private Double tBaseRate;
	
	@Column(name="TD_CUT_RATE")
	private Double tCutRate;
	
	@Column(name="SPEC_GRAVITY")
	private Double specGravity;
	
	@Column(name="MIN_DIMENSION")
	private Double minDimension=0.0;
	
	@Column(name="MAX_DIMENSION")
	private Double maxDimension=0.0;
	
	@Column(name="SELLER_TD_BASE_RATE")
	private Double sellerTBaseRate;
	
	@Column(name="SELLER_TD_CUT_RATE")
	private Double sellerTCutRate;
	
	@Column(name="SELLER_SPEC_GRAVITY")
	private Double sellerSpecGravity;
	
	@Column(name="SELLER_MIN_DIMENSION")
	private Double sellerMinDimension;
	
	@Column(name="SELLER_MAX_DIMENSION")
	private Double sellerMaxDimension=0.0;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="IS_DELETED")
	private Integer isDeleted;

	//bi-directional many-to-one association to EcomCategory
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="PARENT_ID")
	private EcomCategory parentEcomCategory;

	//bi-directional many-to-one association to EcomCategory
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="parentEcomCategory",cascade={CascadeType.ALL},fetch = FetchType.EAGER	)
	private List<EcomCategory> ecomCategories;

	//bi-directional many-to-one association to EcomProduct
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomCategory", cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<EcomProduct> ecomProducts;
	
	//bi-directional many-to-one association to EcomProduct
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//	@OneToMany(mappedBy="ecomCategory", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<EcomPinCode> ecomPinCode;
	
	@Column(name="rootCategory")
	private String rootCategory;
	
	@Column(name="metalType")
	private String metalType ;
	
	public EcomCategory() {
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate==null?new Date():creationDate;
	}

	public String getDisplayJspUrl() {
		return this.displayJspUrl;
	}

	public void setDisplayJspUrl(String displayJspUrl) {
		this.displayJspUrl = displayJspUrl;
	}

//	public String getLang() {
//		return this.lang;
//	}
//
//	public void setLang(String lang) {
//		this.lang = lang;
//	}

	public String getLargeImgAltText() {
		return this.largeImgAltText;
	}

	public void setLargeImgAltText(String largeImgAltText) {
		this.largeImgAltText = largeImgAltText;
	}

//	public String getLargeImgLang() {
//		return this.largeImgLang;
//	}
//
//	public void setLargeImgLang(String largeImgLang) {
//		this.largeImgLang = largeImgLang;
//	}

	public String getLargeImgName() {
		return this.largeImgName;
	}

	public void setLargeImgName(String largeImgName) {
		this.largeImgName = largeImgName;
	}

	public Integer getLargeImgType() {
		return this.largeImgType;
	}

	public void setLargeImgType(Integer largeImgType) {
		this.largeImgType = largeImgType==null?0:largeImgType;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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

	public Integer getSmallImgType() {
		return this.smallImgType;
	}

	public void setSmallImgType(Integer smallImgType) {
		this.smallImgType = smallImgType==null?0:smallImgType;
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

	public EcomCategory getParentEcomCategory() {
		return this.parentEcomCategory;
	}

	public void setEcomCategory(EcomCategory parentEcomCategory) {
		this.parentEcomCategory = parentEcomCategory;
	}

	public List<EcomCategory> getEcomCategories() {
		return this.ecomCategories;
	}

	public void setEcomCategories(List<EcomCategory> ecomCategories) {
		this.ecomCategories = ecomCategories;
	}

	public EcomCategory addEcomCategory(EcomCategory ecomCategory) {
		getEcomCategories().add(ecomCategory);
		ecomCategory.setEcomCategory(this);

		return ecomCategory;
	}

	public EcomCategory removeEcomCategory(EcomCategory ecomCategory) {
		getEcomCategories().remove(ecomCategory);
		//ecomCategory.setEcomCategory(null);

		return ecomCategory;
	}

	public List<EcomProduct> getEcomProducts() {
		return this.ecomProducts;
	}

	public void setEcomProducts(List<EcomProduct> ecomProducts) {
		this.ecomProducts = ecomProducts;
	}

	public EcomProduct addEcomProduct(EcomProduct ecomProduct) {
		getEcomProducts().add(ecomProduct);
		ecomProduct.setEcomCategory(this);

		return ecomProduct;
	}

	public EcomProduct removeEcomProduct(EcomProduct ecomProduct) {
		getEcomProducts().remove(ecomProduct);
		//ecomProduct.setEcomCategory(null);

		return ecomProduct;
	}

	public Double gettBaseRate() {
		return tBaseRate;
	}

	public void settBaseRate(Double tBaseRate) {
		this.tBaseRate = tBaseRate == null?0.0:tBaseRate;
	}

	public Double gettCutRate() {
		return tCutRate;
	}

	public void settCutRate(Double tCutRate) {
		this.tCutRate = tCutRate==null?0.0:tCutRate;
	}

	public Double getSpecGravity() {
		return specGravity;
	}

	public void setSpecGravity(Double specGravity) {
		this.specGravity = specGravity==null?0.0:specGravity;
	}

	public Double getMinDimension() {
		return minDimension;
	}

	public void setMinDimension(Double minDimension) {
		this.minDimension = minDimension==null?0.0:minDimension;
	}

	public void setParentEcomCategory(EcomCategory parentEcomCategory) {
		this.parentEcomCategory = parentEcomCategory;
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

	/**
	 * @return the metalType
	 */
	public String getMetalType() {
		return metalType;
	}

	/**
	 * @param metalType the metalType to set
	 */
	public void setMetalType(String metalType) {
		this.metalType = metalType;
	}

	/**
	 * @return the sellerTBaseRate
	 */
	public Double getSellerTBaseRate() {
		return sellerTBaseRate;
	}

	/**
	 * @param sellerTBaseRate the sellerTBaseRate to set
	 */
	public void setSellerTBaseRate(Double sellerTBaseRate) {
		this.sellerTBaseRate = sellerTBaseRate ==null?0.0:sellerTBaseRate;
	}

	/**
	 * @return the sellerTCutRate
	 */
	public Double getSellerTCutRate() {
		return sellerTCutRate;
	}

	/**
	 * @param sellerTCutRate the sellerTCutRate to set
	 */
	public void setSellerTCutRate(Double sellerTCutRate) {
		this.sellerTCutRate = sellerTCutRate == null ? 0.0:sellerTCutRate;
	}

	/**
	 * @return the sellerSpecGravity
	 */
	public Double getSellerSpecGravity() {
		return sellerSpecGravity;
	}

	/**
	 * @param sellerSpecGravity the sellerSpecGravity to set
	 */
	public void setSellerSpecGravity(Double sellerSpecGravity) {
		this.sellerSpecGravity = sellerSpecGravity == null ? 0.0 : sellerSpecGravity;
	}

	/**
	 * @return the sellerMinDimension
	 */
	public Double getSellerMinDimension() {
		return sellerMinDimension;
	}

	/**
	 * @param sellerMinDimension the sellerMinDimension to set
	 */
	public void setSellerMinDimension(Double sellerMinDimension) {
		this.sellerMinDimension = sellerMinDimension == null ? 0.0 : sellerMinDimension;
	}
	
	public Double getSellerMaxDimension() {
		return sellerMaxDimension;
	}

	public void setSellerMaxDimension(Double sellerMaxDimension) {
		this.sellerMaxDimension = sellerMaxDimension == null ? 0.0 : sellerMaxDimension;
	}

	public Double getMaxDimension() {
		return maxDimension;
	}

	public void setMaxDimension(Double maxDimension) {
		this.maxDimension = maxDimension == null ? 0.0 : maxDimension;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted==null?0:isDeleted;
	}

//	public List<EcomPinCode> getEcomPinCode() {
//		return ecomPinCode;
//	}
//
//	public void setEcomPinCode(List<EcomPinCode> ecomPinCode) {
//		this.ecomPinCode = ecomPinCode;
//	}
//	
	
	
}