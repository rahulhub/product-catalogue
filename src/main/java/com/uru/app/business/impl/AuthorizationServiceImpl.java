package com.uru.app.business.impl;


import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.uru.app.business.service.IAuthorizationService;
import com.uru.app.business.util.AESCCryption;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.ICustomerDao;
import com.uru.app.entity.EcomLogin;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomLoginModel;

@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AuthorizationServiceImpl implements IAuthorizationService {
	
	@Inject 
	ICustomerDao customerDao;

	@Override
	public EcomCustomerModel getUserDetails(String loginName) {
		return customerDao.getCustomerDetails(loginName);
	}

	@Override
	public boolean deleteUserDetails(String loginName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserDetails(EcomLoginModel ecomLoginModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUserDetails(EcomLoginModel ecomLoginModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IziResponse authenticateUser(EcomLogin ecomLogin) throws Exception {
		
		IziResponse resp = new IziResponse();
		resp.setMessage("Authentication Unsuccessful");
		resp.setStatus(false);
		resp.setResponse(null);
		EcomLoginModel ecomLn = customerDao.getLoginDetails(ecomLogin.getLoginName());
		if(ecomLn != null && AESCCryption.decrypt(ecomLn.getPassword()).equals(ecomLogin.getPassword())){
			
			resp.setMessage("Authentication Successful");
			resp.setStatus(true);
			resp.setResponse(null);
			resp.setObjectId(String.valueOf(ecomLn.getId()));
			return resp;
		}
		return resp;
	}

	@Override
	public IziResponse createUserLogin(EcomLoginModel ecomLogin) throws Exception {
		return customerDao.createUserLogin(ecomLogin.getLoginName(), ecomLogin.getPassword());
	}

	@Override
	public List<EcomCustomerModel> getAllUserDetails() {
		return customerDao.getAllCustomerDetails();
	}

	@Override
	public IziResponse changeLoginPassword(EcomLoginModel ecomLoginModel) throws Exception {
		return customerDao.changeLoginPassword(ecomLoginModel);
	}

	@Override
	public IziResponse forgotPasword(String loginName)throws Exception{
		return customerDao.forgotPasword(loginName);
	}

}
