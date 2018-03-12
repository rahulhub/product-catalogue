package com.uru.app.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.type.StringType;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.ICatalogDao;
import com.uru.app.entity.CatalogPropertyKey;
import com.uru.app.entity.CatalogPropertyValue;
import com.uru.app.entity.EcomCategory;
import com.uru.app.model.CatalogPropertyKeyModel;
import com.uru.app.model.CatalogPropertyValueModel;
import com.uru.app.model.CategoryRates;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.FilterData;


@Named("productCatalogDao")
@Dependent
public class CatalogDaoImpl implements ICatalogDao {
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;

	@Override
	@Transactional
	public String createCategory(EcomCatalogModel pcModel)
	{
		if(pcModel == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		
		
		
		EcomCategory entity = m2e.convertProductCatalogToEntity(pcModel);
		em.persist(entity);
		return entity.getCategoryId().toString();
	}

	@Override
	@Transactional
	public boolean updateCategory(EcomCatalogModel pcModel)
	{
		if(pcModel == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		//EcomCategory orgEntity = em.find(EcomCategory.class,(Long.valueOf(pcModel.getCategoryId())));
		pcModel.setModifiedDate(new Date());
		EcomCategory entity = m2e.convertProductCatalogToEntity(pcModel);
		em.merge(entity);
		return true;
	}

	@Override
	public IziResponse deleteCategoryById(long categoryId,int isDeleted)
	{
		IziResponse resp = new IziResponse();
		resp.setMessage("Category Id doesn't exist");
		resp.setStatus(false);
		resp.setResponse(null);
		try {
			
			Query query = (Query) em
					.createQuery("Select category from EcomCategory category where category.isDeleted=:isDeleted and category.categoryId= :categoryId");
			query.setParameter("categoryId",categoryId).setParameter("isDeleted", isDeleted);
			List<EcomCategory> result = (List<EcomCategory>) query.getResultList();
			if( result != null && result.size() > 0){
				EcomCatalogModel ecomCatalogModel=new EcomCatalogModel();
				resp.setMessage("Category Id Soft Deleted");
				resp.setStatus(true);
				resp.setResponse(null);
				resp.setObjectId(String.valueOf(ecomCatalogModel.getCategoryId()));
			}
			else
				return resp;
			
			} catch(Exception _ex) {
				_ex.printStackTrace();
			}
		
		return resp;
	}
	/*@Override
	@Transactional
	public boolean deleteCategory(long categoryId)
	{
		final Query query = this.em.createNamedQuery("EcomCategory.findCategoryById", EcomCategory.class);
		query.setParameter("categoryId", categoryId);
		final EcomCategory category = (EcomCategory)query.getSingleResult();
		em.remove(category);
		return true;
	}*/
	
	

	@Override
	public EcomCatalogModel findCategoryById(long id)
	{
		try {
			Query query = (Query) em
					.createQuery("Select category from EcomCategory category where category.categoryId= :categoryId");
			query.setParameter("categoryId", id);
			CacheHelper.formQueryCache(query, UruAppConstants.SELECT_CATEGORY_FROM_ECOM_CATEGORY);
			List<EcomCategory> result = (List<EcomCategory>) query.getResultList();
			if( result != null && result.size() > 0)
				return e2m.convertEcomCatalogToModel((EcomCategory)result.get(0));
			else
				return null;
			} catch(Exception _ex) {
				_ex.printStackTrace();
			}
		
		return null;
	}

	@Override
	public List<EcomCatalogModel> findAllCategories()
	{
		Query query = em.createNamedQuery("EcomCategory.findAll", EcomCategory.class);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_CATEGORY_FIND_ALL);
		List<EcomCategory> prodCat = query.getResultList();
		if (prodCat != null && prodCat.size() > 0) {
			List<EcomCatalogModel> models = new ArrayList<EcomCatalogModel>();
			for (EcomCategory pc : prodCat) {
				models.add(e2m.convertEcomCatalogToModel(pc));
			}
			return models;
		}
		return null;

	}
	

	@Override
	@Transactional
	public String createCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel) {
		CatalogPropertyKey catalogPropertyKey =m2e.convertAttrModelToEntity(catalogPropertyKeyModel);
		em.persist(catalogPropertyKey);
		em.flush();
		return catalogPropertyKey.getPropertyKeyId().toString();
	}

