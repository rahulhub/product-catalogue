package com.uru.app.business.util;

import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.entity.*;
import com.uru.app.model.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rahul Dev
 *
 */
public class ModelToEntityUtil {

	@Inject
	@MySQLURUDatabase
	EntityManager em;

	public EcomCategory convertProductCatalogToEntity(final EcomCatalogModel model) {

		EcomCategory orgEntity = null;
		EcomCategory pcEntity = new EcomCategory();
		if (null != model.getCategoryId())
		{
			orgEntity = this.em.find(EcomCategory.class, (Long.valueOf(model.getCategoryId())));
			pcEntity = orgEntity;
		}
		
			if(model.getCategoryId() != null)
			pcEntity.setCategoryId(model.getCategoryId());
			
			if(model.getCreationDate() != null)
			pcEntity.setCreationDate(model.getCreationDate());
			
			if(model.getLargeImgAltText() != null)
			pcEntity.setLargeImgAltText(model.getLargeImgAltText());
			
			if(model.getLargeImgName() != null)
			pcEntity.setLargeImgName(model.getLargeImgName());
			
			if(model.getLargeImgType() != null)
			pcEntity.setLargeImgType(model.getLargeImgType());
			
			if(model.getLargeImgUrl() != null)
			pcEntity.setLargeImgUrl(model.getLargeImgUrl());
			
			if(model.getLongDesc() != null)
			pcEntity.setLongDesc(model.getLongDesc());
			
			if(model.getModifiedDate() != null)
			pcEntity.setModifiedDate(model.getModifiedDate());
			
			if(model.getName() != null)
			pcEntity.setName(model.getName());
			
			if(model.getShortDesc() != null)
			pcEntity.setShortDesc(model.getShortDesc());
			
			if(model.getSmallImgAltText() != null)
			pcEntity.setSmallImgAltText(model.getSmallImgAltText());
			
			if(model.getSmallImgLang() != null)
			pcEntity.setSmallImgLang(model.getSmallImgLang());
			
			if(model.getSmallImgName() != null)
			pcEntity.setSmallImgName(model.getSmallImgName());
			
			if(model.getSmallImgType() != null)
			pcEntity.setSmallImgType(model.getSmallImgType());
			
			if(model.getSmallImgUrl() != null)
			pcEntity.setSmallImgUrl(model.getSmallImgUrl());
			
			if(model.getSource() != null)
			pcEntity.setSource(model.getSource());
			
			if(model.gettBaseRate() != null)
			pcEntity.settBaseRate(model.gettBaseRate());
			
			if(model.gettCutRate() != null)
			pcEntity.settCutRate(model.gettCutRate());
			
			if(model.getSpecGravity() != null)
			pcEntity.setSpecGravity(model.getSpecGravity());
			
			if(model.getMinDimension() != null)
			pcEntity.setMinDimension(model.getMinDimension());
			
			if(model.getMaxDimension() != null)
			pcEntity.setMaxDimension(model.getMaxDimension());
			
			if(model.getRootCategory() != null)
			pcEntity.setRootCategory(model.getRootCategory());
			
			if(model.getMetalType() != null)
			pcEntity.setMetalType(model.getMetalType());
			
			if(model.getSellerMinDimension() != null)
			pcEntity.setSellerMinDimension(model.getSellerMinDimension());
			
			if(model.getSellerMaxDimension() != null)
			pcEntity.setSellerMaxDimension(model.getSellerMaxDimension());
			
			if(model.getSellerSpecGravity() != null)
			pcEntity.setSellerSpecGravity(model.getSellerSpecGravity());
			
			if(model.getSellerTBaseRate() != null)
			pcEntity.setSellerTBaseRate(model.getSellerTBaseRate());
			
			if(model.getSellerTCutRate() != null)
			pcEntity.setSellerTCutRate(model.getSellerTCutRate());
			
			if(model.getMake () != null)
			pcEntity.setMake(model.getMake());
			
			if(model.getIsDeleted() != -1)
			pcEntity.setIsDeleted(model.getIsDeleted());


		final List<EcomCategory> ecomCategories = new ArrayList<EcomCategory>();

		if (model.getEcomCategories() != null && model.getEcomCategories().size() > 0) {
			for (final EcomCatalogModel pcm : model.getEcomCategories()) {
				final EcomCategory pc = this.convertProductCatalogToEntity(pcm);
				pc.setEcomCategory(pcEntity);
				ecomCategories.add(pc);
			}
			pcEntity.setEcomCategories(ecomCategories);
		} else
			pcEntity.setEcomCategories(null);

		if (model.getEcomProducts() != null && model.getEcomProducts().size() > 0) {

			final List<EcomProduct> prodTypeEntities = new ArrayList<EcomProduct>();
			for (final EcomProductModel prodTypeModel : model.getEcomProducts()) {
				final EcomProduct pt = this.convertProductTypeModelToEntity(prodTypeModel);
				pt.setEcomCategory(pcEntity);
				prodTypeEntities.add(pt);
			}
			pcEntity.setEcomProducts(prodTypeEntities);
		}
		return pcEntity;
	}

