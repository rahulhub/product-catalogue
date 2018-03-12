package com.uru.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.IProductRequirementDao;
import com.uru.app.entity.EcomAlterationLive;
import com.uru.app.entity.EcomEmailTemplate;
import com.uru.app.entity.EcomPinCode;
import com.uru.app.entity.EcomProductRequirement;
import com.uru.app.model.EcomAlterationLiveModel;
import com.uru.app.model.EcomPinCodeModel;
import com.uru.app.model.EcomProductRequirementModel;

public class ProductRequirementDaoImpl implements IProductRequirementDao {

	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;
	
	@Override
	@Transactional
	public IziResponse addProductRequirement(EcomProductRequirementModel ecomProductRequirementModel) {
		IziResponse resp=new IziResponse();
		resp.setMessage("Data not Saved Successfully");
		resp.setStatus(false);
		resp.setResponse(null);
		
		if(ecomProductRequirementModel == null){
			return resp;
		}
			
		EcomProductRequirement ecomProdReq= new EcomProductRequirement();
			ecomProdReq.setId(ecomProductRequirementModel.getId());
			ecomProdReq.setUserId(ecomProductRequirementModel.getUserId());
			ecomProdReq.setUserName(ecomProductRequirementModel.getUserName());
			ecomProdReq.setEmailId(ecomProductRequirementModel.getEmailId());
			ecomProdReq.setMobileNo(ecomProductRequirementModel.getMobileNo());
			ecomProdReq.setJsonData(ecomProductRequirementModel.getJsonData());
			em.persist(ecomProdReq);
			em.flush();
			resp.setMessage("Data Saved Successfully");
			resp.setStatus(true);
			resp.setObjectId(String.valueOf(ecomProdReq.getId()));
			return resp;
	}

	@Override
	@Transactional
	public IziResponse addAlternationLive(EcomAlterationLiveModel ecomAlterationLiveModel) {
		IziResponse resp=new IziResponse();
		resp.setMessage("Data not Saved Successfully");
		resp.setStatus(false);
		resp.setResponse(null);
		
		if(ecomAlterationLiveModel == null){
			return resp;
		}
			
			EcomAlterationLive ecomAltLive= new EcomAlterationLive();
			ecomAltLive.setId(ecomAlterationLiveModel.getId());
			ecomAltLive.setUserName(ecomAlterationLiveModel.getUserName());
			ecomAltLive.setEmailId(ecomAlterationLiveModel.getEmailId());
			ecomAltLive.setMobileNo(ecomAlterationLiveModel.getMobileNo());
			ecomAltLive.setJsonData(ecomAlterationLiveModel.getJsonData());
			em.persist(ecomAltLive);
			em.flush();
			resp.setMessage("Data Saved Successfully");
			resp.setStatus(true);
			resp.setObjectId(String.valueOf(ecomAltLive.getId()));
			return resp;
	}

	@Override
	public List<EcomProductRequirementModel> findAllProductRequirement() {
		Query query = em.createNamedQuery("EcomProductRequirement.findAll", EcomProductRequirement.class);
		List<EcomProductRequirement> ecomProductRequirement = query.getResultList();
		if (ecomProductRequirement != null && ecomProductRequirement.size() > 0) {
			List<EcomProductRequirementModel> models = new ArrayList<EcomProductRequirementModel>();
			for (EcomProductRequirement pc : ecomProductRequirement) {
				models.add(e2m.convertProductRequirementToModel(pc));
			}
			return models;
		}
		return null;
	}

	@Override
	public List<EcomAlterationLiveModel> findAllAlternationLive() {
		Query query = em.createNamedQuery("EcomAlterationLive.findAll", EcomAlterationLive.class);
		List<EcomAlterationLive> ecomAlterationLive = query.getResultList();
		if (ecomAlterationLive != null && ecomAlterationLive.size() > 0) {
			List<EcomAlterationLiveModel> models = new ArrayList<EcomAlterationLiveModel>();
			for (EcomAlterationLive pc : ecomAlterationLive) {
				models.add(e2m.convertEcomAlterationLiveToModel(pc));
			}
			return models;
		}
		return null;
	}

}
