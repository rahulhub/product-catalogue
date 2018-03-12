package com.uru.app.model;

import java.util.List;

import com.uru.app.entity.CustomerAddress;
import com.uru.app.entity.EcomLogin;

/**
 * @author Rahul Dev
 *
 */
public class EcomCustomerModel {

	private Long customerId;

	private String indiFirstName;
	
	private String indiLastName;
	
	private String indiMobileNum;
	
	private String firstContactFirstName;
	
	private String firstContactLastName;
	
	private String firstContactEmail;
	
	private String firstContactMobileNum;
	
	private String secondContactFirstName;
	
	private String secondContactLastName;
	
	private String secondContactEmail;
	
	private String secondContactMobileNum;
	
	private String customerType;

	private List<EcomLoginModel> ecomLogins;
	
	private List<CustomerAddressModel> addresses;
	
	private String jsonData;

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	/**
	 * @return the ecomLogins
	 */
	public List<EcomLoginModel> getEcomLogins() {
		return ecomLogins;
	}

	/**
	 * @param ecomLogins the ecomLogins to set
	 */
	public void setEcomLogins(List<EcomLoginModel> ecomLogins) {
		this.ecomLogins = ecomLogins;
	}

	/**
	 * @return the addresses
	 */
	public List<CustomerAddressModel> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<CustomerAddressModel> addresses) {
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
