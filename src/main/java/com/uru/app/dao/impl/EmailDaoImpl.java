package com.uru.app.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.IEmailDao;
import com.uru.app.entity.EcomEmailTemplate;
import com.uru.app.entity.EcomLogin;
import com.uru.app.entity.EcomPinCode;
import com.uru.app.model.EcomEmailTemplateModel;

public class EmailDaoImpl implements IEmailDao {
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;


	@Override
	@Transactional
	public IziResponse addEmail(EcomEmailTemplateModel emailModel) {
		IziResponse resp=new IziResponse();
		resp.setMessage("Email not Added");
		resp.setStatus(false);
		resp.setResponse(null);
		
		if(emailModel == null){
			return resp;
		}
			
			EcomEmailTemplate ecomEmailTemplate = new EcomEmailTemplate();
			ecomEmailTemplate.setId(emailModel.getId());
			ecomEmailTemplate.setEmailName(emailModel.getEmailName());
			ecomEmailTemplate.setEmailDescription(emailModel.getEmailDescription());
			ecomEmailTemplate.setIsActive(emailModel.getIsActive());
			em.persist(ecomEmailTemplate);
			em.flush();
			resp.setMessage("Email Saved Successfully");
			resp.setStatus(true);
			resp.setObjectId(String.valueOf(ecomEmailTemplate.getId()));
			return resp;
		
	}


	@Override
	@Transactional
	public IziResponse updateEmail(EcomEmailTemplateModel emailModel) {
		IziResponse resp = new IziResponse();
		resp.setMessage("sorry,Id is not present");
		resp.setStatus(false);
		resp.setResponse(null);
		List<EcomEmailTemplate> ecomEmailTemp =  em
				.createNamedQuery("EcomEmailTemplate.findById")
				.setParameter("n", (Long)emailModel.getId()).getResultList();
		if(ecomEmailTemp.size() > 0){
			EcomEmailTemplate ecomEmailTemplate = new EcomEmailTemplate();
			ecomEmailTemplate.setId(emailModel.getId());
			ecomEmailTemplate.setEmailName(emailModel.getEmailName());
			ecomEmailTemplate.setEmailDescription(emailModel.getEmailDescription());
			ecomEmailTemplate.setIsActive(emailModel.getIsActive());
			em.merge(ecomEmailTemplate);
			resp.setMessage("Updation Successfull");
			resp.setStatus(true);
			resp.setResponse(null);
			resp.setObjectId(String.valueOf(ecomEmailTemplate.getId()));
		}
		
		return resp;
	}

}
