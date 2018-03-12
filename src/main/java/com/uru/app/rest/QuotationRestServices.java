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
import com.uru.app.business.service.IQuotationServices;
import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomQuotationModel;

@Path("/quotation")
@Api(value = "/quotation")
@Produces(MediaType.APPLICATION_JSON)
public class QuotationRestServices {
	
	@Inject
	IQuotationServices quotationServices;
	
	@POST
	@Path("/addQuotationData")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse addQuotationData(EcomQuotationModel quotationModel){
		return quotationServices.addQuotationData(quotationModel);
	}
	
	@POST
	@Path("/updateQuotationData")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse updateQuotationData(EcomQuotationModel quotationModel) {
		return quotationServices.updateQuotationData(quotationModel);
	}
	
	@POST
	@Path("/deleteQuotationeById")
	@Consumes(MediaType.APPLICATION_JSON)
	public IziResponse deleteQuotationeById(@QueryParam("Id") long Id) {
		return quotationServices.deleteQuotationeById(Id);
	}
	
	@GET
	@Path("/findAllQuotationWithPaging")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomQuotationModel> findAllQuotationWithPaging(@QueryParam("pageNumber") int pageNumber,@QueryParam("pageSize") int pageSize) {
		return quotationServices.findAllQuotationWithPaging(pageNumber,pageSize);
	}
	
	@GET
	@Path("/findQuotationByUserIdWithPaging")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomQuotationModel> findQuotationByUserIdWithPaging(@QueryParam("userId") Long userId,@QueryParam("pageNumber") int pageNumber,@QueryParam("pageSize") int pageSize) {
		return quotationServices.findQuotationByUserIdWithPaging(userId,pageNumber,pageSize);
	}

}
