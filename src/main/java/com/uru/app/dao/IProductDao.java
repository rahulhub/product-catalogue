package com.uru.app.dao;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.entity.EcomProduct;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomDiscountAssociationModel;
import com.uru.app.model.EcomDiscountModel;
import com.uru.app.model.EcomDiscountSetModel;
import com.uru.app.model.EcomProductModel;

/**
 * @author Girish.Yadav
 *
 */
public interface IProductDao {

	String createProduct(EcomProductModel ecomProductModel);

	boolean updateProduct(EcomProductModel ecomProductModel);

	//boolean deleteProduct(long productId);

	List<EcomProductModel> getProductsByCategory(String categoryId);
	
	public List<Object> getAllForIndex();

	boolean updateDiscount(EcomDiscountModel ecomDisModel);

	boolean updateDiscountSet(EcomDiscountSetModel ecomDisSetModel);

	boolean updateDiscountAssociation(EcomDiscountAssociationModel ecomDisAssoModel);

	IziResponse deleteProductById(long productId, int isDeleted);

	List<EcomProductModel> productLevelPagination(Long categoryId, int pageNumber,
			int pageSize);

	List<EcomProductModel> getAllProductsByCategory(String categoryId);

	List<EcomProductModel> getAllNonDeletedProductsByCategory(Long categoryId);

	

}
