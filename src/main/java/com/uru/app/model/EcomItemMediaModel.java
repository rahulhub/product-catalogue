package com.uru.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.uru.app.entity.EcomItem;

public class EcomItemMediaModel {
	
	private Long imageId ;

	private Date creationDate;
	
	private Date modifiedDate;
	
	private String largeImgAltText;

	private String largeImgLang;

	private String largeImgName;

	private int largeImgType;

	private String largeImgUrl;
	
	private String smallImgAltText;

	private String smallImgLang;

	private String smallImgName;

	private int smallImgType;

	private String smallImgUrl;
	
	@JsonBackReference(value="item-media")
	private EcomItemModel ecomItem;

	/**
	 * @return the imageId
	 */
	public Long getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the largeImgAltText
	 */
	public String getLargeImgAltText() {
		return largeImgAltText;
	}

	/**
	 * @param largeImgAltText the largeImgAltText to set
	 */
	public void setLargeImgAltText(String largeImgAltText) {
		this.largeImgAltText = largeImgAltText;
	}

	/**
	 * @return the largeImgLang
	 */
	public String getLargeImgLang() {
		return largeImgLang;
	}

	/**
	 * @param largeImgLang the largeImgLang to set
	 */
	public void setLargeImgLang(String largeImgLang) {
		this.largeImgLang = largeImgLang;
	}

	/**
	 * @return the largeImgName
	 */
	public String getLargeImgName() {
		return largeImgName;
	}

	/**
	 * @param largeImgName the largeImgName to set
	 */
	public void setLargeImgName(String largeImgName) {
		this.largeImgName = largeImgName;
	}

	/**
	 * @return the largeImgType
	 */
	public int getLargeImgType() {
		return largeImgType;
	}

	/**
	 * @param largeImgType the largeImgType to set
	 */
	public void setLargeImgType(int largeImgType) {
		this.largeImgType = largeImgType;
	}

	/**
	 * @return the largeImgUrl
	 */
	public String getLargeImgUrl() {
		return largeImgUrl;
	}

	/**
	 * @param largeImgUrl the largeImgUrl to set
	 */
	public void setLargeImgUrl(String largeImgUrl) {
		this.largeImgUrl = largeImgUrl;
	}

	/**
	 * @return the smallImgAltText
	 */
	public String getSmallImgAltText() {
		return smallImgAltText;
	}

	/**
	 * @param smallImgAltText the smallImgAltText to set
	 */
	public void setSmallImgAltText(String smallImgAltText) {
		this.smallImgAltText = smallImgAltText;
	}

	/**
	 * @return the smallImgLang
	 */
	public String getSmallImgLang() {
		return smallImgLang;
	}

	/**
	 * @param smallImgLang the smallImgLang to set
	 */
	public void setSmallImgLang(String smallImgLang) {
		this.smallImgLang = smallImgLang;
	}

	/**
	 * @return the smallImgName
	 */
	public String getSmallImgName() {
		return smallImgName;
	}

	/**
	 * @param smallImgName the smallImgName to set
	 */
	public void setSmallImgName(String smallImgName) {
		this.smallImgName = smallImgName;
	}

	/**
	 * @return the smallImgType
	 */
	public int getSmallImgType() {
		return smallImgType;
	}

	/**
	 * @param smallImgType the smallImgType to set
	 */
	public void setSmallImgType(int smallImgType) {
		this.smallImgType = smallImgType;
	}

	/**
	 * @return the smallImgUrl
	 */
	public String getSmallImgUrl() {
		return smallImgUrl;
	}

	/**
	 * @param smallImgUrl the smallImgUrl to set
	 */
	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
	}

	/**
	 * @return the ecomItem
	 */
	public EcomItemModel getEcomItem() {
		return ecomItem;
	}

	/**
	 * @param ecomItem the ecomItem to set
	 */
	public void setEcomItem(EcomItemModel ecomItem) {
		this.ecomItem = ecomItem;
	}

	

}