	public EcomProduct convertProductTypeModelToEntity(final EcomProductModel model) {
		EcomProduct orgProd=null;
		EcomProduct prodType = new EcomProduct();
		if (null != model.getProductId())
		{
			orgProd = this.em.find(EcomProduct.class,(Long.valueOf(model.getProductId())));
			prodType = orgProd;
		}

		prodType.setIziWearData(model.getIziWearData() != null ? convertIziWearTypeModelToEntity(model.getIziWearData()) : null);

		if(model.getProductId() != null)
		prodType.setProductId(model.getProductId());
		
		if(model.getCreationDate() != null)
		prodType.setCreationDate(model.getCreationDate());
		
		if(model.getCreator() != null)
		prodType.setCreator(model.getCreator());
		
		if(model.getDetDisplayJspUrl() != null)
		prodType.setDetDisplayJspUrl(model.getDetDisplayJspUrl());
		
		if(model.getEstimateShipTime() != null)
		prodType.setEstimateShipTime(model.getEstimateShipTime());
		
		if(model.getInStock() != -1)
		prodType.setInStock(model.getInStock());
		
		if(model.getLang() != null)
		prodType.setLang(model.getLang());
		
		if(model.getLargeImgAltText() != null)
		prodType.setLargeImgAltText(model.getLargeImgAltText());
		
		if(model.getLargeImgLang() != null)
		prodType.setLargeImgLang(model.getLargeImgLang());
		
		if(model.getLargeImgName() != null)
		prodType.setLargeImgName(model.getLargeImgName());
		
		if(model.getLargeImgType() != -1)
		prodType.setLargeImgType(model.getLargeImgType());
		
		if(model.getLargeImgUrl() != null)
		prodType.setLargeImgUrl(model.getLargeImgUrl());
		
		if(model.getLongDesc() != null)
		prodType.setLongDesc(model.getLongDesc());
		
		if(model.getModifiedDate() != null)
		prodType.setModifiedDate(model.getModifiedDate());
		
		if(model.getMsrpAmount() != null)
		prodType.setMsrpAmount(model.getMsrpAmount());
		
		if(model.getMsrpCurrency() != null)
		prodType.setMsrpCurrency(model.getMsrpCurrency());
		
		if(model.getName() != null)
		prodType.setName(model.getName());
		
		if(model.getPriceAmount() != null)
		prodType.setPriceAmount(model.getPriceAmount());
		
		if(model.getPriceCurrency() != null)
		prodType.setPriceCurrency(model.getPriceCurrency());
		
		if(model.getShippingCode() != null)
		prodType.setShippingCode(model.getShippingCode());
		
		if(model.getShortDesc() != null)
		prodType.setShortDesc(model.getShortDesc());
		
		if(model.getSmallImgAltText() != null)
		prodType.setSmallImgAltText(model.getSmallImgAltText());
		
		if(model.getSmallImgLang() != null)
		prodType.setSmallImgLang(model.getSmallImgLang());
		
		if(model.getSmallImgName() != null)
		prodType.setSmallImgName(model.getSmallImgName());
		
		if(model.getSmallImgType() != -1)
		prodType.setSmallImgType(model.getSmallImgType());
		
		if(model.getSmallImgUrl() != null)
		prodType.setSmallImgUrl(model.getSmallImgUrl());
		
		if(model.getSource() != null)
		prodType.setSource(model.getSource());
		
		if(model.getSpecialNotes() != null)
		prodType.setSpecialNotes(model.getSpecialNotes());
		
		if(model.getSumDisplayJspUrl() != null)
		prodType.setSumDisplayJspUrl(model.getSumDisplayJspUrl());
		

		if(model.getTaxCode() != -1)
		prodType.setTaxCode(model.getTaxCode());
		
		if(model.getType() != null)
		prodType.setType(model.getType());
		
		if(model.getVisible() != -1)
		prodType.setVisible(model.getVisible());
		
		if(model.getCalcTemplate() != null)
		prodType.setCalcTemplate(model.getCalcTemplate());
		
		if(model.getMetalForm() != null)
		prodType.setMetalForm(model.getMetalForm());
		
		if(model.getRootCategory() != null)
		prodType.setRootCategory(model.getRootCategory());
		
		if(model.getDiscount() != null)
		prodType.setDiscount(model.getDiscount());

        if(model.getExciseDuty() != -1)
        prodType.setExciseDuty(model.getExciseDuty());
        
        if(model.getTaxAmount() != -1)
    	prodType.setTaxAmount(model.getTaxAmount());

        if(model.getTaxRetailAmount() != -1)
        prodType.setTaxRetailAmount(model.getTaxRetailAmount());
        
        if(model.getMinOrderQty() != -1)
        prodType.setMinOrderQty(model.getMinOrderQty());
    		
    	if(model.getMaxOrderQty() != -1)
    	prodType.setMaxOrderQty(model.getMaxOrderQty());
    		
    	if(model.getLeadTime() != -1)
    	prodType.setLeadTime(model.getLeadTime());
    	
    	if(model.getIsDeleted() != -1)
        prodType.setIsDeleted(model.getIsDeleted());
    	
    	if(model.getEstock() != -1)
        prodType.setEstock(model.getEstock());

		if (null != model.getEcomItems() && !model.getEcomItems().isEmpty()) {
			final List<EcomItem> itemSet = new ArrayList<EcomItem>();

			for (final EcomItemModel imM : model.getEcomItems()) {
				final EcomItem im = this.convertItemModelToEntity(imM);
				im.setEcomProduct(prodType);
				itemSet.add(im);
			}
			prodType.setEcomItems(itemSet);
		}

		return prodType;
	}

