package com.uru.app.model;

import java.util.Date;
import java.util.List;

/**
 * @author Girish.Yadav
 *
 */
public class EcomTransactionModel {
	private String transactionId;

	private String batchId;

	private String ccCompany;

	private String ccDisplayNumber;

	private Date ccExpDate;

	private String ccName;

	private String ccNumber;

	private String ccType;

	private String city;

	private String country;

	private String description;

	private String geocode;

	private String pobox;

	private String postalCode;

	private String state;

	private String street1;

	private String street2;

	private double tranAmount;

	private String tranCurrency;

	private Date tranDate;

	private String tranStatus;

	private List<EcomOrderModel> ecomOrders;

	private List<EcomTransactionEntryModel> ecomTransactionEntries;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCcCompany() {
		return ccCompany;
	}

	public void setCcCompany(String ccCompany) {
		this.ccCompany = ccCompany;
	}

	public String getCcDisplayNumber() {
		return ccDisplayNumber;
	}

	public void setCcDisplayNumber(String ccDisplayNumber) {
		this.ccDisplayNumber = ccDisplayNumber;
	}

	public Date getCcExpDate() {
		return ccExpDate;
	}

	public void setCcExpDate(Date ccExpDate) {
		this.ccExpDate = ccExpDate;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGeocode() {
		return geocode;
	}

	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}

	public String getPobox() {
		return pobox;
	}

	public void setPobox(String pobox) {
		this.pobox = pobox;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public double getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(double tranAmount) {
		this.tranAmount = tranAmount;
	}

	public String getTranCurrency() {
		return tranCurrency;
	}

	public void setTranCurrency(String tranCurrency) {
		this.tranCurrency = tranCurrency;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public List<EcomOrderModel> getEcomOrders() {
		return ecomOrders;
	}

	public void setEcomOrders(List<EcomOrderModel> ecomOrders) {
		this.ecomOrders = ecomOrders;
	}

	public List<EcomTransactionEntryModel> getEcomTransactionEntries() {
		return ecomTransactionEntries;
	}

	public void setEcomTransactionEntries(
			List<EcomTransactionEntryModel> ecomTransactionEntries) {
		this.ecomTransactionEntries = ecomTransactionEntries;
	}
	
	

}
