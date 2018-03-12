package com.uru.app.business.service;

import com.uru.app.entity.CustomerAddress;
import com.uru.app.entity.EcomCustomer;
import com.uru.app.entity.EcomCustomerShippingAddress;
import com.uru.app.model.CustomerAddressModel;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomCustomerShippingAddressModel;

/**
 * @author Rahul Dev
 *
 */
public interface ICustomerService {
	
	EcomCustomerModel addCustomerDetails(EcomCustomerModel ecomCust);
	EcomCustomerModel addCustomerAddress(CustomerAddressModel ecomCustAdd);
	EcomCustomerModel updateCustomer(EcomCustomerModel ecomCust);
	CustomerAddress updateCustomerAdddress(CustomerAddressModel ecomCust);
	EcomCustomerShippingAddress updateCustomerShippingAdddress(EcomCustomerShippingAddressModel ecomCustShipping);

}