	public EcomItem convertItemModelToEntity(final EcomItemModel model) {
		EcomItem orgitem=null;
		EcomItem item = new EcomItem();
		if (null != model.getSku())
		{
			orgitem = this.em.find(EcomItem.class,(Long.valueOf(model.getSku())));
			item = orgitem;
		}
		if(model.getSku() != null)
		item.setSku(model.getSku());
		
		if(model.getCreationDate() != null)
		item.setCreationDate(model.getCreationDate());
		
		if(model.getCreator() != null)
		item.setCreator(model.getCreator());
		
		if(model.getDetDisplayJspUrl() != null)
		item.setDetDisplayJspUrl(model.getDetDisplayJspUrl());
		// item.setEcomProduct(convertProductTypeModelToEntity(model.getEcomProduct()));
		
		if(model.getEstimateShipTime() != null)
		item.setEstimateShipTime(model.getEstimateShipTime());
		
		if(model.getInStock() != -1)
		item.setInStock(model.getInStock());
		
		if(model.getLang() != null)
		item.setLang(model.getLang());
	
		if(model.getLongDesc() != null)
		item.setLongDesc(model.getLongDesc());
		
		if(model.getModifiedDate() != null)
		item.setModifiedDate(model.getModifiedDate());
		
		if(model.getMsrpAmount() != null)
		item.setMsrpAmount(model.getMsrpAmount());
		
		if(model.getMsrpCurrency() != null)
		item.setMsrpCurrency(model.getMsrpCurrency());
		
		if(model.getName() != null)
		item.setName(model.getName());
		
		if(model.getPriceAmount() != null)
		item.setPriceAmount(model.getPriceAmount());
		
		if(model.getPriceCurrency() != null)
		item.setPriceCurrency(model.getPriceCurrency());
		
		if(model.getShippingCode() != null)
		item.setShippingCode(model.getShippingCode());
		
		if(model.getShortDesc() != null)
		item.setShortDesc(model.getShortDesc());

		if(model.getSource() != null)
		item.setSource(model.getSource());
		
		if(model.getSpecialNotes() != null)
		item.setSpecialNotes(model.getSpecialNotes());
		
		if(model.getSumDisplayJspUrl() != null)
		item.setSumDisplayJspUrl(model.getSumDisplayJspUrl());
		
		if(model.getTaxCode() != null)
		item.setTaxCode(model.getTaxCode());
		
		if(model.getType() != null)
		item.setType(model.getType());
		
		if(model.getVisible() != -1)
		item.setVisible(model.getVisible());
		
		if(model.getDiscount() != null)
		item.setMinOrderQty(model.getMinOrderQty());
		
		if(model.getExciseDuty() != -1)
		item.setExciseDuty(model.getExciseDuty());

		if(model.getMinOrderQty() != -1)
		item.setMinOrderQty(model.getMinOrderQty());
		
		if(model.getMaxOrderQty() != -1)
		item.setMaxOrderQty(model.getMaxOrderQty());
		
		if(model.getLeadTime() != -1)
		item.setLeadTime(model.getLeadTime());
		
		if(model.getTaxAmount() != -1)
		item.setTaxAmount(model.getTaxAmount());
		
		if(model.getTaxRetailAmount() != -1)
		item.setTaxRetailAmount(model.getTaxRetailAmount());
		
		if(model.getIsDeleted() != -1)
		item.setIsDeleted(model.getIsDeleted());
	        
		
		
		if (model.getCatalogPropertyValues() != null && model.getCatalogPropertyValues().size() > 0) {
			final List<CatalogPropertyValue> attrValues = new ArrayList<CatalogPropertyValue>();
			for (final CatalogPropertyValueModel attrVal : model.getCatalogPropertyValues()) {
				final CatalogPropertyValue val = this.convertAttrValueModelToEntity(attrVal);
				val.setEcomItem(item);
				attrValues.add(val);
			}
			item.setCatalogPropertyValues(attrValues);
		}
		
		if (model.getItemMediaList() != null && model.getItemMediaList().size() > 0) {
			final List<EcomItemMedia> eim = new ArrayList<EcomItemMedia>();
			for(final EcomItemMediaModel eimm : model.getItemMediaList()){
				final EcomItemMedia media = this.convertMediaModelToEntity(eimm);
				media.setEcomItem(item);
				eim.add(media);
			}
			item.setItemMediaList(eim);
		}

		return item;
	}

	public EcomItemMedia convertMediaModelToEntity(final EcomItemMediaModel model) {
		EcomItemMedia orgitemmedia =null;
		EcomItemMedia itemmedia = new EcomItemMedia();
		if (null != model.getImageId())
		{
			orgitemmedia = this.em.find(EcomItemMedia.class,model.getImageId());
			itemmedia = orgitemmedia;
		}
		
//		if(model.getImageId() != null)
//			itemmedia.setImageId(model.getImageId());
		
		if(model.getLargeImgLang() != null)
		itemmedia.setLargeImgAltText(model.getLargeImgLang());
		
		if(model.getLargeImgLang() != null)
		itemmedia.setLargeImgLang(model.getLargeImgLang());
		
		if(model.getLargeImgName() != null)
		itemmedia.setLargeImgName(model.getLargeImgName());
		
		if(model.getLargeImgType() != 0)
		itemmedia.setLargeImgType(model.getLargeImgType());
		
		if(model.getLargeImgUrl() != null)
		itemmedia.setLargeImgUrl(model.getLargeImgUrl());
		
		if(model.getSmallImgAltText() != null)
		itemmedia.setSmallImgAltText(model.getSmallImgAltText());
		
		if(model.getSmallImgLang() != null)
		itemmedia.setSmallImgLang(model.getSmallImgLang());
		
		if(model.getSmallImgName() != null)
		itemmedia.setSmallImgName(model.getSmallImgName());
		
		if(model.getSmallImgType() != -1)
		itemmedia.setSmallImgType(model.getSmallImgType());
		
		if(model.getSmallImgUrl() != null)
		itemmedia.setSmallImgUrl(model.getSmallImgUrl());
		
		return itemmedia;
	}

