package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ecom_transaction database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region="EcomTransaction")
@Table(name="ecom_transaction")
@NamedQuery(name="EcomTransaction.findAll", query="SELECT e FROM EcomTransaction e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class EcomTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	private Long transactionId;

	@Column(name="BATCH_ID")
	private String batchId;

	@Column(name="CC_COMPANY")
	private String ccCompany;

	@Column(name="CC_DISPLAY_NUMBER")
	private String ccDisplayNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="CC_EXP_DATE")
	private Date ccExpDate;

	@Column(name="CC_NAME")
	private String ccName;

	@Column(name="CC_NUMBER")
	private String ccNumber;

	@Column(name="CC_TYPE")
	private String ccType;

	@Column(name="CITY")
	private String city;

	@Column(name="COUNTRY")
	private String country;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="GEOCODE")
	private String geocode;

	@Column(name="POBOX")
	private String pobox;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="STATE")
	private String state;

	@Column(name="STREET1")
	private String street1;

	@Column(name="STREET2")
	private String street2;

	@Column(name="TRAN_AMOUNT")
	private double tranAmount;

	@Column(name="TRAN_CURRENCY")
	private String tranCurrency;

	@Temporal(TemporalType.DATE)
	@Column(name="TRAN_DATE")
	private Date tranDate;

	@Column(name="TRAN_STATUS")
	private String tranStatus;

//	//bi-directional many-to-one association to EcomOrder
//	@OneToMany(mappedBy="ecomTransaction")
//	private List<EcomOrder> ecomOrders;

	//bi-directional many-to-one association to EcomTransactionEntry
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomTransaction")
	private List<EcomTransactionEntry> ecomTransactionEntries;

	public EcomTransaction() {
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCcCompany() {
		return this.ccCompany;
	}

	public void setCcCompany(String ccCompany) {
		this.ccCompany = ccCompany;
	}

	public String getCcDisplayNumber() {
		return this.ccDisplayNumber;
	}

	public void setCcDisplayNumber(String ccDisplayNumber) {
		this.ccDisplayNumber = ccDisplayNumber;
	}

	public Date getCcExpDate() {
		return this.ccExpDate;
	}

	public void setCcExpDate(Date ccExpDate) {
		this.ccExpDate = ccExpDate;
	}

	public String getCcName() {
		return this.ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getCcNumber() {
		return this.ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcType() {
		return this.ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGeocode() {
		return this.geocode;
	}

	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}

	public String getPobox() {
		return this.pobox;
	}

	public void setPobox(String pobox) {
		this.pobox = pobox;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public double getTranAmount() {
		return this.tranAmount;
	}

	public void setTranAmount(double tranAmount) {
		this.tranAmount = tranAmount;
	}

	public String getTranCurrency() {
		return this.tranCurrency;
	}

	public void setTranCurrency(String tranCurrency) {
		this.tranCurrency = tranCurrency;
	}

	public Date getTranDate() {
		return this.tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranStatus() {
		return this.tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

//	public List<EcomOrder> getEcomOrders() {
//		return this.ecomOrders;
//	}
//
//	public void setEcomOrders(List<EcomOrder> ecomOrders) {
//		this.ecomOrders = ecomOrders;
//	}

//	public EcomOrder addEcomOrder(EcomOrder ecomOrder) {
//		getEcomOrders().add(ecomOrder);
//		ecomOrder.setEcomTransaction(this);
//
//		return ecomOrder;
//	}
//
//	public EcomOrder removeEcomOrder(EcomOrder ecomOrder) {
//		getEcomOrders().remove(ecomOrder);
//		ecomOrder.setEcomTransaction(null);
//
//		return ecomOrder;
//	}

	public List<EcomTransactionEntry> getEcomTransactionEntries() {
		return this.ecomTransactionEntries;
	}

	public void setEcomTransactionEntries(List<EcomTransactionEntry> ecomTransactionEntries) {
		this.ecomTransactionEntries = ecomTransactionEntries;
	}

	public EcomTransactionEntry addEcomTransactionEntry(EcomTransactionEntry ecomTransactionEntry) {
		getEcomTransactionEntries().add(ecomTransactionEntry);
		ecomTransactionEntry.setEcomTransaction(this);

		return ecomTransactionEntry;
	}

	public EcomTransactionEntry removeEcomTransactionEntry(EcomTransactionEntry ecomTransactionEntry) {
		getEcomTransactionEntries().remove(ecomTransactionEntry);
		ecomTransactionEntry.setEcomTransaction(null);

		return ecomTransactionEntry;
	}

}