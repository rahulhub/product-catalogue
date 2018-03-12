package com.uru.app.business.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.entity.EcomLogin;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomLoginModel;

/**
 * @author Girish.Yadav
 *
 */
public interface IAuthorizationService {
	
	public EcomCustomerModel getUserDetails(String loginName);

	public boolean deleteUserDetails(String loginName);

	public boolean updateUserDetails(EcomLoginModel ecomLoginModel);

	public boolean createUserDetails(EcomLoginModel ecomLoginModel);
	
	IziResponse authenticateUser(EcomLogin ecomLogin) throws Exception;
	
	IziResponse createUserLogin(EcomLoginModel ecomLogin) throws NoSuchAlgorithmException, Exception;

	public List<EcomCustomerModel> getAllUserDetails();

	public IziResponse changeLoginPassword(EcomLoginModel ecomLoginModel)throws Exception ;

	public IziResponse forgotPasword(String loginName)throws Exception;

	
	
}
