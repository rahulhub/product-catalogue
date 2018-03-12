package com.uru.app.dao;


import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomEmailTemplateModel;

public interface IEmailDao {

	IziResponse addEmail(EcomEmailTemplateModel emailModel);

	IziResponse updateEmail(EcomEmailTemplateModel emailModel);

}
