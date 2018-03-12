package com.uru.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.AESCCryption;
import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.business.util.ValocityTemplate;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.ICustomerDao;
import com.uru.app.entity.CustomerAddress;
import com.uru.app.entity.EcomCustomer;
import com.uru.app.entity.EcomCustomerShippingAddress;
import com.uru.app.entity.EcomLogin;
import com.uru.app.model.CustomerAddressModel;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomCustomerShippingAddressModel;
import com.uru.app.model.EcomLoginModel;

public class CustomerDaoImpl implements ICustomerDao {
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;

	@Override
	public void registerUser(String loginId, String password) {
		
		
		
	}

	@Override
	public EcomCustomerModel updateUserDetails(EcomLoginModel ecomLoginModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EcomCustomerModel getCustomerDetails(String loginName) {
		Query query = em.createNamedQuery("EcomLogin.findByLoginName");
		query.setParameter("n", loginName);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_LOGIN_BY_NAME);
		
		EcomLogin ecomLogin = (EcomLogin)query.getSingleResult();
		
		query=em.createNamedQuery("EcomCustomer.findByLoginId");
		query.setParameter("n", ecomLogin.getId());
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_LOGIN_BY_ID);
		
		EcomCustomer ecomCust = (EcomCustomer)query.getSingleResult();
		
