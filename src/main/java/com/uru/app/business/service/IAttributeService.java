package com.uru.app.business.service;

import java.util.List;

import com.uru.app.model.CatalogPropertyKeyModel;

public interface IAttributeService {
	
	List<CatalogPropertyKeyModel> getAllPropertyKeys();
	
	String createPropertyKey(CatalogPropertyKeyModel propertyKeyModel);

	boolean deletePropertyKey(CatalogPropertyKeyModel propertyKeyModel);

	boolean updatePropertyKey(CatalogPropertyKeyModel propertyKeyModel);

}
