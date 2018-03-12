package com.uru.app.dao;

import java.util.List;

import com.uru.app.model.EcomCartModel;
import com.uru.app.model.EcomItemModel;

public interface ICartDao {

	boolean removeItem(Long customerId , Long itemId);
	boolean deleteAllItemsForUser(Long customerId);
	
	EcomCartModel updateItemQty(EcomCartModel cartModel);
	
	List<EcomCartModel> getItemsInCart(Long customerId);
	EcomCartModel addItemToCart(EcomCartModel cartModel);
}
