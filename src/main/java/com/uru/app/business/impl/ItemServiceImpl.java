package com.uru.app.business.impl;

import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.uru.app.business.service.IItemService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.dao.IItemDao;
import com.uru.app.model.EcomItemMediaModel;
import com.uru.app.model.EcomItemModel;

/**
 * @author Girish.Yadav
 *
 */
@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ItemServiceImpl implements IItemService {

	@Inject 
	IItemDao itemDao;
	
	@Override
	public String createItem(EcomItemModel ecomItemModel) {
		return itemDao.create(ecomItemModel);
	}

	@Override
	public boolean updateItem(EcomItemModel ecomItemModel) {
		return itemDao.update(ecomItemModel);
	}

	@Override
	public List<EcomItemModel> getAllItems() {
		
		return null;
	}

	@Override
	public EcomItemModel getItemById(Long id) {
		return itemDao.findById(id);
	}

	@Override
	public String addItemMedia(EcomItemMediaModel media) {
		return itemDao.addItemMedia(media);
	}

	@Override
	public boolean updateItemMedia(EcomItemMediaModel ecomItemModel) {
		return itemDao.updateItemMedia(ecomItemModel);
	}

	@Override
	public IziResponse deleteItemById(long sku, int isDeleted) {
		return itemDao.deleteItemById(sku,isDeleted);
	}

}
