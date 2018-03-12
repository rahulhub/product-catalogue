package com.uru.app.rest;

import java.util.List;

import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.IPincodeService;
import com.uru.app.business.service.IProductService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomLoginModel;
import com.uru.app.model.EcomPinCodeModel;
import com.uru.app.model.EcomProductModel;

@Path("/pinCode")
@Api(value = "/pinCode")
@Produces(MediaType.APPLICATION_JSON)
public class PinCodeRestService {

	@Inject
	IPincodeService pincodeService;

	@POST
	@Path("/createPinCode")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse createPinCode(EcomPinCodeModel ecomPinCodeModel){
		return pincodeService.createPinCode(ecomPinCodeModel);
	}
	
	@POST
	@Path("/updatePinCode")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse updatePinCode(EcomPinCodeModel ecomPinCodeModel) {
		return pincodeService.updatePinCode(ecomPinCodeModel);
	}
	
	@POST
	@Path("/deletePincodeById")
	@Consumes(MediaType.APPLICATION_JSON)
	public IziResponse deletePincodeById(@QueryParam("buyerId") long buyerId) {

		return pincodeService.deletePincodeById(buyerId);
	}

	
	@GET
	@Path("/findByPincode")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse findByPincode(@QueryParam("buyerPincode") int buyerPincode) {
		return pincodeService.findByPincode(buyerPincode);
	}
	
	@GET
	@Path("/findAllPincode")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomPinCodeModel> findAllPincode() {
		return pincodeService.findAllPincode();
	}
	
	@GET
	@Path("/findByPincodeAndCategoryId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomPinCodeModel> findByPincodeAndCategoryId(@QueryParam("buyerPincode") int buyerPincode,@QueryParam("categoryId") long categoryId) {
		return pincodeService.findByPincodeAndCategoryId(buyerPincode,categoryId);
	}
	
	@GET
	@Path("/getAllPincodeByCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomPinCodeModel> getAllPincodeByCategory(@QueryParam("categoryId") long categoryId) {
		return pincodeService.getAllPincodeByCategory(categoryId);
	}
}