	public CatalogPropertyValue convertAttrValueModelToEntity(final CatalogPropertyValueModel attValModel) {
	    CatalogPropertyValue orgValueEntity=null;
		CatalogPropertyValue attrValueEntity = new CatalogPropertyValue();
		 if (null != attValModel.getPropertyValueId())
			{
			 	orgValueEntity = this.em.find(CatalogPropertyValue.class,(Long.valueOf(attValModel.getPropertyValueId())));
			 	attrValueEntity = orgValueEntity;
			}
		 
		if(attValModel.getPropertyType() != -1)
		attrValueEntity.setPropertyType(attValModel.getPropertyType());
		
		if(attValModel.getBlobValue() != -1)
		attrValueEntity.setBlobValue(attValModel.getBlobValue());
		
		if(attValModel.getBooleanValue() != -1)
		attrValueEntity.setBooleanValue(attValModel.getBooleanValue());
		
		if(attValModel.getCreationDate() != null)
		attrValueEntity.setCreationDate(attValModel.getCreationDate());
		
		if(attValModel.getModifiedDate() != null)
		attrValueEntity.setModifiedDate(attValModel.getModifiedDate());
		
		if(attValModel.getDatetimeValue() != null)
		attrValueEntity.setDatetimeValue(attValModel.getDatetimeValue());
		
		if(attValModel.getDoubleValue() != -1)
		attrValueEntity.setDoubleValue(attValModel.getDoubleValue());
		// attrValueEntity.setEcomItem(convertItemModelToEntity(attValModel.getEcomItem()));
		
		if(attValModel.getLongValue() != -1)
		attrValueEntity.setLongValue(attValModel.getLongValue());
		
		if(attValModel.getPropertyValueId() != null)
		attrValueEntity.setPropertyValueId(attValModel.getPropertyValueId());
		
		if(attValModel.getTextValue() != null)
		attrValueEntity.setTextValue(attValModel.getTextValue());
		
		if(attValModel.getCatalogPropertyKey() != null)
		attrValueEntity.setCatalogPropertyKey(convertAttrModelToEntity(attValModel.getCatalogPropertyKey()));
		
		return attrValueEntity;
	}

	public CatalogPropertyKey convertAttrModelToEntity(final CatalogPropertyKeyModel attModel) {
		CatalogPropertyKey orgAttrEntity=null;
	    CatalogPropertyKey attrEntity = new CatalogPropertyKey();
	    if (null != attModel.getPropertyKeyId())
		{
	    	orgAttrEntity = this.em.find(CatalogPropertyKey.class, (Long.valueOf(attModel.getPropertyKeyId())));
	    	attrEntity = orgAttrEntity;
		}
	    if(attModel.getPropertyKeyId() != null)
		attrEntity.setPropertyKeyId(attModel.getPropertyKeyId());
	    
	    if(attModel.getCreationDate() != null)
		attrEntity.setCreationDate(attModel.getCreationDate());
	    
	    if(attModel.getModifiedDate() != null)
		attrEntity.setModifiedDate(attModel.getModifiedDate());
	    
	    if(attModel.getPropertyCode() != null)
		attrEntity.setPropertyCode(attModel.getPropertyCode());
	    
	    if(attModel.getPropertyName() != null)
		attrEntity.setPropertyName(attModel.getPropertyName());
	    
	    if(attModel.getPropertySetType() != null)
		attrEntity.setPropertySetType(attModel.getPropertySetType());
	    
		return attrEntity;
	}

	public EcomCustomer convertCustomerToEntity(final EcomCustomerModel ecomCustomer) {

		EcomCustomer orgCust=null;
		EcomCustomer ecomCust = new EcomCustomer();
		 if (null != ecomCustomer.getCustomerId())
			{
			 orgCust = this.em.find(EcomCustomer.class, (Long.valueOf(ecomCustomer.getCustomerId())));
			 ecomCust = orgCust;
			}
		    
		 if(ecomCustomer.getCustomerId() != null)
			ecomCust.setCustomerId(ecomCustomer.getCustomerId());

		 if(ecomCustomer.getCustomerType() != null)
			ecomCust.setCustomerType(ecomCustomer.getCustomerType());

		if(ecomCustomer.getFirstContactEmail() != null)
			ecomCust.setFirstContactEmail(ecomCustomer.getFirstContactEmail());

		if(ecomCustomer.getFirstContactFirstName() != null)
			ecomCust.setFirstContactFirstName(ecomCustomer.getFirstContactFirstName());

		if(ecomCustomer.getFirstContactLastName() != null)
			ecomCust.setFirstContactLastName(ecomCustomer.getFirstContactLastName());

		if(ecomCustomer.getFirstContactMobileNum() != null)
			ecomCust.setFirstContactMobileNum(ecomCustomer.getFirstContactMobileNum());

		if(ecomCustomer.getIndiFirstName() != null)
			ecomCust.setIndiFirstName(ecomCustomer.getIndiFirstName());

		if(ecomCustomer.getIndiLastName() != null)
			ecomCust.setIndiLastName(ecomCustomer.getIndiLastName());

		if(ecomCustomer.getIndiMobileNum() != null)
			ecomCust.setIndiMobileNum(ecomCustomer.getIndiMobileNum());

		if(ecomCustomer.getSecondContactEmail() != null)
			ecomCust.setSecondContactEmail(ecomCustomer.getSecondContactEmail());

		if(ecomCustomer.getSecondContactFirstName() != null)
			ecomCust.setSecondContactFirstName(ecomCustomer.getSecondContactFirstName());

		if(ecomCustomer.getSecondContactLastName() != null)
			ecomCust.setSecondContactLastName(ecomCustomer.getSecondContactLastName());

		if(ecomCustomer.getSecondContactMobileNum() != null)
			ecomCust.setSecondContactMobileNum(ecomCustomer.getSecondContactMobileNum());

		if(ecomCustomer.getJsonData() != null)
			ecomCust.setJsonData(ecomCustomer.getJsonData());
		
		final List<CustomerAddress> custEnAdd = new ArrayList<CustomerAddress>();
		if (null != ecomCustomer.getAddresses())
			for (final CustomerAddressModel addModel : ecomCustomer.getAddresses())
				custEnAdd.add(this.convertAddressToEntity(addModel));
		ecomCust.setAddresses(custEnAdd);

		
		return ecomCust;
	}

