package com.uru.app.business.impl;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.uru.app.business.service.ICustomerService;
import com.uru.app.dao.ICustomerDao;
import com.uru.app.entity.CustomerAddress;
import com.uru.app.entity.EcomCustomer;
import com.uru.app.entity.EcomCustomerShippingAddress;
import com.uru.app.model.CustomerAddressModel;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomCustomerShippingAddressModel;

@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CustomerServiceImpl implements ICustomerService {

	@Inject
	ICustomerDao customerDao;
	
	@Override
	public EcomCustomerModel addCustomerDetails(EcomCustomerModel ecomCust) {
		return customerDao.addCustomerDetails(ecomCust);
	}

	@Override
	public EcomCustomerModel addCustomerAddress(CustomerAddressModel ecomCustAdd) {
		return customerDao.addCustomerAddress(ecomCustAdd);
	}

	@Override
	@Transactional
	public EcomCustomerModel updateCustomer(EcomCustomerModel ecomCust) {
		return customerDao.updateCustomer(ecomCust);
	}

	@Override
	@Transactional
	public CustomerAddress updateCustomerAdddress(CustomerAddressModel ecomCustAddr) {
		return customerDao.updateCustomerAdddress(ecomCustAddr);
	}

	@Override
	@Transactional
	public EcomCustomerShippingAddress updateCustomerShippingAdddress(EcomCustomerShippingAddressModel ecomCustShipping) {
		return customerDao.updateCustomerShippingAdddress(ecomCustShipping);
	}

	

}
