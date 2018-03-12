package com.uru.app.dao;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomItemMediaModel;
import com.uru.app.model.EcomItemModel;

public interface IItemDao {

	String create(EcomItemModel itemData);
	boolean update(EcomItemModel itemData);
	
	EcomItemModel findById(Long id);
	String addItemMedia(EcomItemMediaModel media);
	boolean updateItemMedia(EcomItemMediaModel ecomItemModel);
	IziResponse deleteItemById(long sku, int isDeleted);

}
