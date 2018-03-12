package com.uru.app.business.service;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.CatalogPropertyKeyModel;
import com.uru.app.model.CatalogPropertyValueModel;
import com.uru.app.model.CategoryRates;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomDiscountModel;
import com.uru.app.model.FilterData;

/**
 * @author Girish.Yadav
 *
 */
public interface ICatalogService {

	List<EcomCatalogModel> getAllRootCategories();

	String createCategory(EcomCatalogModel ecomCatalogModel);

	List<EcomCatalogModel> getAllSubCategories(String categoryId);

	boolean updateCategory(EcomCatalogModel ecomCatalogModel);

	//boolean deleteCategory(EcomCatalogModel ecomCatalogModel);
	/**
	 * @param catalogPropertyKeyModel
	 * @return
	 */
	String createCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel);

	/**
	 * @param catalogPropertyKeyModel
	 * @return
	 */
	boolean updateCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel);

	/**
	 * @param catalogPropertyKeyModel
	 * @return
	 */
	boolean deleteCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel);
	
//	String testCreate();

	/**
	 * @param catalogPropertyValueModel
	 * @return
	 */
	String createCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel);

	/**
	 * @param catalogPropertyValueModel
	 * @return
	 */
	boolean updateCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel);

	/**
	 * @param catalogPropertyValueModel
	 * @return
	 */
	boolean deleteCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel);
	
	boolean updateCategoryRates(CategoryRates categoryRates);
	
	EcomCatalogModel getCategoryById(Long id);

	List<FilterData> getFilterByCategory(Long categoryId);

	IziResponse deleteCategoryById(long categoryId, int isDeleted);

	
}
