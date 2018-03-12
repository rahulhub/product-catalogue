package com.uru.app.dao;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomPinCodeModel;

public interface IPinCodeDao {
	IziResponse createPinCode(EcomPinCodeModel pincode);

	IziResponse updatePinCode(EcomPinCodeModel ecomPinCodeModel);

	IziResponse findByPincode(int buyerDistric);

	List<EcomPinCodeModel> findAllPincode();

	IziResponse deletePincodeById(long buyerId);

	List<EcomPinCodeModel> getAllPincodeByCategory(long categoryId);

	List<EcomPinCodeModel> findByPincodeAndCategoryId(int buyerPincode,
			long categoryId);

}
