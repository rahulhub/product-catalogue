package com.uru.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;


public class EcomCatalogModel {
	
	private Long categoryId;
	
	private Date creationDate;

	//private String lang;

	private String largeImgAltText;

	private String largeImgLang;

	private String largeImgName;

	private Integer largeImgType=0;

	private String largeImgUrl;

	private String longDesc;

	private Date modifiedDate;

	private String name;

	private String relation;

	private String shortDesc;

	private String smallImgAltText;

	private String smallImgLang;

	private String smallImgName;

	private Integer smallImgTyp=0;

	private String smallImgUrl;

	private String source;
	
//	private String displayJspUrl;
	
	private Double tBaseRate=0.0;
	
	private Double tCutRate=0.0;
	
	private Double specGravity=0.0;
	
	private Double minDimension=0.0;

	private Double sellerTBaseRate=0.0;
	
	private Double sellerTCutRate=0.0;
	
	private Double sellerSpecGravity=0.0;
	
	private Double sellerMinDimension=0.0;
	
	private Double sellerMaxDimension=0.0;
	

//	public String getDisplayJspUrl() {
//		return displayJspUrl;
//	}
//
//	public void setDisplayJspUrl(String displayJspUrl) {
//		this.displayJspUrl = displayJspUrl;
//	}

	@JsonBackReference(value="catagory")
	private EcomCatalogModel parentCategory;

	@JsonManagedReference(value="catagory")
	private List<EcomCatalogModel> ecomCategories;

	@JsonManagedReference(value="product-catagory")
	private List<EcomProductModel> ecomProducts;
	
//	@JsonManagedReference(value="pincode-catagory")
//	private List<EcomPinCodeModel> ecomPinCodeModel;
	
	private String rootCategory;
	
	private String metalType ;
			
	private Double maxDimension=0.0;
	
	private String make;
	
	private Integer isDeleted=0;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate==null?new Date():creationDate;
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

	public Integer getLargeImgType() {
		return largeImgType;
	}

	public void setLargeImgType(Integer largeImgType) {
		this.largeImgType = largeImgType==null?0:largeImgType;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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

	public Integer getSmallImgType() {
		return smallImgTyp;
	}

	public void setSmallImgType(Integer smallImgType) {
		this.smallImgTyp = smallImgTyp==null?0:smallImgTyp;
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

	public EcomCatalogModel getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(EcomCatalogModel parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<EcomCatalogModel> getEcomCategories() {
		return ecomCategories;
	}

	public void setEcomCategories(List<EcomCatalogModel> ecomCategories) {
		this.ecomCategories = ecomCategories;
	}

	public List<EcomProductModel> getEcomProducts() {
		return ecomProducts;
	}

	public void setEcomProducts(List<EcomProductModel> ecomProducts) {
		this.ecomProducts = ecomProducts;
	}

	public Double gettBaseRate() {
		return tBaseRate;
	}

	public void settBaseRate(Double tBaseRate) {
		this.tBaseRate = tBaseRate==null?0.0:tBaseRate;
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
		this.sellerTBaseRate = sellerTBaseRate==null?0.0:sellerTBaseRate;
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
		this.sellerTCutRate = sellerTCutRate==null?0.0:sellerTCutRate;
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
		this.sellerSpecGravity = sellerSpecGravity==null?0.0:sellerSpecGravity;
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
		this.sellerMinDimension = sellerMinDimension==null?0.0:sellerMinDimension;
	}
	
	public Double getMaxDimension() {
		return maxDimension;
	}

	public void setMaxDimension(Double maxDimension) {
		this.maxDimension = maxDimension==null?0.0:maxDimension;
	}
	
	public Double getSellerMaxDimension() {
		return sellerMaxDimension;
	}

	public void setSellerMaxDimension(Double sellerMaxDimension) {
		//this.sellerMaxDimension = sellerMaxDimension;
		this.sellerMaxDimension = sellerMaxDimension == null ? 0.0 : sellerMaxDimension;
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

//	public List<EcomPinCodeModel> getEcomPinCodeModel() {
//		return ecomPinCodeModel;
//	}
//
//	public void setEcomPinCodeModel(List<EcomPinCodeModel> ecomPinCodeModel) {
//		this.ecomPinCodeModel = ecomPinCodeModel;
//	}
	
	

}