	public CustomerAddress convertAddressToEntity(final CustomerAddressModel address) {
		
		CustomerAddress orgAddr = null;
		CustomerAddress addModel = new CustomerAddress();
		if (null != address.getAddressId())
			{
			 orgAddr = this.em.find(CustomerAddress.class, (Long.valueOf(address.getAddressId())));
			 addModel = orgAddr;
			}

		if (address.getAddressId() != null)
			addModel.setAddressId(address.getAddressId());
		
		if (address.getAddress() != null)
			addModel.setAddress(address.getAddress());

		if (address.getAddressType()!= null)
			addModel.setAddressType(address.getAddressType());

		if (address.getCity()!= null)
			addModel.setCity(address.getCity());

		if ( address.getCountry()!= null)
			addModel.setCountry(address.getCountry());

		if (address.getFirstName()!= null)
			addModel.setFirstName(address.getFirstName());

		if (address.getLandMark()!= null)
			addModel.setLandMark(address.getLandMark());

		if (address.getLastName()!= null)
			addModel.setLastName(address.getLastName());

		if (address.getMobileNo()!= null)
			addModel.setMobileNo(address.getMobileNo());

		if (address.getPinCode()!= null)
			addModel.setPinCode(address.getPinCode());

		if (address.getState()!= null)
			addModel.setState(address.getState());

		return addModel;
	}
	
	public EcomOrder convertOrderToEntity(final EcomOrderModel eom){
		EcomOrder orgorder=null;
		EcomOrder order = new EcomOrder();
		
		if (null != eom.getOrderId())
		{
			orgorder = this.em.find(EcomOrder.class, (Long.valueOf(eom.getOrderId())));
			order = orgorder;
		}
		    
		if(eom.getOrderId() != null)
		order.setOrderId(eom.getOrderId());
		 
		order.setEcomCustomer(this.convertCustomerToEntity(eom.getEcomCustomer()));
		
		
//		if(eom.getTransactionId() != null)
//		{
//		order.setPaymentDetails(eom.getp);;
//		}
		
		if(eom.getOrderDate() != null)
		order.setOrderDate(eom.getOrderDate());
		
		if(eom.getOrderSubtotal() != -1)
		order.setOrderSubtotal(eom.getOrderSubtotal());
		
		if(eom.getOrderSubtotal() != -1)
		order.setPriceAmount(eom.getOrderSubtotal());
		
		if(eom.getPriceCurrency() != null)
		order.setPriceCurrency(eom.getPriceCurrency());
		
		if(eom.getShippingAmount() != -1)
		order.setShippingAmount(eom.getShippingAmount());
		
		if(eom.getShippingCity() != null)
		order.setShippingCity(eom.getShippingCity());
		
		if(eom.getShippingCountry() != null)
		order.setShippingCountry(eom.getShippingCountry());
		
		if(eom.getShippingCurrency() != null)
		order.setShippingCurrency(eom.getShippingCurrency());
		
		if(eom.getShippingGeogode() != null)
		order.setShippingGeogode(eom.getShippingGeogode());
		
		if(eom.getShippingMethod() != null)
		order.setShippingMethod(eom.getShippingMethod());
		
		if(eom.getShippingPobox() != null)
		order.setShippingPobox(eom.getShippingPobox());
		
		if(eom.getShippingPostalCode() != null)
		order.setShippingPostalCode(eom.getShippingPostalCode());
		
		if(eom.getShippingState() != null)
		order.setShippingState(eom.getShippingState());
		
		if(eom.getShippingStreet1() != null)
		order.setShippingStreet1(eom.getShippingStreet1());
		
		if(eom.getShippingStreet2() != null)
		order.setShippingStreet2(eom.getShippingStreet2());
		
		if(eom.getSpecialInstructions() != null)
		order.setSpecialInstructions(eom.getSpecialInstructions());
		
		if(eom.getSplittingPreference() != null)
		order.setSplittingPreference(eom.getSplittingPreference());
		
		if(eom.getStatus() != null)
		order.setStatus(eom.getStatus());
		
		if(eom.getSkuId()!=null)
		order.setSkuId(eom.getSkuId());
			
		if(eom.getLongDesc()!=null)
		order.setLongDesc(eom.getLongDesc());
				
		if(eom.getMsrpAmount()!=-1)
		order.setMsrpAmount(eom.getMsrpAmount());
				
		if(eom.getName()!=null)
		order.setName(eom.getName());
				
		if(eom.getShortDesc()!=null)
		order.setShortDesc(eom.getShortDesc());
				
		if(eom.getTaxCode()!=-1)
		order.setTaxCode(eom.getTaxCode());
				
		if(eom.getDiscount()!=-1)
		order.setDiscount(eom.getDiscount());
				
		if(eom.getQuantity()!=-1)
		order.setQuantity(eom.getQuantity());
				
		if(eom.getDiscountPrice()!=-1)
		order.setDiscountPrice(eom.getDiscountPrice());
		
		if(eom.getJsonData() != null)
		order.setJsonData(eom.getJsonData());
		
		if(eom.getOrderType() != null)
		order.setOrderType(eom.getOrderType());
		
		if(eom.getPaymentMode() != null)
		order.setPaymentMode(eom.getPaymentMode());
		
		final List<EcomOrderLine> eol = new ArrayList<EcomOrderLine>();
		for(final EcomOrderLineModel eolm : eom.getEcomOrderLines()){
			final EcomOrderLine ecomolm = this.convertOrderItemToEntity(eolm);
			ecomolm.setEcomOrder(order);
			eol.add(ecomolm);
		}
		order.setEcomOrderLines(eol);
		
		
		List<EcomPayment> epmList = new ArrayList<EcomPayment>();
		
		for(EcomPaymentModel epm: eom.getPaymentDetails()){
			final EcomPayment ePay = convertPaymentModelToEntity(epm);
			ePay.setEcomOrder(order);
			epmList.add(ePay);
		}
		
		order.setPaymentDetails(epmList);
		
		return order;
		
	}

