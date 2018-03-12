package com.uru.app.business.service;

import java.util.List;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomItemMediaModel;
import com.uru.app.model.EcomItemModel;

/**
 * @author Girish.Yadav
 *
 */
public interface IItemService {

	String createItem(EcomItemModel ecomItemModel);

	boolean updateItem(EcomItemModel ecomItemModel);

	List<EcomItemModel> getAllItems();

	EcomItemModel getItemById(Long id);
	
	String addItemMedia(EcomItemMediaModel media);

	boolean updateItemMedia(EcomItemMediaModel ecomItemModel);

	IziResponse deleteItemById(long sku, int isDeleted);

}