	@Override
	@Transactional
	public boolean updateCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel) {
		CatalogPropertyKey catalogPropertyKey =m2e.convertAttrModelToEntity(catalogPropertyKeyModel);
		em.merge(catalogPropertyKey);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteCatalogPropertyKey(
			CatalogPropertyKeyModel catalogPropertyKeyModel) {
		CatalogPropertyKey catalogPropertyKey =em.find(CatalogPropertyKey.class,catalogPropertyKeyModel.getPropertyKeyId());
		em.remove(catalogPropertyKey);
		return true;
	}
	
	@Override
	@Transactional
	public String createCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel) {
		CatalogPropertyValue catalogPropertyValue =m2e.convertAttrValueModelToEntity(catalogPropertyValueModel);
		em.persist(catalogPropertyValue);
		em.flush();
		return catalogPropertyValue.getPropertyValueId().toString();
	}
	
	@Override
	@Transactional
	public boolean updateCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel) {
		CatalogPropertyValue catalogPropertyValue =m2e.convertAttrValueModelToEntity(catalogPropertyValueModel);
		em.merge(catalogPropertyValue);
		return true;
	}
	
	@Override
	@Transactional
	public boolean deleteCatalogPropertyValue(
			CatalogPropertyValueModel catalogPropertyValueModel) {
		CatalogPropertyValue catalogPropertyValue =em.find(CatalogPropertyValue.class,catalogPropertyValueModel.getPropertyValueId());
		em.remove(catalogPropertyValue);
		return true;
	}

	@Override
	public CatalogPropertyKeyModel fetchCatalogPropertyByCode(String code) {
		Query query = em.createNamedQuery("CatalogPropertyKey.findByCode", CatalogPropertyKey.class);
		query.setParameter("propertyCode", code);
		CacheHelper.formQueryCache(query, UruAppConstants.CATALOG_PROPERTY_KEY_FIND_BYCODE);
		CatalogPropertyKey catalogPropertyKey = (CatalogPropertyKey) query.getSingleResult();
		if (catalogPropertyKey != null ) {
			CatalogPropertyKeyModel catalogPropertyKeyModel =e2m.convertAttToModel(catalogPropertyKey);			
			return catalogPropertyKeyModel;
		}
		return null;
	}

	@Override
	public List<CatalogPropertyKeyModel> getAllPropertyKeys() {
		Query query = em.createNamedQuery("CatalogPropertyKey.findAll", CatalogPropertyKey.class);
		CacheHelper.formQueryCache(query, UruAppConstants.CATALOG_PROPERTY_KEY_FIND_ALL);
		List<CatalogPropertyKey> propKeys = query.getResultList();
		if (propKeys != null && propKeys.size() > 0) {
			List<CatalogPropertyKeyModel> models = new ArrayList<CatalogPropertyKeyModel>();
			for (CatalogPropertyKey pk : propKeys) {
				models.add(e2m.convertAttToModel(pk));
			}
			return models;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean updateCategoryRates(CategoryRates categoryRates) {
		
		EcomCategory entity = em.find(EcomCategory.class,(Long.valueOf(categoryRates.getCategoryId())));
		
		entity.settBaseRate(categoryRates.gettBaseRate());
		entity.settCutRate(categoryRates.gettCutRate());
		entity.setSpecGravity(categoryRates.getSpecGravity());
		entity.setMinDimension(categoryRates.getMinDimension());
		
		em.merge(entity);
		
		return true;
	}
	
	@Override
	@Transactional
	public List<FilterData> getFilterByCategory(Long categoryId){
		
		Query query = em.createNativeQuery("SELECT TEXT_VALUE,x.PROPERTY_KEY_ID,PROPERTY_CODE,PROPERTY_NAME FROM catalog_property_value as x , catalog_property_key as y where x.PROPERTY_KEY_ID = y.PROPERTY_KEY_ID AND SKU IN (SELECT sku FROM ecom_item where PRODUCT_ID IN (SELECT PRODUCT_ID FROM ecom_product where CATEGORY_ID = :categoryId))");
		query.setParameter("categoryId", categoryId);
		query.unwrap(org.hibernate.SQLQuery.class)
        .addScalar("TEXT_VALUE", StringType.INSTANCE)
        .addScalar("PROPERTY_KEY_ID", StringType.INSTANCE)
        .addScalar("PROPERTY_CODE", StringType.INSTANCE)
        .addScalar("PROPERTY_NAME", StringType.INSTANCE);
		CacheHelper.formQueryCache(query, UruAppConstants.FILTER_BY_CATEGORY_ID);
		List<Object> list=(List<Object>)query.getResultList();
		List<FilterData> filData = new ArrayList<FilterData>();
		for(Object obj: list){
			Object[] array=(Object[])obj;
			FilterData newObj = new FilterData();
			newObj.setValue(String.valueOf(array[0]));
			newObj.setKeyId(Long.valueOf(String.valueOf(array[1])));
			newObj.setPropertyCode(String.valueOf(array[2]));
			newObj.setPropertyName(String.valueOf(array[3]));
			filData.add(newObj);
		}
		return filData;
		
	}	

}
