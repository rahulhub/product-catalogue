package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ecom_customer database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomCustomer")
@Table(name="ecom_customer")
@NamedQueries({
@NamedQuery(name="EcomCustomer.findAll", query="SELECT e FROM EcomCustomer e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomCustomer.findByLoginId", query="SELECT e FROM EcomCustomer e WHERE e.customerId in (select lc.ecomCustomer.customerId from EcomLogin lc WHERE lc.id = :n)", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomCustomer.findById", query="SELECT e FROM EcomCustomer e WHERE e.customerId =:n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
})
public class EcomCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="indi_first_name")
	private String indiFirstName;
	
	@Column(name="indi_last_name")
	private String indiLastName;
	
	@Column(name="indi_mobile_num")
	private String indiMobileNum;
	
	@Column(name="first_contact_fname")
	private String firstContactFirstName;
	
	@Column(name="first_contact_lname")
	private String firstContactLastName;
	
	@Column(name="first_contact_email")
	private String firstContactEmail;
	
	@Column(name="first_contact_mobile")
	private String firstContactMobileNum;
	
	@Column(name="second_contact_fname")
	private String secondContactFirstName;
	
	@Column(name="second_contact_lname")
	private String secondContactLastName;
	
	@Column(name="second_contact_email")
	private String secondContactEmail;
	
	@Column(name="second_contact_mobile")
	private String secondContactMobileNum;
	
	@Column(name="CUSTOMER_TYPE")
	private String customerType;


	//bi-directional many-to-one association to EcomLogin
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="ecomCustomer")
	private List<EcomLogin> ecomLogins;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	private List<CustomerAddress> addresses = new ArrayList<CustomerAddress>();
	
	@Column(name="json_data",length = 4000)
	private String jsonData;
	

	public EcomCustomer() {
	}
	
	public EcomCustomer(Long customerId) {
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}


	public List<EcomLogin> getEcomLogins() {
		return this.ecomLogins;
	}

	public void setEcomLogins(List<EcomLogin> ecomLogins) {
		this.ecomLogins = ecomLogins;
	}
	
	
	/**
	 * @return the indiFirstName
	 */
	public String getIndiFirstName() {
		return indiFirstName;
	}

	/**
	 * @param indiFirstName the indiFirstName to set
	 */
	public void setIndiFirstName(String indiFirstName) {
		this.indiFirstName = indiFirstName;
	}

	/**
	 * @return the indiLastName
	 */
	public String getIndiLastName() {
		return indiLastName;
	}

	/**
	 * @param indiLastName the indiLastName to set
	 */
	public void setIndiLastName(String indiLastName) {
		this.indiLastName = indiLastName;
	}

	/**
	 * @return the indiMobileNum
	 */
	public String getIndiMobileNum() {
		return indiMobileNum;
	}

	/**
	 * @param indiMobileNum the indiMobileNum to set
	 */
	public void setIndiMobileNum(String indiMobileNum) {
		this.indiMobileNum = indiMobileNum;
	}

	/**
	 * @return the firstContactFirstName
	 */
	public String getFirstContactFirstName() {
		return firstContactFirstName;
	}

	/**
	 * @param firstContactFirstName the firstContactFirstName to set
	 */
	public void setFirstContactFirstName(String firstContactFirstName) {
		this.firstContactFirstName = firstContactFirstName;
	}

	/**
	 * @return the firstContactLastName
	 */
	public String getFirstContactLastName() {
		return firstContactLastName;
	}

	/**
	 * @param firstContactLastName the firstContactLastName to set
	 */
	public void setFirstContactLastName(String firstContactLastName) {
		this.firstContactLastName = firstContactLastName;
	}

	/**
	 * @return the firstContactEmail
	 */
	public String getFirstContactEmail() {
		return firstContactEmail;
	}

	/**
	 * @param firstContactEmail the firstContactEmail to set
	 */
	public void setFirstContactEmail(String firstContactEmail) {
		this.firstContactEmail = firstContactEmail;
	}

	/**
	 * @return the firstContactMobileNum
	 */
	public String getFirstContactMobileNum() {
		return firstContactMobileNum;
	}

	/**
	 * @param firstContactMobileNum the firstContactMobileNum to set
	 */
	public void setFirstContactMobileNum(String firstContactMobileNum) {
		this.firstContactMobileNum = firstContactMobileNum;
	}

	/**
	 * @return the secondContactFirstName
	 */
	public String getSecondContactFirstName() {
		return secondContactFirstName;
	}

	/**
	 * @param secondContactFirstName the secondContactFirstName to set
	 */
	public void setSecondContactFirstName(String secondContactFirstName) {
		this.secondContactFirstName = secondContactFirstName;
	}

	/**
	 * @return the secondContactLastName
	 */
	public String getSecondContactLastName() {
		return secondContactLastName;
	}

	/**
	 * @param secondContactLastName the secondContactLastName to set
	 */
	public void setSecondContactLastName(String secondContactLastName) {
		this.secondContactLastName = secondContactLastName;
	}

	/**
	 * @return the secondContactEmail
	 */
	public String getSecondContactEmail() {
		return secondContactEmail;
	}

	/**
	 * @param secondContactEmail the secondContactEmail to set
	 */
	public void setSecondContactEmail(String secondContactEmail) {
		this.secondContactEmail = secondContactEmail;
	}

	/**
	 * @return the secondContactMobileNum
	 */
	public String getSecondContactMobileNum() {
		return secondContactMobileNum;
	}

	/**
	 * @param secondContactMobileNum the secondContactMobileNum to set
	 */
	public void setSecondContactMobileNum(String secondContactMobileNum) {
		this.secondContactMobileNum = secondContactMobileNum;
	}

	/**
	 * @return the addresses
	 */
	public List<CustomerAddress> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<CustomerAddress> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the jsonData
	 */
	public String getJsonData() {
		return jsonData;
	}

	/**
	 * @param jsonData the jsonData to set
	 */
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}


}