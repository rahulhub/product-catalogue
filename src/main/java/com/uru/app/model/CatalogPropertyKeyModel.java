package com.uru.app.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * @author Girish.Yadav
 *
 */
public class CatalogPropertyKeyModel {
	private Long propertyKeyId;

	private Date creationDate;

	private Date modifiedDate;

	private String propertyCode;

	private String propertyName;

	private String propertySetType;

	@JsonIgnore
	private List<CatalogPropertyValueModel> catalogPropertyValues;

	public Long getPropertyKeyId() {
		return propertyKeyId;
	}

	public void setPropertyKeyId(Long propertyKeyId) {
		this.propertyKeyId = propertyKeyId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertySetType() {
		return propertySetType;
	}

	public void setPropertySetType(String propertySetType) {
		this.propertySetType = propertySetType;
	}

	public List<CatalogPropertyValueModel> getCatalogPropertyValues() {
		return catalogPropertyValues;
	}

	public void setCatalogPropertyValues(
			List<CatalogPropertyValueModel> catalogPropertyValues) {
		this.catalogPropertyValues = catalogPropertyValues;
	}
}
