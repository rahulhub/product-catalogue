package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;


/**
 * The persistent class for the ecom_customer_shipping_address database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomCustomerShippingAddress")
@Table(name="ecom_customer_shipping_address")
@NamedQuery(name="EcomCustomerShippingAddress.findAll", query="SELECT e FROM EcomCustomerShippingAddress e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class EcomCustomerShippingAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHIPPING_ADDRESS_ID")
	private Long shippingAddressId;

	@Column(name="CUSTOMER_ID")
	private String customerId;

	@Column(name="MAP_KEY")
	private String mapKey;

	@Column(name="SHIPPING_CITY")
	private String shippingCity;

	@Column(name="SHIPPING_COUNTRY")
	private String shippingCountry;

	@Column(name="SHIPPING_COUNTY")
	private String shippingCounty;

	@Column(name="SHIPPING_GEOCODE")
	private String shippingGeocode;

	@Column(name="SHIPPING_POBOX")
	private String shippingPobox;

	@Column(name="SHIPPING_POSTAL_CODE")
	private String shippingPostalCode;

	@Column(name="SHIPPING_POSTAL_CODE_TYPE")
	private String shippingPostalCodeType;

	@Column(name="SHIPPING_STATE")
	private String shippingState;

	@Column(name="SHIPPING_STREET1")
	private String shippingStreet1;

	@Column(name="SHIPPING_STREET2")
	private String shippingStreet2;

	public EcomCustomerShippingAddress() {
	}

	public Long getShippingAddressId() {
		return this.shippingAddressId;
	}

	public void setShippingAddressId(Long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMapKey() {
		return this.mapKey;
	}

	public void setMapKey(String mapKey) {
		this.mapKey = mapKey;
	}

	public String getShippingCity() {
		return this.shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingCountry() {
		return this.shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingCounty() {
		return this.shippingCounty;
	}

	public void setShippingCounty(String shippingCounty) {
		this.shippingCounty = shippingCounty;
	}

	public String getShippingGeocode() {
		return this.shippingGeocode;
	}

	public void setShippingGeocode(String shippingGeocode) {
		this.shippingGeocode = shippingGeocode;
	}

	public String getShippingPobox() {
		return this.shippingPobox;
	}

	public void setShippingPobox(String shippingPobox) {
		this.shippingPobox = shippingPobox;
	}

	public String getShippingPostalCode() {
		return this.shippingPostalCode;
	}

	public void setShippingPostalCode(String shippingPostalCode) {
		this.shippingPostalCode = shippingPostalCode;
	}

	public String getShippingPostalCodeType() {
		return this.shippingPostalCodeType;
	}

	public void setShippingPostalCodeType(String shippingPostalCodeType) {
		this.shippingPostalCodeType = shippingPostalCodeType;
	}

	public String getShippingState() {
		return this.shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingStreet1() {
		return this.shippingStreet1;
	}

	public void setShippingStreet1(String shippingStreet1) {
		this.shippingStreet1 = shippingStreet1;
	}

	public String getShippingStreet2() {
		return this.shippingStreet2;
	}

	public void setShippingStreet2(String shippingStreet2) {
		this.shippingStreet2 = shippingStreet2;
	}

}