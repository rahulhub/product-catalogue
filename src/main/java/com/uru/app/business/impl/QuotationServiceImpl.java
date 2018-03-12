package com.uru.app.business.impl;

import java.util.List;

import javax.inject.Inject;

import com.uru.app.business.service.IQuotationServices;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.IProductRequirementDao;
import com.uru.app.dao.IQuotationDao;
import com.uru.app.model.EcomOrderModel;
import com.uru.app.model.EcomQuotationModel;

public class QuotationServiceImpl implements IQuotationServices {
	
	@Inject 
	IQuotationDao quotationDao;

	@Override
	public IziResponse addQuotationData(EcomQuotationModel quotationModel) {
		return quotationDao.addQuotationData(quotationModel);
		
	}

	@Override
	public IziResponse updateQuotationData(EcomQuotationModel quotationModel) {
		return quotationDao.updateQuotationData(quotationModel);
	}

	@Override
	public IziResponse deleteQuotationeById(long Id) {
		return quotationDao.deleteQuotationeById(Id);
	}

	@Override
	public List<EcomQuotationModel> findAllQuotationWithPaging(int pageNumber,int pageSize) {
		return quotationDao.findAllQuotationWithPaging(pageNumber,pageSize);
	}

	@Override
	public List<EcomQuotationModel> findQuotationByUserIdWithPaging(Long userId, int pageNumber, int pageSize) {
		return quotationDao.findQuotationByUserIdWithPaging(userId,pageNumber,pageSize);
	}

}
