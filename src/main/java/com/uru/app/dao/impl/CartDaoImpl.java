package com.uru.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.ICartDao;
import com.uru.app.entity.EcomCart;
import com.uru.app.entity.EcomCustomer;
import com.uru.app.model.EcomCartModel;

public class CartDaoImpl implements ICartDao {

	@Inject
	@MySQLURUDatabase
	EntityManager em;

	@Inject
	EntityToModelUtil e2m;

	@Inject
	ModelToEntityUtil m2e;

	
	@Override
	public EcomCartModel addItemToCart(EcomCartModel cartModel) {
		if (cartModel.getCustId() == null || cartModel.getSku() == null) {
			throw new UruApplicationException("Illegal Cart data. Item addition failed.");
		}

		EcomCart ec = new EcomCart();
		EcomCustomer ecomCust = em.find(EcomCustomer.class, cartModel.getCustId());
		ec.setEcomCustomer(ecomCust);
		ec.setItemId(cartModel.getSku());
		ec.setQty(cartModel.getQty());
		ec.setJson_data(cartModel.getJson_data());
		ec.setRootCategory(cartModel.getRootCategory());
		ec.setProductId(cartModel.getProductId());
		em.persist(ec);
		em.flush();

		return e2m.convertCartToModel(ec);
	}

	@Override
	public boolean removeItem(Long customerId, Long itemId) {
		em.createNamedQuery("EcomCart.removeItemForUser").setParameter("n", customerId).setParameter("m", itemId).executeUpdate();
		return true;
	}

	@Override
	public boolean deleteAllItemsForUser(Long customerId) {
		em.createNamedQuery("EcomCart.deleteAllItemsForUser").setParameter("n", customerId).executeUpdate();
		return true;
	}

	@Override
	public List<EcomCartModel> getItemsInCart(Long customerId) {
		Query query = em.createNamedQuery("EcomCart.findAllByCustId");
		query.setParameter("n", customerId);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_CART_FIND_ALL_BYCUSTID);
		List<EcomCart> cartItems = (List<EcomCart>) query.getResultList();

		List<EcomCartModel> cartModels = new ArrayList<EcomCartModel>();

		for (EcomCart cart : cartItems) {

			cartModels.add(e2m.convertCartToModel(cart));
		}
		return cartModels;
	}

	@Override
	public EcomCartModel updateItemQty(EcomCartModel cartModel) {
		
		EcomCart ecomCart = em.find(EcomCart.class, cartModel.getId());
		ecomCart.setQty(cartModel.getQty());

		return e2m.convertCartToModel(em.merge(ecomCart));
	}

}
