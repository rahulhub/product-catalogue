package com.uru.app.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.entity.CustomerAddress;
import com.uru.app.entity.EcomCustomer;
import com.uru.app.entity.EcomCustomerShippingAddress;
import com.uru.app.entity.EcomLogin;
import com.uru.app.model.CustomerAddressModel;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomCustomerShippingAddressModel;
import com.uru.app.model.EcomLoginModel;

public interface ICustomerDao {
	
	void registerUser(String loginId, String password);
	EcomCustomerModel updateUserDetails(EcomLoginModel ecomLoginModel);
	EcomCustomerModel getCustomerDetails(String loginId);
	IziResponse createUserLogin(String loginId, String password) throws NoSuchAlgorithmException, Exception;
	
	EcomCustomerModel addCustomerDetails(EcomCustomerModel ecomCust);
	EcomCustomerModel addCustomerAddress(CustomerAddressModel ecomCustAdd);
	EcomCustomerModel updateCustomer(EcomCustomerModel ecomCust);
	
	EcomLoginModel getLoginDetails(String loginName);
	List<EcomCustomerModel> getAllCustomerDetails();
	CustomerAddress updateCustomerAdddress(CustomerAddressModel ecomCustAddr);
	EcomCustomerShippingAddress updateCustomerShippingAdddress(EcomCustomerShippingAddressModel ecomCustShipping);
	IziResponse changeLoginPassword(EcomLoginModel ecomLoginModel) throws Exception;
	IziResponse forgotPasword(String loginName)throws Exception;
	
} 
