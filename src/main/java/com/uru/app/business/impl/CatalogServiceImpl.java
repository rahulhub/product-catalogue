package com.uru.app.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.uru.app.business.service.ICatalogService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.ICatalogDao;
import com.uru.app.model.CatalogPropertyKeyModel;
import com.uru.app.model.CatalogPropertyValueModel;
import com.uru.app.model.CategoryRates;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomItemModel;
import com.uru.app.model.EcomProductModel;
import com.uru.app.model.FilterData;

/**
 * @author Girish.Yadav
 *
 */
@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CatalogServiceImpl implements ICatalogService {

	@Inject
	ICatalogDao catalogDao;
	
	@Override
	public List<EcomCatalogModel> getAllRootCategories() {
		return catalogDao.findAllCategories();
	}

	@Override
	@Transactional
	public String createCategory(EcomCatalogModel ecomCatalogModel) {
		return catalogDao.createCategory(ecomCatalogModel);
	}

	@Override
	public List<EcomCatalogModel> getAllSubCategories(String categoryId) {		
		return null;
	}

	@Override
	@Transactional
	public boolean updateCategory(EcomCatalogModel ecomCatalogModel) {
		return catalogDao.updateCategory(ecomCatalogModel);
	}

	@Override
	@Transactional
	public IziResponse deleteCategoryById(long categoryId,int isDeleted) {
		return catalogDao.deleteCategoryById(categoryId,isDeleted);
	}

	@Override
	@Transactional
	public String createCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel) {
		return catalogDao.createCatalogPropertyKey(catalogPropertyKeyModel);
	}

	@Override
	@Transactional
	public boolean updateCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel) {
		return catalogDao.updateCatalogPropertyKey(catalogPropertyKeyModel);
	}

	@Override
	@Transactional
	public boolean deleteCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel) {
		return catalogDao.deleteCatalogPropertyKey(catalogPropertyKeyModel);
	}

	@Override
	@Transactional
	public String createCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel) {
		return catalogDao.createCatalogPropertyValue(catalogPropertyValueModel);
	}

	@Override
	@Transactional
	public boolean updateCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel) {
		return catalogDao.updateCatalogPropertyValue(catalogPropertyValueModel);
	}

	@Override
	@Transactional
	public boolean deleteCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel) {
		return catalogDao.deleteCatalogPropertyValue(catalogPropertyValueModel);
	}
	
//	@Override
//	public String testCreate() {
//		CatalogPropertyKeyModel key1 = new CatalogPropertyKeyModel();
//		key1.setPropertyCode("LenCode");
//		key1.setPropertyName("length");
//		String propertyKey1=catalogDao.createCatalogPropertyKey(key1);
//		
//		CatalogPropertyKeyModel key2 = new CatalogPropertyKeyModel();
//		key2.setPropertyCode("widCode");
//		key2.setPropertyName("width");
//		
//		String propertyKey2=catalogDao.createCatalogPropertyKey(key2);
//		
//		
//		EcomCatalogModel ecomCatalogTop = new EcomCatalogModel();
//		
//		ecomCatalogTop.setName("Optimet");
//		
//		
//		EcomCatalogModel ecomCatalogChild1 = new EcomCatalogModel();
//		ecomCatalogChild1.setName("Steel");
//		ecomCatalogChild1.setParentCategory(ecomCatalogTop);
//		
//		List<EcomCatalogModel> subCategories = new ArrayList<EcomCatalogModel>();
//		subCategories.add(ecomCatalogChild1);
//		
//		ecomCatalogTop.setEcomCategories(subCategories);
//		
//		List<EcomProductModel> products = new ArrayList<EcomProductModel>();
//		
//		EcomProductModel ecomProduct = new EcomProductModel();
//		ecomProduct.setName("Sheets");
//		ecomProduct.setEcomCategory(ecomCatalogChild1);
//		
//		EcomProductModel ecomProduct1 = new EcomProductModel();
//		ecomProduct1.setName("CR Section");
//		ecomProduct1.setEcomCategory(ecomCatalogChild1);
//		
//		products.add(ecomProduct);
//		products.add(ecomProduct1);
//		
//		ecomCatalogChild1.setEcomProducts(products);
//		
//		List<CatalogPropertyValueModel> valList1 = new ArrayList<CatalogPropertyValueModel>();
//		List<CatalogPropertyValueModel> valList2 = new ArrayList<CatalogPropertyValueModel>();
//		
//		
//		
//		CatalogPropertyValueModel catPropValModel1 = new CatalogPropertyValueModel();
//		catPropValModel1.setTextValue("100");
//		catPropValModel1.setCatalogPropertyKey(catalogDao.fetchCatalogPropertyByCode(key1.getPropertyCode()));
//		
//		CatalogPropertyValueModel catPropValModel2 = new CatalogPropertyValueModel();
//		catPropValModel2.setTextValue("200");
//		catPropValModel2.setCatalogPropertyKey(catalogDao.fetchCatalogPropertyByCode(key2.getPropertyCode()));
//		
//		
//		valList1.add(catPropValModel1);
//		valList1.add(catPropValModel2);
//		valList2.add(catPropValModel1);
//		valList2.add(catPropValModel2);
//		
//		EcomItemModel ecomItem11 = new EcomItemModel();
//		ecomItem11.setName("Item1");
//		ecomItem11.setEcomProduct(ecomProduct);
//		ecomItem11.setCatalogPropertyValues(valList1);
//		
//		
//		EcomItemModel ecomItem12 = new EcomItemModel();
//		ecomItem12.setName("Item2");
//		ecomItem12.setEcomProduct(ecomProduct);
//		ecomItem12.setCatalogPropertyValues(valList2);
//		
//		EcomItemModel ecomItem21 = new EcomItemModel();
//		ecomItem21.setName("Item21");
//		ecomItem21.setEcomProduct(ecomProduct1);
//		ecomItem21.setCatalogPropertyValues(valList1);
//		
//		EcomItemModel ecomItem22 = new EcomItemModel();
//		ecomItem22.setName("Item22");
//		ecomItem22.setEcomProduct(ecomProduct1);
//		ecomItem22.setCatalogPropertyValues(valList2);
//		
//		
//		List<EcomItemModel> itemList1 = new ArrayList<EcomItemModel>();
//		itemList1.add(ecomItem11);
//		itemList1.add(ecomItem12);
//		
//		List<EcomItemModel> itemList2 = new ArrayList<EcomItemModel>();
//		itemList2.add(ecomItem21);
//		itemList2.add(ecomItem22);
//		
//		
//		ecomProduct.setEcomItems(itemList1);
//		ecomProduct1.setEcomItems(itemList2);
//		
//		catalogDao.createCategory(ecomCatalogTop);
//		
//		return "success";
//	}

	@Override
	public boolean updateCategoryRates(CategoryRates categoryRates) {
		return catalogDao.updateCategoryRates(categoryRates);
	}

	@Override
	public EcomCatalogModel getCategoryById(Long id) {
		return catalogDao.findCategoryById(id);
	}
	
	@Override
	public List<FilterData> getFilterByCategory(Long categoryId){
		return catalogDao.getFilterByCategory(categoryId);
		
	}

	
}
