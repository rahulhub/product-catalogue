package com.uru.app.business.impl;

import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.uru.app.business.service.IProductService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.IProductDao;
import com.uru.app.entity.EcomProduct;
import com.uru.app.model.EcomDiscountAssociationModel;
import com.uru.app.model.EcomDiscountModel;
import com.uru.app.model.EcomDiscountSetModel;
import com.uru.app.model.EcomProductModel;

/**
 * @author Girish.Yadav
 *
 */
@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductServiceImpl implements IProductService {

	@Inject
	IProductDao productDao;
	
	@Override
	@Transactional
	public String createProduct(EcomProductModel ecomProductModel) {
		
		return productDao.createProduct(ecomProductModel);
	}

	@Override
	@Transactional
	public boolean updateProduct(EcomProductModel ecomProductModel) {
		
		return productDao.updateProduct(ecomProductModel);
	}

	@Override
	public List<EcomProductModel> getProductsByCategory(String categoryId) {
		
		return productDao.getProductsByCategory(categoryId);
	}

	@Override
	public boolean updateDiscount(EcomDiscountModel ecomDisModel) {
		return productDao.updateDiscount(ecomDisModel);
	}

	@Override
	public boolean updateDiscountSet(EcomDiscountSetModel ecomDisSetModel) {
		return productDao.updateDiscountSet(ecomDisSetModel);
	}

	@Override
	public boolean updateDiscountAssociation(EcomDiscountAssociationModel ecomDisAssoModel) {
		return productDao.updateDiscountAssociation(ecomDisAssoModel);
	}

	@Override
	public IziResponse deleteProductById(long productId, int isDeleted) {
		return productDao.deleteProductById(productId,isDeleted);
	}

	@Override
	public List<EcomProductModel> productLevelPagination(Long categoryId,int pageNumber, int pageSize) {
		return productDao.productLevelPagination(categoryId,pageNumber,pageSize);
	}

	@Override
	public List<EcomProductModel> getAllProductsByCategory(String categoryId) {
		return productDao.getAllProductsByCategory(categoryId);
	}


	

}
