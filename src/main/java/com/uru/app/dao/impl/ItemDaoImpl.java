package com.uru.app.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.uru.app.business.elasticsearch.SearchService;
import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.IItemDao;
import com.uru.app.entity.EcomCategory;
import com.uru.app.entity.EcomItem;
import com.uru.app.entity.EcomItemMedia;
import com.uru.app.entity.EcomProduct;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomItemMediaModel;
import com.uru.app.model.EcomItemModel;

public class ItemDaoImpl implements IItemDao {

	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;
	
	@Inject
	SearchService searchService;

	@Override
	@Transactional
	public String create(final EcomItemModel itemData) {
		if(itemData == null) {
			throw new UruApplicationException("Illegal Item data. Item creation failed.");
		}
		EcomItem entity = m2e.convertItemModelToEntity(itemData);
		em.persist(entity);
		return entity.getSku().toString();
	}
	
	
	@Override
	@Transactional
	public boolean update(final EcomItemModel itemData) {	
		if(itemData == null) {
			throw new UruApplicationException("Illegal Product data. Item creation failed.");
		}
		itemData.setModifiedDate(new Date());
		EcomItem entity = m2e.convertItemModelToEntity(itemData);
		em.merge(entity);
		return true;
	}

	/*@Override
	@Transactional
	public boolean delete(final EcomItemModel itemData) {
		this.em.remove(itemData);	
		this.searchService.delete(itemData.getEcomProduct().getProductId()+"_"+itemData.getSku()+"");
		return true;
	}*/

	
	@Override
	public EcomItemModel findById(final Long id) {
		final Query query = this.em.createNamedQuery("EcomItem.findItemById", EcomItem.class);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_ITEM_FINDBY_ITEM_ID);
		query.setParameter("sku", id);
		final EcomItem item = (EcomItem)query.getSingleResult();
				
			return this.e2m.convertItemToModel(item);
	}

	public List<EcomItemModel> findAll() {
		final Query query = this.em.createNamedQuery("EcomItem.findAll", EcomItem.class);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_ITEM_FINDBY_ALL);
		final List<EcomItem> items = query.getResultList();
		if (items != null && items.size() > 0) {
			final List<EcomItemModel> models = new ArrayList<EcomItemModel>();
			for (final EcomItem item : items)
				models.add(this.e2m.convertItemToModel(item));
			return models;
		}
		return null;
	}
	
	public void updateIndex(final EcomItem entity){
		try {
			this.searchService.addItem(entity);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@Override
	@Transactional
	public String addItemMedia(final EcomItemMediaModel media){
		
		if(media == null)
			throw new UruApplicationException("Illegal item data. Item creation failed.");
		final EcomItem ecomItem = this.em.find(EcomItem.class, media.getEcomItem().getSku());
		final EcomItemMedia entity = this.m2e.convertMediaModelToEntity(media);
		entity.setEcomItem(ecomItem);

		final List<EcomItemMedia> listEim = new ArrayList<EcomItemMedia>();
		listEim.add(entity);
		ecomItem.setItemMediaList(listEim);

		this.em.merge(ecomItem);
		return ecomItem.getItemMediaList().get(0).getImageId().toString();
	}*/
	
	@Override
	@Transactional
	public String addItemMedia(final EcomItemMediaModel itemData) {
		if(itemData == null) {
            throw new UruApplicationException("Illegal Item Media data. Media Item creation failed.");

		}
		EcomItemMedia entity = m2e.convertMediaModelToEntity(itemData);
		em.persist(entity);
		return entity.getImageId().toString();
	}
	
	@Override
	@Transactional
	public boolean updateItemMedia(final EcomItemMediaModel itemData) {	
		if(itemData == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		EcomItemMedia entity = m2e.convertMediaModelToEntity(itemData);
		em.merge(entity);
		return true;
	}


	@Override
	public IziResponse deleteItemById(long sku, int isDeleted) {
		IziResponse resp = new IziResponse();
		resp.setMessage("Item Id doesn't exist");
		resp.setStatus(false);
		resp.setResponse(null);
		try {
			
			Query query = (Query) em
					.createQuery("Select item from EcomItem item where item.isDeleted=:isDeleted and item.sku= :sku");
			query.setParameter("sku",sku).setParameter("isDeleted", isDeleted);
			List<EcomItem> result = (List<EcomItem>) query.getResultList();
			if( result != null && result.size() > 0){
				EcomItemModel ecomItemModel=new EcomItemModel();
				resp.setMessage("Item Id Soft Deleted");
				resp.setStatus(true);
				resp.setResponse(null);
				resp.setObjectId(String.valueOf(ecomItemModel.getSku()));
			}
			else
				return resp;
			
			} catch(Exception _ex) {
				_ex.printStackTrace();
			}
		
		return resp;
	}
	
}