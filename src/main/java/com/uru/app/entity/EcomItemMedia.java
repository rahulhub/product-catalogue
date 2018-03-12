package com.uru.app.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author Rahul Dev
 *
 */


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomItemMedia")
@Table(name="ecom_item_media")
public class EcomItemMedia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -127881000018925736L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IMAGE_ID")
	private Long imageId ;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
	
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
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="SKU")
	private EcomItem ecomItem;

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
	public EcomItem getEcomItem() {
		return ecomItem;
	}

	/**
	 * @param ecomItem the ecomItem to set
	 */
	public void setEcomItem(EcomItem ecomItem) {
		this.ecomItem = ecomItem;
	}
	
	
	

}
