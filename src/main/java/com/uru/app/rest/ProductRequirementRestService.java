package com.uru.app.rest;

import java.util.List;

import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.IPincodeService;
import com.uru.app.business.service.IProductRequirementService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomAlterationLiveModel;
import com.uru.app.model.EcomPinCodeModel;
import com.uru.app.model.EcomProductRequirementModel;

@Path("/prodReqirement")
@Api(value = "/prodReqirement")
@Produces(MediaType.APPLICATION_JSON)
public class ProductRequirementRestService {
	
	@Inject
	IProductRequirementService productRequirementService;
	
	@POST
	@Path("/addProductRequirement")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse addProductRequirement(EcomProductRequirementModel ecomProductRequirementModel){
		return productRequirementService.addProductRequirement(ecomProductRequirementModel);
	}
	
	@POST
	@Path("/addAlternationLive")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse addAlternationLive(EcomAlterationLiveModel ecomAlterationLiveModel){
		return productRequirementService.addAlternationLive(ecomAlterationLiveModel);
	}
	
	@GET
	@Path("/findAllProductRequirement")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomProductRequirementModel> findAllProductRequirement() {
		return productRequirementService.findAllProductRequirement();
	}
	
	
	@GET
	@Path("/findAllAlternationLive")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomAlterationLiveModel> findAllAlternationLive() {
		return productRequirementService.findAllAlternationLive();
	}
	
	
}
