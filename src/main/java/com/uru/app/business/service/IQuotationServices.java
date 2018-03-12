package com.uru.app.business.service;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomOrderModel;
import com.uru.app.model.EcomQuotationModel;

public interface IQuotationServices {

	IziResponse addQuotationData(EcomQuotationModel quotationModel);

	IziResponse updateQuotationData(EcomQuotationModel quotationModel);

	IziResponse deleteQuotationeById(long Id);

	List<EcomQuotationModel> findAllQuotationWithPaging(int pageNumber, int pageSize);

	List<EcomQuotationModel> findQuotationByUserIdWithPaging(Long userId,int pageNumber, int pageSize);

}
