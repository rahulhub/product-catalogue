package com.uru.app.business.service;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomLoginModel;
import com.uru.app.model.EcomPinCodeModel;
import com.uru.app.model.EcomProductModel;

public interface IPincodeService {

	IziResponse createPinCode(EcomPinCodeModel ecomPinCodeModel);

	IziResponse updatePinCode(EcomPinCodeModel ecomPinCodeModel);

	IziResponse findByPincode(int buyerPincode);

	List<EcomPinCodeModel> findAllPincode();

	IziResponse deletePincodeById(long buyerId);

	List<EcomPinCodeModel> findByPincodeAndCategoryId(int buyerPincode,
			long categoryId);

	List<EcomPinCodeModel> getAllPincodeByCategory(long categoryId);

}
