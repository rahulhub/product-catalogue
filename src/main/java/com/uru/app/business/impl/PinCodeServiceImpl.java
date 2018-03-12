package com.uru.app.business.impl;

import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.ICustomerDao;
import com.uru.app.dao.IPinCodeDao;
import com.uru.app.model.EcomLoginModel;
import com.uru.app.model.EcomPinCodeModel;


@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PinCodeServiceImpl implements com.uru.app.business.service.IPincodeService {
	@Inject 
	IPinCodeDao pinCodeDao;
	
	@Override
	public IziResponse createPinCode(EcomPinCodeModel ecomPinCodeModel) {
		return pinCodeDao.createPinCode(ecomPinCodeModel);
	}

	@Override
	public IziResponse updatePinCode(EcomPinCodeModel ecomPinCodeModel) {
		return pinCodeDao.updatePinCode(ecomPinCodeModel);
	}

	@Override
	public IziResponse findByPincode(int buyerPincode) {
		return pinCodeDao.findByPincode(buyerPincode);
	}

	
	@Override
	public List<EcomPinCodeModel> findAllPincode() {
		return pinCodeDao.findAllPincode();
	}

	@Override
	public IziResponse deletePincodeById(long buyerId) {
		return pinCodeDao.deletePincodeById(buyerId);
	}

	@Override
	public List<EcomPinCodeModel> getAllPincodeByCategory(long categoryId) {
		return pinCodeDao.getAllPincodeByCategory(categoryId);
	}

	@Override
	public List<EcomPinCodeModel> findByPincodeAndCategoryId(int buyerPincode,
			long categoryId) {
		return pinCodeDao.findByPincodeAndCategoryId(buyerPincode,categoryId);
	}

	

	

	

}
