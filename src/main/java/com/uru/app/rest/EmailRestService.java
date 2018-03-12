package com.uru.app.rest;

import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.IEmailService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomEmailTemplateModel;
import com.uru.app.model.EcomPinCodeModel;



@Path("/emailService")
@Api(value = "/emailService")
@Produces(MediaType.APPLICATION_JSON)
public class EmailRestService {
	
	@Inject
	IEmailService emailService;
	
	@POST
	@Path("/addEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	public IziResponse addEmail(EcomEmailTemplateModel emailModel) {
		return emailService.addEmail(emailModel);
	}
	
	@POST
	@Path("/updateEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse updateEmail(EcomEmailTemplateModel emailModel) {
		return emailService.updateEmail(emailModel);
	}
	

}