		return e2m.convertCustomerToModel(ecomCust);
	}

	@Override
	public IziResponse createUserLogin(String loginId, String password) throws Exception {
		IziResponse resp = new IziResponse();
		resp.setMessage("Already registered user");
		resp.setStatus(false);
		resp.setResponse(null);
		if(null == loginId && null == password){
			throw new UruApplicationException("Kindly provide both login and password");
		}
		Query query =  em.createNamedQuery("EcomLogin.findByLoginName");
		query.setParameter("n", loginId);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_LOGIN_BY_NAME);
		List<EcomLogin> ecomLogins = query.getResultList();
		
		if(ecomLogins.size() <= 0){
			
			EcomLogin ecomLogin = new EcomLogin();
			ecomLogin.setLoginName(loginId);
			ecomLogin.setPassword(AESCCryption.encrypt(password));
			em.persist(ecomLogin);
			em.flush();
			resp.setMessage("User registered Successfully");
			resp.setStatus(true);
			resp.setObjectId(String.valueOf(ecomLogin.getId()));
			//resp.setResponse(e2m.convertLoginToModle(ecomLogins));
			String to_mail=ecomLogin.getLoginName();
			String account_email="accounts@izigro.com";
			String[] mailAddressTo={to_mail,account_email};  //can put multiple receivers in the array
			ValocityTemplate.notify("registrationTemplate.vm",mailAddressTo);
			return resp;
			
		}
		
		return resp;
	}

	@Override
	@Transactional
	public EcomCustomerModel addCustomerDetails(EcomCustomerModel ecomCust) { 
		
		EcomCustomer ecomCustEntity = m2e.convertCustomerToEntity(ecomCust);
		em.persist(ecomCustEntity);
		em.flush();
		Query query = em.createNamedQuery("EcomLogin.findByLoginName");
		query.setParameter("n", ecomCust.getEcomLogins().get(0).getLoginName());
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_LOGIN_BY_NAME);
		EcomLogin ecomLogin = (EcomLogin) query.getSingleResult();
		
		ecomLogin.setEcomCustomer(ecomCustEntity);
		EcomLogin ecomLoginUpdated = em.merge(ecomLogin);
		return e2m.convertCustomerToModel(ecomLoginUpdated.getEcomCustomer());
	}

	@Override
	public EcomCustomerModel addCustomerAddress(CustomerAddressModel ecomCustAdd) {
		
		Query query =  em.createNamedQuery("EcomLogin.findByLoginName");
		query.setParameter("n", ecomCustAdd.getLoginName());
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_LOGIN_BY_NAME);
		EcomLogin ecomLogin = (EcomLogin)query.getSingleResult();
		
		Query query1 =em.createNamedQuery("EcomCustomer.findByLoginId");
		query1.setParameter("n", ecomLogin.getId());
		CacheHelper.formQueryCache(query1, UruAppConstants.ECOM_LOGIN_BY_ID);
		EcomCustomer ecomCust = (EcomCustomer)query1.getSingleResult();
		
		CustomerAddress custAdd = m2e.convertAddressToEntity(ecomCustAdd);
		
		ecomCust.getAddresses().add(custAdd);
		
		EcomCustomer returnCust = em.merge(ecomCust);
		return e2m.convertCustomerToModel(returnCust);
	}

	@Override
	public EcomCustomerModel updateCustomer(EcomCustomerModel ecomCust) {
		EcomCustomer ecomCustEn = m2e.convertCustomerToEntity(ecomCust);
		return e2m.convertCustomerToModel(em.merge(ecomCustEn));
		//return em.merge(ecomCustEn);
	}

	@Override
	public EcomLoginModel getLoginDetails(String loginName) {
		Query query =em.createNamedQuery("EcomLogin.findByLoginName");
		query.setParameter("n", loginName);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_LOGIN_BY_NAME);
		List<EcomLogin> ecomLogins =  query.getResultList();
		
		if(ecomLogins.size() > 0){
			
			return e2m.convertLoginToModle(ecomLogins.get(0));
			
		}
		
		return null;
	}

	@Override
	public List<EcomCustomerModel> getAllCustomerDetails() {
		Query query =em.createNamedQuery("EcomCustomer.findAll");
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_FIND_ALL);
		List<EcomCustomer> ecomCustList = (List<EcomCustomer>) query.getResultList();
		List<EcomCustomerModel> ecomCustModelList = new ArrayList<EcomCustomerModel>();
		for(EcomCustomer ecomCust : ecomCustList){
			ecomCustModelList.add(e2m.convertCustomerToModel(ecomCust));
		}
		return ecomCustModelList;
	}

	@Override
	public CustomerAddress updateCustomerAdddress(CustomerAddressModel ecomCustAddr) {
		CustomerAddress ecomCustAddrEn = m2e.convertAddressToEntity(ecomCustAddr);
		return em.merge(ecomCustAddrEn);
	}

	@Override
	public EcomCustomerShippingAddress updateCustomerShippingAdddress(EcomCustomerShippingAddressModel ecomCustShipping) {
		EcomCustomerShippingAddress ecomCustShippAddrEn = m2e.convertCustomerShippingAddressToEntity(ecomCustShipping);
		return em.merge(ecomCustShippAddrEn);
	}

	@Override
	public IziResponse changeLoginPassword(EcomLoginModel ecomLoginModel) throws Exception {
		IziResponse resp = new IziResponse();
		resp.setMessage("Already registered user");
		resp.setStatus(false);
		resp.setResponse(null);
		List<EcomLogin> ecomLogin =  em
				.createNamedQuery("EcomLogin.findByLoginId")
				.setParameter("n", (Long)ecomLoginModel.getId()).getResultList();
		
		if(ecomLogin.size() > 0){
			EcomLogin ecomLn = new EcomLogin();
			ecomLn.setId(ecomLoginModel.getId());
			ecomLn.setLoginName(ecomLoginModel.getLoginName());
			ecomLn.setPassword(AESCCryption.encrypt(ecomLoginModel.getPassword()));
			em.merge(ecomLn);
			resp.setMessage("User updated Successfully");
			resp.setStatus(true);
			resp.setObjectId(String.valueOf(ecomLoginModel.getId()));
			String to_mail=ecomLn.getLoginName();
			String cc_mail="";
			//ValocityTemplate.notify("changePassword.vm",to_mail,cc_mail);
			return resp;
		}
		return resp;
	}
	
	@Override
	public IziResponse forgotPasword(String loginName) throws Exception{
		
		IziResponse resp = new IziResponse();
		resp.setMessage("user doesn't exist");
		resp.setStatus(false);
		resp.setResponse(null);
			
			Query query = (Query) em.createQuery("Select login from EcomLogin login where login.loginName=:loginName");
			query.setParameter("loginName",loginName);
			List<EcomLogin> result = (List<EcomLogin>) query.getResultList();
			
			for(EcomLogin ecomLogin: result)
			{
				String pwd=AESCCryption.decrypt(ecomLogin.getPassword());
				resp.setMessage("User exist");
				resp.setStatus(true);
				resp.setResponse(pwd);
				String to_mail=loginName;
				String[] mailAddressTo={to_mail};
				ValocityTemplate.forgotPasswordnotify("forgot_Password.vm",loginName,pwd,mailAddressTo);
				return resp;
			}
			return resp;	
	}

}
