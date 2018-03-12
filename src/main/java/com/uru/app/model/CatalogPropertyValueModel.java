package com.uru.app.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * @author Girish.Yadav
 *
 */
public class CatalogPropertyValueModel {
	private Long propertyValueId;

	private int blobValue;

	private int booleanValue;

	private Date creationDate;

	private Date datetimeValue;

	private int doubleValue;

	private int longValue;

	private Date modifiedDate;

	private int propertyType;

	private String textValue;

	
	private CatalogPropertyKeyModel catalogPropertyKey;

	@JsonBackReference(value="item-propertyValue")
	private EcomItemModel ecomItem;

	public Long getPropertyValueId() {
		return propertyValueId;
	}

	public void setPropertyValueId(Long propertyValueId) {
		this.propertyValueId = propertyValueId;
	}

	public int getBlobValue() {
		return blobValue;
	}

	public void setBlobValue(int blobValue) {
		this.blobValue = blobValue;
	}

	public int getBooleanValue() {
		return booleanValue;
	}

	public void setBooleanValue(int booleanValue) {
		this.booleanValue = booleanValue;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDatetimeValue() {
		return datetimeValue;
	}

	public void setDatetimeValue(Date datetimeValue) {
		this.datetimeValue = datetimeValue;
	}

	public int getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(int doubleValue) {
		this.doubleValue = doubleValue;
	}

	public int getLongValue() {
		return longValue;
	}

	public void setLongValue(int longValue) {
		this.longValue = longValue;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public CatalogPropertyKeyModel getCatalogPropertyKey() {
		return catalogPropertyKey;
	}

	public void setCatalogPropertyKey(CatalogPropertyKeyModel catalogPropertyKey) {
		this.catalogPropertyKey = catalogPropertyKey;
	}

	public EcomItemModel getEcomItem() {
		return ecomItem;
	}

	public void setEcomItem(EcomItemModel ecomItem) {
		this.ecomItem = ecomItem;
	}
	
	
}
