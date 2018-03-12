package com.uru.app.business.service;


import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomEmailTemplateModel;
import com.uru.app.model.EcomPinCodeModel;

public interface IEmailService {

	IziResponse addEmail(EcomEmailTemplateModel emailModel);

	IziResponse updateEmail(EcomEmailTemplateModel emailModel);

}
