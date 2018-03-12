package com.uru.app.dao;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.CatalogPropertyKeyModel;
import com.uru.app.model.CatalogPropertyValueModel;
import com.uru.app.model.CategoryRates;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.FilterData;

public interface ICatalogDao {

	String createCategory(EcomCatalogModel pcModel);

	boolean updateCategory(EcomCatalogModel pcModel);

	EcomCatalogModel findCategoryById(long id);

	List<EcomCatalogModel> findAllCategories();
	List<CatalogPropertyKeyModel> getAllPropertyKeys();

	CatalogPropertyKeyModel fetchCatalogPropertyByCode(String code);
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

	List<FilterData> getFilterByCategory(Long categoryId);

	//boolean deleteCategory(EcomCatalogModel ecomCatalogModel);

	//boolean deleteCategoryById(long categoryId);

	IziResponse deleteCategoryById(long categoryId, int isDeleted);
	

}
