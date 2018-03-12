package com.uru.app.model;


/**
 * @author Girish.Yadav
 *
 */
public class EcomLoginModel {
	private Long id;

	private String loginName;

	private String password;

	private EcomCustomerModel ecomCustomer;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EcomCustomerModel getEcomCustomer() {
		return ecomCustomer;
	}

	public void setEcomCustomer(EcomCustomerModel ecomCustomer) {
		this.ecomCustomer = ecomCustomer;
	}
}
