package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;


/**
 * The persistent class for the catalog_property_value database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="CatalogPropertyValue")
@Table(name="catalog_property_value")
@NamedQuery(name="CatalogPropertyValue.findAll", query="SELECT c FROM CatalogPropertyValue c", hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
public class CatalogPropertyValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROPERTY_VALUE_ID")
	private Long propertyValueId;

	@Column(name="BLOB_VALUE")
	private int blobValue;

	@Column(name="BOOLEAN_VALUE")
	private int booleanValue;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DATETIME_VALUE")
	private Date datetimeValue;

	@Column(name="DOUBLE_VALUE")
	private int doubleValue;

	@Column(name="LONG_VALUE")
	private int longValue;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="PROPERTY_TYPE")
	private int propertyType;

	@Column(name="TEXT_VALUE")
	private String textValue;

	//bi-directional many-to-one association to CatalogPropertyKey
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade=CascadeType.REFRESH,fetch = FetchType.EAGER)
	@JoinColumn(name="PROPERTY_KEY_ID")
	private CatalogPropertyKey catalogPropertyKey;

	//bi-directional many-to-one association to EcomItem
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="SKU")
	private EcomItem ecomItem;

	public CatalogPropertyValue() {
	}

	public Long getPropertyValueId() {
		return this.propertyValueId;
	}

	public void setPropertyValueId(Long propertyValueId) {
		this.propertyValueId = propertyValueId;
	}

	public int getBlobValue() {
		return this.blobValue;
	}

	public void setBlobValue(int blobValue) {
		this.blobValue = blobValue;
	}

	public int getBooleanValue() {
		return this.booleanValue;
	}

	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDatetimeValue() {
		return this.datetimeValue;
	}

	public void setDatetimeValue(Date datetimeValue) {
		this.datetimeValue = datetimeValue;
	}

	public int getDoubleValue() {
		return this.doubleValue;
	}

	public void setDoubleValue(int doubleValue) {
		this.doubleValue = doubleValue;
	}

	public int getLongValue() {
		return this.longValue;
	}

	public void setLongValue(int longValue) {
		this.longValue = longValue;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

	public String getTextValue() {
		return this.textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public CatalogPropertyKey getCatalogPropertyKey() {
		return this.catalogPropertyKey;
	}

	public void setCatalogPropertyKey(CatalogPropertyKey catalogPropertyKey) {
		this.catalogPropertyKey = catalogPropertyKey;
	}

	public EcomItem getEcomItem() {
		return this.ecomItem;
	}

	public void setEcomItem(EcomItem ecomItem) {
		this.ecomItem = ecomItem;
	}

}