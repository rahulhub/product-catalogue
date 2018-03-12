package com.uru.app.business.impl;

import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.uru.app.business.service.IAttributeService;
import com.uru.app.dao.ICatalogDao;
import com.uru.app.model.CatalogPropertyKeyModel;

@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AttributeService implements IAttributeService {
	
	@Inject
	ICatalogDao catalogDao;

	@Override
	public String createPropertyKey(CatalogPropertyKeyModel propertyKeyModel) {
		return catalogDao.createCatalogPropertyKey(propertyKeyModel);
	}

	@Override
	public boolean deletePropertyKey(CatalogPropertyKeyModel propertyKeyModel) {
		return catalogDao.deleteCatalogPropertyKey(propertyKeyModel);
	}

	@Override
	public boolean updatePropertyKey(CatalogPropertyKeyModel propertyKeyModel) {
		return catalogDao.updateCatalogPropertyKey(propertyKeyModel);
	}

	@Override
	public List<CatalogPropertyKeyModel> getAllPropertyKeys() {
		return catalogDao.getAllPropertyKeys();
	}

}
