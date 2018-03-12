package com.uru.app.business.impl;

import javax.inject.Inject;



import com.uru.app.business.service.IEmailService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.ICartDao;
import com.uru.app.dao.IEmailDao;
import com.uru.app.model.EcomEmailTemplateModel;
import com.uru.app.model.EcomPinCodeModel;

public class EmailServicecImpl implements IEmailService {

	@Inject
	IEmailDao emailDao;
	
	@Override
	public IziResponse addEmail(EcomEmailTemplateModel emailModel) {
		return emailDao.addEmail(emailModel);
	}

	@Override
	public IziResponse updateEmail(EcomEmailTemplateModel emailModel) {
		return emailDao.updateEmail(emailModel);
	}

	
}
