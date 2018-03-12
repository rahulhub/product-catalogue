package com.uru.app.business.impl;

import com.uru.app.business.service.IHomepageService;
import com.uru.app.dao.IHomepageDao;
import com.uru.app.model.HomePageProductModel;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import java.util.List;

@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)

public class HomepageServiceImpl implements IHomepageService{
	
	@Inject
	IHomepageDao homepageDao;

	@Override
	public List<HomePageProductModel> getAllHomePageProduct() {
		return homepageDao.getAllHomepageProduct();
	}

	@Override
	public String createHomePageProduct(HomePageProductModel homepageProductModel) {
		return homepageDao.createHomePageProduct(homepageProductModel);
	}

	@Override
	public boolean updateHomePageProduct(HomePageProductModel homePageProductModel) {
		return homepageDao.updateHomePageProduct(homePageProductModel);
	}

}
