package com.uru.app.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.IAuthorizationService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.entity.EcomLogin;
import com.uru.app.model.EcomCustomerModel;
import com.uru.app.model.EcomLoginModel;

import io.swagger.annotations.Api;

/**
 * @author Girish.Yadav
 *
 */
@Path("/auth")
@Api(value = "/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorizationRestService {

	@Inject
	private IAuthorizationService authorizationService;


	@GET
	@Path("/getUserDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	public EcomCustomerModel getUsereDetails(@QueryParam("loginName") String loginName) {
		return authorizationService.getUserDetails(loginName);
	}
	
	@POST
	@Path("/createUserDetails")
	public boolean	createUserDetails(EcomLoginModel ecomLoginModel) {
		return authorizationService.createUserDetails(ecomLoginModel);
	}
	
	@POST
	@Path("/updateUserDetails")
	public boolean	updateUserDetails(EcomLoginModel ecomLoginModel) {
		return authorizationService.updateUserDetails(ecomLoginModel);
	}
	
	@POST
	@Path("/deleteUserDetails")
	public boolean	deleteUserDetails(@QueryParam("loginName") String loginName) {
		return authorizationService.deleteUserDetails(loginName);
	}
	
	
	@POST
	@Path("/authenticateUser")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse authenticateUser(EcomLogin ecomLogin) throws Exception {
		return authorizationService.authenticateUser(ecomLogin);
	}
	
	
}
