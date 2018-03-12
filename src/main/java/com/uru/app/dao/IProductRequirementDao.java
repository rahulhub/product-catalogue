package com.uru.app.dao;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomAlterationLiveModel;
import com.uru.app.model.EcomProductRequirementModel;

public interface IProductRequirementDao {

	IziResponse addProductRequirement(
			EcomProductRequirementModel ecomProductRequirementModel);

	IziResponse addAlternationLive(
			EcomAlterationLiveModel ecomAlterationLiveModel);

	List<EcomProductRequirementModel> findAllProductRequirement();

	List<EcomAlterationLiveModel> findAllAlternationLive();

}
