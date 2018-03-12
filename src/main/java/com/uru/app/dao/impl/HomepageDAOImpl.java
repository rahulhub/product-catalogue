package com.uru.app.dao.impl;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.IHomepageDao;
import com.uru.app.entity.EcomProduct;
import com.uru.app.entity.HomePageProduct;
import com.uru.app.model.EcomProductModel;
import com.uru.app.model.HomePageProductModel;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
@Named("homepageprodDao")
@Dependent

public class HomepageDAOImpl implements IHomepageDao{
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;
	

	@Override
	public List<HomePageProductModel> getAllHomepageProduct() {
		
		Query query = em.createNamedQuery("HomePageProduct.findAll", HomePageProduct.class);
		CacheHelper.formQueryCache(query, UruAppConstants.HOMEPAGE_PRODUCT_FINDALL);
		List<HomePageProduct> prodCat = query.getResultList();
		if (prodCat != null && prodCat.size() > 0) {
			List<HomePageProductModel> models = new ArrayList<HomePageProductModel>();
			for (HomePageProduct pc : prodCat) {
				models.add(e2m.convertHomePageProductModel(pc));
			}
			return models;
		}
		return null;
		
	}

	@Override
	@Transactional
	public String createHomePageProduct(HomePageProductModel homepageProductModel) {
		if(homepageProductModel == null) {
			throw new UruApplicationException("Illegal HomePage Product data.HomePage Product creation failed.");
		}
		HomePageProduct entity = m2e.convertHomepageProductTypeModelToEntity(homepageProductModel);
		em.persist(entity);
		
		return entity.getHpproductId().toString();
	}

	@Override
	@Transactional
	public boolean updateHomePageProduct(HomePageProductModel homePageProductModel) {
			if(homePageProductModel == null) {
				throw new UruApplicationException("Illegal HomePage Product data.HomePage Product Updation failed.");
			}
			HomePageProduct entity = m2e.convertHomepageProductTypeModelToEntity(homePageProductModel);
			em.merge(entity);
			return true;
		}	
}
