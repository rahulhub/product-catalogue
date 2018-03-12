package com.uru.app.dao;

import com.uru.app.model.HomePageProductModel;

import java.util.List;

public interface IHomepageDao {

	List<HomePageProductModel> getAllHomepageProduct();

	String createHomePageProduct(HomePageProductModel homepageProductModel);

	boolean updateHomePageProduct(HomePageProductModel homePageProductModel);
}
