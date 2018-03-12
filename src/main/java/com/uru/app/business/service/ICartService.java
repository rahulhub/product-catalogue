package com.uru.app.business.service;

import java.util.List;

import com.uru.app.model.EcomCartModel;
import com.uru.app.model.EcomItemModel;

/**
 * @author Rahul Dev
 *
 */
public interface ICartService {
	
	EcomCartModel addToCart(EcomCartModel cartModel);
	boolean deleteAllItemsForUser(Long customerId);
	List<EcomCartModel> getItemsInCart(Long customerId);
	boolean removeItem(Long customerId , Long itemId);
	
	EcomCartModel updateItemQty(EcomCartModel cartModel);

}
