package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the catalog_property_key database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="CatalogPropertyKey")
@Table(name="catalog_property_key")
@NamedQueries({
@NamedQuery(name="CatalogPropertyKey.findAll", query="SELECT c FROM CatalogPropertyKey c", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")} ),
@NamedQuery(name="CatalogPropertyKey.findByCode", query="SELECT c FROM CatalogPropertyKey c where c.propertyCode =:propertyCode", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
})
public class CatalogPropertyKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROPERTY_KEY_ID")
	private Long propertyKeyId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="PROPERTY_CODE",unique = true)
	private String propertyCode;

	@Column(name="PROPERTY_NAME")
	private String propertyName;

	@Column(name="PROPERTY_SET_TYPE")
	private String propertySetType;

	//bi-directional many-to-one association to CatalogPropertyValue
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="catalogPropertyKey", cascade = {CascadeType.REFRESH})
	private List<CatalogPropertyValue> catalogPropertyValues;

	public CatalogPropertyKey() {
	}

	public Long getPropertyKeyId() {
		return this.propertyKeyId;
	}

	public void setPropertyKeyId(Long propertyKeyId) {
		this.propertyKeyId = propertyKeyId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPropertyCode() {
		return this.propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertySetType() {
		return this.propertySetType;
	}

	public void setPropertySetType(String propertySetType) {
		this.propertySetType = propertySetType;
	}

	public List<CatalogPropertyValue> getCatalogPropertyValues() {
		return this.catalogPropertyValues;
	}

	public void setCatalogPropertyValues(List<CatalogPropertyValue> catalogPropertyValues) {
		this.catalogPropertyValues = catalogPropertyValues;
	}

	public CatalogPropertyValue addCatalogPropertyValue(CatalogPropertyValue catalogPropertyValue) {
		getCatalogPropertyValues().add(catalogPropertyValue);
		catalogPropertyValue.setCatalogPropertyKey(this);

		return catalogPropertyValue;
	}

	public CatalogPropertyValue removeCatalogPropertyValue(CatalogPropertyValue catalogPropertyValue) {
		getCatalogPropertyValues().remove(catalogPropertyValue);
		catalogPropertyValue.setCatalogPropertyKey(null);

		return catalogPropertyValue;
	}

}