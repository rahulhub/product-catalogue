package com.uru.app.rest;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.IAuthorizationService;
import com.uru.app.business.service.ICustomerService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.entity.CustomerAddress;
import com.uru.app.entity.EcomCustomerShippingAddress;
import com.uru.app.model.CustomerAddressModel;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomCustomerShippingAddressModel;
import com.uru.app.model.EcomLoginModel;

import io.swagger.annotations.Api;

@Path("/customerService")
@Api(value = "/customerService")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRestService {
	
	@Inject
	IAuthorizationService authService;
	
	@Inject
	ICustomerService custService;
	
	
	@POST
	@Path("/createUserLogin")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse createUserLogin(EcomLoginModel ecomLogin) throws Exception{
		return authService.createUserLogin(ecomLogin);
	}
	
	@POST
	@Path("/changeLoginPassword")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse changeLoginPassword(EcomLoginModel ecomLoginModel) throws Exception{
		return authService.changeLoginPassword(ecomLoginModel);
	}
	
	
	@POST
	@Path("/addCustomerDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public EcomCustomerModel addCustomerDetails(EcomCustomerModel ecomCust){
		return custService.addCustomerDetails(ecomCust);
	}
	
	@POST
	@Path("/addCustomerAddress")
	@Produces(MediaType.APPLICATION_JSON)
	public EcomCustomerModel addCustomerAddress(CustomerAddressModel ecomCustAdd){
		return custService.addCustomerAddress(ecomCustAdd);
	}
	
	@POST
	@Path("/updateCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public EcomCustomerModel updateCustomer(EcomCustomerModel ecomCust){
		return custService.updateCustomer(ecomCust);
	}
	
	@POST
	@Path("/updateCustomerAdddress")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerAddress updateCustomerAdddress(CustomerAddressModel ecomCust){
		return custService.updateCustomerAdddress(ecomCust);
	}
	
	@POST
	@Path("/updateCustomerShippingAdddress")
	@Produces(MediaType.APPLICATION_JSON)
	public EcomCustomerShippingAddress updateCustomerShippingAdddress(EcomCustomerShippingAddressModel ecomCustShipping){
		return custService.updateCustomerShippingAdddress(ecomCustShipping);
	}
	
	@GET
	@Path("/getCustomerDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public EcomCustomerModel getCustomerDetails(@QueryParam(value = "loginName") String loginName){
		return authService.getUserDetails(loginName);
	}
	
	@GET
	@Path("/getAllCustomerDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomCustomerModel> getAllCustomerDetails(){
		return authService.getAllUserDetails();
	}
	
	
	@GET
	@Path("/forgotPasword")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse forgotPasword(@QueryParam("loginName") String loginName)throws Exception{
		return authService.forgotPasword(loginName);
	}
	

}
