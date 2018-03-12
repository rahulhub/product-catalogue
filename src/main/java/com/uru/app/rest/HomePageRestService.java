package com.uru.app.rest;

import io.swagger.annotations.Api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.IHomepageService;
import com.uru.app.model.EcomProductModel;
import com.uru.app.model.HomePageProductModel;

@Path("/homepage")
@Api(value = "/homepage")
@Produces(MediaType.APPLICATION_JSON)
public class HomePageRestService {
	@Inject
	IHomepageService homepageService;


	@GET
	@Path("/getAllHomePageProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HomePageProductModel> getAllHomePageProduct() {
		return homepageService.getAllHomePageProduct();
	}
	
	@POST
	@Path("/createHomePageProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createHomePageProduct(HomePageProductModel homepageProductModel) {
		return homepageService.createHomePageProduct(homepageProductModel);
	}
	
	@POST
	@Path("/updateHomePageProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateHomePageProduct(HomePageProductModel homePageProductModel) {

		return homepageService.updateHomePageProduct(homePageProductModel);
	}
	
}
