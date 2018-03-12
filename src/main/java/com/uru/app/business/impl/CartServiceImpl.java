package com.uru.app.business.impl;

import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.uru.app.business.service.ICartService;
import com.uru.app.dao.ICartDao;
import com.uru.app.model.EcomCartModel;

@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CartServiceImpl implements ICartService {

	@Inject
	ICartDao cartDao;
	
	
	@Override
	public EcomCartModel addToCart(EcomCartModel cartModel) {
		return cartDao.addItemToCart(cartModel);
	}

	@Override
	public boolean deleteAllItemsForUser(Long customerId) {
		return cartDao.deleteAllItemsForUser(customerId);
	}

	@Override
	public List<EcomCartModel> getItemsInCart(Long customerId) {
		return cartDao.getItemsInCart(customerId);
	}

	@Override
	public boolean removeItem(Long customerId, Long itemId) {
		return cartDao.removeItem(customerId, itemId);
	}

	@Override
	public EcomCartModel updateItemQty(EcomCartModel cartModel) {
		return cartDao.updateItemQty(cartModel);
	}

}