	public EcomOrderLine convertOrderItemToEntity(final EcomOrderLineModel eolm) {
		final EcomOrderLine eol = new EcomOrderLine();
		
		if(eolm.getDescription() != null)
		eol.setDescription(eolm.getDescription());
		if(eolm.getMsrpAmount() != 0)
		eol.setMsrpAmount(eolm.getMsrpAmount());
		if(eolm.getMsrpCurrency() != null)
		eol.setMsrpCurrency(eolm.getMsrpCurrency());
		if(eolm.getOrderLineId() != null)
		eol.setOrderLineId(eolm.getOrderLineId());
		if(eolm.getQuantity() != 0)
		eol.setQuantity(eolm.getQuantity());
		if(eolm.getShippingAmount() != 0)
		eol.setShippingAmount(eolm.getShippingAmount());
		if(eolm.getShippingCurrency() != null)
		eol.setShippingCurrency(eolm.getShippingCurrency());
		if(eolm.getSku() != null)
		eol.setSku(eolm.getSku());
		if(eolm.getTaxAmount() != 0)
		eol.setTaxAmount(eolm.getTaxAmount());
		if(eolm.getTaxCurrency() != null)
		eol.setTaxCurrency(eolm.getTaxCurrency());
		if(eolm.getUnitPriceAmount() != 0)
		eol.setUnitPriceAmount(eolm.getUnitPriceAmount());
		if(eolm.getUnitPriceCurrency() != null)
		eol.setUnitPriceCurrency(eolm.getUnitPriceCurrency());
		if(eolm.getStatus() != null)
		eol.setStatus(eolm.getStatus());
		if(eolm.getDiscount() != 0)
		eol.setDiscount(eolm.getDiscount());
		if(eolm.getDiscountPrice() != 0)
		eol.setDiscountPrice(eolm.getDiscountPrice());
		if(eolm.getCalculatedAmount() != 0)
		eol.setCalculatedAmount(eolm.getCalculatedAmount());
		return eol;
	}

	public EcomCustomerShippingAddress convertCustomerShippingAddressToEntity(EcomCustomerShippingAddressModel ecomCustShipping) {
		EcomCustomerShippingAddress orgcustShippAddr=null;
		EcomCustomerShippingAddress custShippAddr=new EcomCustomerShippingAddress();
		
		if (null != ecomCustShipping.getShippingAddressId())
		{
			orgcustShippAddr = this.em.find(EcomCustomerShippingAddress.class, (Long.valueOf(ecomCustShipping.getShippingAddressId())));
			custShippAddr = orgcustShippAddr;
		}
		
		if(ecomCustShipping.getShippingAddressId() != null)
			custShippAddr.setShippingAddressId(ecomCustShipping.getShippingAddressId());
		
		if(ecomCustShipping.getCustomerId() != null)
			custShippAddr.setCustomerId(ecomCustShipping.getCustomerId());

		if(ecomCustShipping.getMapKey() != null)
			custShippAddr.setMapKey(ecomCustShipping.getMapKey());

		if(ecomCustShipping.getShippingCity() != null)
			custShippAddr.setShippingCity(ecomCustShipping.getShippingCity());

		if(ecomCustShipping.getShippingCountry() != null)
			custShippAddr.setShippingCountry(ecomCustShipping.getShippingCountry());
		
		if(ecomCustShipping.getShippingCounty() != null)
			custShippAddr.setShippingCounty(ecomCustShipping.getShippingCounty());

		if(ecomCustShipping.getShippingGeocode() != null)
			custShippAddr.setShippingGeocode(ecomCustShipping.getShippingGeocode());

		if(ecomCustShipping.getShippingPobox() != null)
			custShippAddr.setShippingPobox(ecomCustShipping.getShippingPobox());

		if(ecomCustShipping.getShippingPostalCode() != null)
			custShippAddr.setShippingPostalCode(ecomCustShipping.getShippingPostalCode());

		if(ecomCustShipping.getShippingPostalCodeType() != null)
			custShippAddr.setShippingPostalCodeType(ecomCustShipping.getShippingPostalCodeType());

		if(ecomCustShipping.getShippingState() != null)
			custShippAddr.setShippingState(ecomCustShipping.getShippingState());

		if(ecomCustShipping.getShippingStreet1() != null)
			custShippAddr.setShippingStreet1(ecomCustShipping.getShippingStreet1());
		
		if(ecomCustShipping.getShippingStreet2() != null)
			custShippAddr.setShippingStreet2(ecomCustShipping.getShippingStreet2());

		return custShippAddr;
	}

	public Discount convertDiscountModelToEntity(EcomDiscountModel ecomDisModel) {
		Discount orgDis=null;
		Discount dis=new Discount();
		if (null != ecomDisModel.getDiscountId())
		{
			orgDis = this.em.find(Discount.class, (Long.valueOf(ecomDisModel.getDiscountId())));
			dis = orgDis;
		}
		
		if(ecomDisModel.getDiscountId() != null)
			dis.setDiscountId(ecomDisModel.getDiscountId());
		
		if(ecomDisModel.getAllowedUsers() != 0)
			dis.setAllowedUsers(ecomDisModel.getAllowedUsers());

		if(ecomDisModel.getDescription() != null)
			dis.setDescription(ecomDisModel.getDescription());

		if(ecomDisModel.getDiscountName() != null)
			dis.setDiscountName(ecomDisModel.getDiscountName());

		if(ecomDisModel.getDiscountType() != null)
			dis.setDiscountType(ecomDisModel.getDiscountType());
		
		if(ecomDisModel.getDiscountRule() != null)
			dis.setDiscountRule(ecomDisModel.getDiscountRule());

		if(ecomDisModel.getDisplayDescription() != null)
			dis.setDisplayDescription(ecomDisModel.getDisplayDescription());

		if(ecomDisModel.getEndDate() != null)
			dis.setEndDate(ecomDisModel.getEndDate());

		if(ecomDisModel.getIsActive() != -1)
			dis.setIsActive(ecomDisModel.getIsActive());

		if(ecomDisModel.getIsGlobal() != -1)
			dis.setIsGlobal(ecomDisModel.getIsGlobal());

		if(ecomDisModel.getModifier() != null)
			dis.setModifier(ecomDisModel.getModifier());

		if(ecomDisModel.getPriority() != -1)
			dis.setPriority(ecomDisModel.getPriority());
		
		if(ecomDisModel.getStartDate() != null)
			dis.setStartDate(ecomDisModel.getStartDate());
		
		return dis;
	}

