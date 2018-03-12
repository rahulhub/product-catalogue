package com.uru.app.business.impl;

import java.util.List;

import javax.inject.Inject;

import com.uru.app.business.service.IProductRequirementService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.IPinCodeDao;
import com.uru.app.dao.IProductRequirementDao;
import com.uru.app.model.EcomAlterationLiveModel;
import com.uru.app.model.EcomProductRequirementModel;

public class ProductRequirementImpl implements IProductRequirementService{
	
	@Inject 
	IProductRequirementDao productRequirementDao;

	@Override
	public IziResponse addProductRequirement(EcomProductRequirementModel ecomProductRequirementModel) {
		return productRequirementDao.addProductRequirement(ecomProductRequirementModel);
	}

	@Override
	public IziResponse addAlternationLive(EcomAlterationLiveModel ecomAlterationLiveModel) {
		return productRequirementDao.addAlternationLive(ecomAlterationLiveModel);
	}

	@Override
	public List<EcomProductRequirementModel> findAllProductRequirement() {
		return productRequirementDao.findAllProductRequirement();
	}

	@Override
	public List<EcomAlterationLiveModel> findAllAlternationLive() {
		return productRequirementDao.findAllAlternationLive();
	}

	

}
