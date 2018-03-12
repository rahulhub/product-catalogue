package com.uru.app.business.service;

import com.uru.app.model.HomePageProductModel;

import java.util.List;

public interface IHomepageService {
	
	List<HomePageProductModel> getAllHomePageProduct();

	String createHomePageProduct(HomePageProductModel homepageProductModel);

	boolean updateHomePageProduct(HomePageProductModel homePageProductModel);

}