	public DiscountSet convertDiscountSetModelToEntity(EcomDiscountSetModel ecomDisSetModel) {
		DiscountSet orgDisSet=null;
		DiscountSet disSet=new DiscountSet();
		if (null != ecomDisSetModel.getDiscountSetId())
		{
			orgDisSet = this.em.find(DiscountSet.class, (Long.valueOf(ecomDisSetModel.getDiscountSetId())));
			disSet = orgDisSet;
		}
		
		if(ecomDisSetModel.getDiscountSetId() != null)
			disSet.setDiscountSetId(ecomDisSetModel.getDiscountSetId());
		
		if(ecomDisSetModel.getDiscountSetName() != null)
			disSet.setDiscountSetName(ecomDisSetModel.getDiscountSetName());
		
		if(ecomDisSetModel.getXmlDefinition() != null)
			disSet.setXmlDefinition(ecomDisSetModel.getXmlDefinition());
			
		return disSet;
	}

	public DiscountAssociation convertDiscountAssociationModelToEntity(EcomDiscountAssociationModel ecomDisAssoModel) {
		DiscountAssociation orgDisAsso=null;
		DiscountAssociation disAsso=new DiscountAssociation();
		if (null != ecomDisAssoModel.getDiscountAssociationId())
		{
			orgDisAsso = this.em.find(DiscountAssociation.class, (Long.valueOf(ecomDisAssoModel.getDiscountAssociationId())));
			disAsso = orgDisAsso;
		}
		
		if(ecomDisAssoModel.getDiscountAssociationId() != null)
			disAsso.setDiscountAssociationId(ecomDisAssoModel.getDiscountAssociationId());
		
		if(ecomDisAssoModel.getDisplayDescription() != null)
			disAsso.setDisplayDescription(ecomDisAssoModel.getDisplayDescription());
		
		if(ecomDisAssoModel.getUseCount() != -1)
			disAsso.setUseCount(ecomDisAssoModel.getUseCount());
			
		return disAsso;
	}

	public IziWearData convertIziWearTypeModelToEntity(IziWearDataModel iziWearData) {
		IziWearData orgIziwear=null;
		IziWearData iziWear=new IziWearData();
		if (null != iziWearData.getIziWearId())
		{
			orgIziwear = this.em.find(IziWearData.class, (iziWearData.getIziWearId()));
			iziWear = orgIziwear;
		}
		
		if(iziWearData.getIziWearId() != null)
		iziWear.setIziWearId(iziWearData.getIziWearId());
		//if(iziWearData.getIziWearProductId() != null)
		if(iziWearData.getIziWearLogoDetails() != null)
		iziWear.setIziWearLogoDetails(iziWearData.getIziWearLogoDetails());
		if(iziWearData.getIziWearWashInstruction() != null)
		iziWear.setIziWearWashInstruction(iziWearData.getIziWearWashInstruction());
		if(iziWearData.getIziWearSizeChartTemplate() != null)
		iziWear.setIziWearSizeChartTemplate(iziWearData.getIziWearSizeChartTemplate());
		if(iziWearData.getIziWearPriceMatrixDetails() != null)
		iziWear.setIziWearPriceMatrixDetails(iziWearData.getIziWearPriceMatrixDetails());
		if(iziWearData.getIziWearLogoType() != null)
		iziWear.setIziWearLogoType(iziWearData.getIziWearLogoType());
		if(iziWearData.getIziWearText() != null)
		iziWear.setIziWearText(iziWearData.getIziWearText());
		if(iziWearData.getIziWear_LogoImage() != null)
		iziWear.setIziWear_LogoImage(iziWearData.getIziWear_LogoImage());
		if(iziWearData.getIziWearCustImage() != null)
		iziWear.setIziWearCustImage(iziWearData.getIziWearCustImage());
		if(iziWearData.getJson_Data() != null)
		iziWear.setJson_Data(iziWearData.getJson_Data());
		return iziWear;
	}

	public HomePageProduct convertHomepageProductTypeModelToEntity(HomePageProductModel homepageProductModel) {
		HomePageProduct orghpp=null;
		HomePageProduct hppm = new HomePageProduct();
		if (null != homepageProductModel.getHpproductId())
		{
			orghpp = this.em.find(HomePageProduct.class ,(Long.valueOf(homepageProductModel.getHpproductId())));
			hppm = orghpp;
		}
		if(homepageProductModel.getHpproductId() != null)
		hppm.setHpproductId(homepageProductModel.getHpproductId());
		if(homepageProductModel.getCategoryId() != 0)
		hppm.setCategoryId(homepageProductModel.getCategoryId());
		hppm.setProduct(convertProductTypeModelToEntity(homepageProductModel.getHpProduct()));
		return hppm;
	}
	

public EcomPinCode convertPincodeToModelToEntity(EcomPinCodeModel pincode) {
		
		EcomPinCode pcode = new EcomPinCode();
		if(pincode.getBuyerId() != null)
		pcode.setBuyerId(pincode.getBuyerId());
		if(pincode.getBuyerPincode() != 0)
		pcode.setBuyerPincode(pincode.getBuyerPincode());
		if(pincode.getBuyerHub() != null)
		pcode.setBuyerHub(pincode.getBuyerHub());
		if(pincode.getBuyerState() != null)
		pcode.setBuyerState(pincode.getBuyerState());
		if(pincode.getBuyerVillageName() != null)
		pcode.setBuyerVillageName(pincode.getBuyerVillageName());
		if(pincode.getBuyerAreaDividion() != null)
		pcode.setBuyerAreaDividion(pincode.getBuyerAreaDividion());
		if(pincode.getBuyerTaluka() != null)
		pcode.setBuyerTaluka(pincode.getBuyerTaluka());
		if(pincode.getBuyerDistric() != null)
		pcode.setBuyerDistric(pincode.getBuyerDistric());
		if(pincode.getCategoryId()!= 0)
		pcode.setCategoryId(pincode.getCategoryId());
		
		return pcode;
	}

