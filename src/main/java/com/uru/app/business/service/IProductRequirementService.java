package com.uru.app.business.service;

import java.util.List;

import javax.inject.Inject;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomAlterationLiveModel;
import com.uru.app.model.EcomProductRequirementModel;

public interface IProductRequirementService {

	IziResponse addProductRequirement(
			EcomProductRequirementModel ecomProductRequirementModel);

	IziResponse addAlternationLive(EcomAlterationLiveModel ecomAlterationLiveModel);

	List<EcomProductRequirementModel> findAllProductRequirement();

	List<EcomAlterationLiveModel> findAllAlternationLive();
	
	

}