	public EcomPayment convertPaymentModelToEntity(EcomPaymentModel ecomPaymetModel){
		
		if(ecomPaymetModel == null)
			return null;
		
		EcomPayment ecomPayment = new EcomPayment();
		
		if(ecomPaymetModel.getId()!= null)
		ecomPayment.setId(ecomPaymetModel.getId());
		if(ecomPaymetModel.getTransactionId() != null)
		ecomPayment.setTransactionId(ecomPaymetModel.getTransactionId());
		if(ecomPaymetModel.getType() != null)
		ecomPayment.setType(ecomPaymetModel.getType());
		if(ecomPaymetModel.getTranEntryStatus() != null)
		ecomPayment.setTranEntryStatus(ecomPaymetModel.getTranEntryStatus());
		if(ecomPaymetModel.getTransactionAmount() != null)
		ecomPayment.setTransactionAmount(ecomPaymetModel.getTransactionAmount());
		if(ecomPaymetModel.getImageUrl() != null)
		ecomPayment.setImageUrl(ecomPaymetModel.getImageUrl());
		if(ecomPaymetModel.getBankName() != null)
		ecomPayment.setBankName(ecomPaymetModel.getBankName());
		if(ecomPaymetModel.getIfscCode() != null)
		ecomPayment.setIfscCode(ecomPaymetModel.getIfscCode());
		if(ecomPaymetModel.getCreatedBy()!= null)
		ecomPayment.setCreatedBy(ecomPaymetModel.getCreatedBy());
		if(ecomPaymetModel.getCreatedDate()!= null)
		ecomPayment.setCreatedDate(ecomPaymetModel.getCreatedDate());
		if(ecomPaymetModel.getModifiedBy()!= null)
		ecomPayment.setModifiedBy(ecomPaymetModel.getModifiedBy());
		if(ecomPaymetModel.getModifiedDate()!= null)
		ecomPayment.setModifiedDate(ecomPaymetModel.getModifiedDate());
		//if(ecomPaymetModel.getVersion()!= null)
		//ecomPayment.setVersion(ecomPaymetModel.getVersion());
		
		return ecomPayment;	
	}
	
	public EcomEmailTemplate convertEmailModelToEntity(EcomEmailTemplateModel emailModel)
	{
		EcomEmailTemplate email=new EcomEmailTemplate();
		
		if(emailModel.getId() != null)
		email.setId(emailModel.getId());
		if(emailModel.getEmailName() != null)
		email.setEmailName(emailModel.getEmailName());
		if(emailModel.getEmailDescription() != null)
		email.setEmailDescription(emailModel.getEmailDescription());
		if(emailModel.getIsActive() != -1)
		email.setIsActive(emailModel.getIsActive());
		
		return email;
	}
	
	public EcomAlterationLive convertEcomAlterationLiveToEntity(EcomAlterationLiveModel ecomAlterationLiveModel)
	{
		EcomAlterationLive altLive=new EcomAlterationLive();
		
		if(ecomAlterationLiveModel.getId() != null)
			altLive.setId(ecomAlterationLiveModel.getId());
		if(ecomAlterationLiveModel.getUserName() != null)
			altLive.setUserName(ecomAlterationLiveModel.getUserName());
		if(ecomAlterationLiveModel.getEmailId() != null)
			altLive.setEmailId(ecomAlterationLiveModel.getEmailId());
		if(ecomAlterationLiveModel.getMobileNo() != 0)
			altLive.setMobileNo(ecomAlterationLiveModel.getMobileNo());
		if(ecomAlterationLiveModel.getJsonData() != null)
			altLive.setJsonData(ecomAlterationLiveModel.getJsonData());
		
		return altLive;
	}
	
	
	public EcomProductRequirement convertProductRequirementToEntity(EcomProductRequirementModel ecomProductRequirementModel)
	{
		EcomProductRequirement ecomProductRequirement=new EcomProductRequirement();
		
		if(ecomProductRequirementModel.getId() != null)
			ecomProductRequirement.setId(ecomProductRequirementModel.getId());
		if(ecomProductRequirementModel.getId() != null)
			ecomProductRequirement.setUserId(ecomProductRequirementModel.getUserId());
		if(ecomProductRequirementModel.getId() != null)
			ecomProductRequirement.setUserName(ecomProductRequirementModel.getUserName());
		if(ecomProductRequirementModel.getId() != null)
			ecomProductRequirement.setEmailId(ecomProductRequirementModel.getEmailId());
		if(ecomProductRequirementModel.getId() != null)
			ecomProductRequirement.setMobileNo(ecomProductRequirementModel.getMobileNo());
		if(ecomProductRequirementModel.getId() != null)
			ecomProductRequirement.setJsonData(ecomProductRequirementModel.getJsonData());
		
		return ecomProductRequirement;
	}
	
public EcomQuotation convertQuotationToModelToEntity(EcomQuotationModel quotation) {
		
		EcomQuotation quot = new EcomQuotation();
		if(quotation.getId() != null)
			quot.setId(quotation.getId());
		if(quotation.getUserId() != -1)
			quot.setUserId(quotation.getUserId());
		if(quotation.getCategoryId() != -1)
			quot.setCategoryId(quotation.getCategoryId());
		if(quotation.getProductId() != -1)
			quot.setProductId(quotation.getProductId());
		if(quotation.getCreationDate() != null)
			quot.setCreationDate(quotation.getCreationDate());
		if(quotation.getUpdationDate() != null)
			quot.setUpdationDate(quotation.getUpdationDate());
		if(quotation.getStatus() != null)
			quot.setStatus(quotation.getStatus());
		if(quotation.getJsonData() != null)
			quot.setJsonData(quotation.getJsonData());
		
		return quot;
	}
	
	
	
}
