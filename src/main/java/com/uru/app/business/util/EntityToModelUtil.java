package com.uru.app.business.util;

import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.entity.*;
import com.uru.app.model.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;



public class EntityToModelUtil {
	@Inject
	@MySQLURUDatabase
	EntityManager em;


	public EcomCatalogModel convertEcomCatalogToModel(EcomCategory ecomCategory) {
		
		EcomCatalogModel model = new EcomCatalogModel();
		model.setCategoryId(ecomCategory.getCategoryId());
		model.setCreationDate(ecomCategory.getCreationDate());
		//model.setDisplayJspUrl(ecomCategory.getDisplayJspUrl());
//		model.setLang(ecomCategory.getLang());
		model.setLargeImgAltText(ecomCategory.getLargeImgAltText());
//		model.setLargeImgLang(ecomCategory.getLargeImgLang());
		model.setLargeImgName(ecomCategory.getLargeImgName());
		model.setLargeImgType(ecomCategory.getLargeImgType());
		model.setLargeImgUrl(ecomCategory.getLargeImgUrl());
		model.setLongDesc(ecomCategory.getLongDesc());
		model.setModifiedDate(ecomCategory.getModifiedDate());		
		model.setName(ecomCategory.getName());		
		model.setShortDesc(ecomCategory.getShortDesc());
		model.setSmallImgAltText(ecomCategory.getSmallImgAltText());
		model.setSmallImgLang(ecomCategory.getSmallImgLang());
		model.setSmallImgName(ecomCategory.getSmallImgName());
		model.setSmallImgType(ecomCategory.getSmallImgType());
		model.setSmallImgUrl(ecomCategory.getSmallImgUrl());
		model.setSource(ecomCategory.getSource());	
		
		model.settBaseRate(ecomCategory.gettBaseRate());
		model.settCutRate(ecomCategory.gettCutRate());
		model.setSpecGravity(ecomCategory.getSpecGravity());
		
		model.setMinDimension(ecomCategory.getMinDimension());
		model.setMaxDimension(ecomCategory.getMaxDimension());
		model.setRootCategory(ecomCategory.getRootCategory());
		model.setMetalType(ecomCategory.getMetalType());
		model.setMake(ecomCategory.getMake());
		model.setIsDeleted(ecomCategory.getIsDeleted());
		model.setSellerMinDimension(ecomCategory.getSellerMinDimension());
		model.setSellerMaxDimension(ecomCategory.getSellerMaxDimension());
		model.setSellerSpecGravity(ecomCategory.getSellerSpecGravity());
		model.setSellerTBaseRate(ecomCategory.getSellerTBaseRate());
		model.setSellerTCutRate(ecomCategory.getSellerTCutRate());
		
		
		if(ecomCategory.getEcomCategories()!=null && !ecomCategory.getEcomCategories().isEmpty()){
			List<EcomCatalogModel> listEcomCatalogModel = new ArrayList<EcomCatalogModel>();
			for(EcomCategory localEcomCategory: ecomCategory.getEcomCategories()){
				EcomCatalogModel ecomCatalogModel = convertEcomCatalogToModel(localEcomCategory);
				ecomCatalogModel.setParentCategory(model);
				listEcomCatalogModel.add(ecomCatalogModel);
			}
			model.setEcomCategories(listEcomCatalogModel);
		}
		
//		if(!ecomCategory.getEcomProducts().isEmpty()){			
//		List<EcomProductModel> ptmSet = new ArrayList<EcomProductModel>();
//		for (EcomProduct pt : ecomCategory.getEcomProducts()) {
//			EcomProductModel ptm = convertProductTypeToModel(pt);
//			ptm.setEcomCategory(model);
//			ptmSet.add(ptm);
//		}
//
//		model.setEcomProducts(ptmSet);
//		}
		return model;
	}

	public EcomProductModel convertProductTypeToModel(EcomProduct ecomProduct) {

		EcomProductModel ptModel = new EcomProductModel();
		ptModel.setProductId(ecomProduct.getProductId());
		ptModel.setCreationDate(ecomProduct.getCreationDate());
		ptModel.setCreator(ecomProduct.getCreator());
		ptModel.setDetDisplayJspUrl(ecomProduct.getDetDisplayJspUrl());
		ptModel.setEstimateShipTime(ecomProduct.getEstimateShipTime());
		ptModel.setInStock(ecomProduct.getInStock());
		ptModel.setLang(ecomProduct.getLang());
		ptModel.setLargeImgAltText(ecomProduct.getLargeImgAltText());
		ptModel.setLargeImgLang(ecomProduct.getLargeImgLang());
		ptModel.setLargeImgName(ecomProduct.getLargeImgName());
		ptModel.setLargeImgType(ecomProduct.getLargeImgType());
		ptModel.setLargeImgUrl(ecomProduct.getLargeImgUrl());
		ptModel.setLongDesc(ecomProduct.getLongDesc());
		ptModel.setModifiedDate(ecomProduct.getModifiedDate());
		ptModel.setMsrpAmount(ecomProduct.getMsrpAmount());
		ptModel.setMsrpCurrency(ecomProduct.getMsrpCurrency());
		ptModel.setName(ecomProduct.getName());
		ptModel.setPriceAmount(ecomProduct.getPriceAmount());
		ptModel.setPriceCurrency(ecomProduct.getPriceCurrency());
		ptModel.setShippingCode(ecomProduct.getShippingCode());
		ptModel.setShortDesc(ecomProduct.getShortDesc());
		ptModel.setSmallImgAltText(ecomProduct.getSmallImgAltText());
		ptModel.setSmallImgLang(ecomProduct.getSmallImgLang());
		ptModel.setSmallImgName(ecomProduct.getSmallImgName());
		ptModel.setSmallImgType(ecomProduct.getSmallImgType());
		ptModel.setSmallImgUrl(ecomProduct.getSmallImgUrl());
		ptModel.setSource(ecomProduct.getSource());
		ptModel.setSpecialNotes(ecomProduct.getSpecialNotes());
		ptModel.setSumDisplayJspUrl(ecomProduct.getSumDisplayJspUrl());
		ptModel.setTaxCode(ecomProduct.getTaxCode());
		ptModel.setType(ecomProduct.getType());
		ptModel.setVisible(ecomProduct.getVisible());
		ptModel.setCalcTemplate(ecomProduct.getCalcTemplate());
		ptModel.setMetalForm(ecomProduct.getMetalForm());
		ptModel.setRootCategory(ecomProduct.getRootCategory());
		ptModel.setDiscount(ecomProduct.getDiscount());
        ptModel.setExciseDuty(ecomProduct.getExciseDuty());
        ptModel.setTaxAmount(ecomProduct.getTaxAmount());
        ptModel.setTaxRetailAmount(ecomProduct.getTaxRetailAmount());
        ptModel.setMinOrderQty(ecomProduct.getMinOrderQty());
        ptModel.setMaxOrderQty(ecomProduct.getMaxOrderQty());
        ptModel.setLeadTime(ecomProduct.getLeadTime());
        ptModel.setIsDeleted(ecomProduct.getIsDeleted());
        ptModel.setEstock(ecomProduct.getEstock());

		ptModel.setIziWearData(ecomProduct.getIziWearData() != null ? convertIziWareToModel(ecomProduct.getIziWearData()) : null);
		
		List<EcomItemModel> itemModels = new ArrayList<EcomItemModel>();
		if (null != ecomProduct.getEcomItems()) {
			for (EcomItem item : ecomProduct.getEcomItems()) {
				EcomItemModel im = convertItemToModel(item);
				im.setEcomProduct(ptModel);
				itemModels.add(im);
			}
		}

		ptModel.setEcomItems(itemModels);

		return ptModel;

	}

	public EcomItemModel convertItemToModel(EcomItem item) {
		EcomItemModel model = new EcomItemModel();
		model.setCreationDate(item.getCreationDate());
		model.setCreator(item.getCreator());
		model.setDetDisplayJspUrl(item.getDetDisplayJspUrl());
		model.setEstimateShipTime(item.getEstimateShipTime());
		model.setInStock(item.getInStock());
		model.setLang(item.getLang());
		model.setLongDesc(item.getLongDesc());
		model.setModifiedDate(item.getModifiedDate());
		model.setMsrpAmount(item.getMsrpAmount());
		model.setMsrpCurrency(item.getMsrpCurrency());
		model.setName(item.getName());
		model.setPriceAmount(item.getPriceAmount());
		model.setPriceCurrency(item.getPriceCurrency());
		model.setShippingCode(item.getShippingCode());
		model.setShortDesc(item.getShortDesc());
		model.setSku(item.getSku());
		model.setSource(item.getSource());
		model.setSpecialNotes(item.getSpecialNotes());
		model.setSumDisplayJspUrl(item.getSumDisplayJspUrl());
		model.setTaxCode(item.getTaxCode());
		model.setType(item.getType());
		model.setVisible(item.getVisible());
		model.setDiscount(item.getDiscount());
		model.setExciseDuty(item.getExciseDuty());
		model.setMinOrderQty(item.getMinOrderQty());
		model.setMaxOrderQty(item.getMaxOrderQty());
		model.setLeadTime(item.getLeadTime());
		model.setTaxAmount(item.getTaxAmount());
		model.setTaxRetailAmount(item.getTaxRetailAmount());
		model.setIsDeleted(item.getIsDeleted());
		
		List<CatalogPropertyValueModel> attValueModels = new ArrayList<CatalogPropertyValueModel>();

		if (null != item.getCatalogPropertyValues()) {
			for (CatalogPropertyValue attVal : item.getCatalogPropertyValues()) {

				CatalogPropertyValueModel avm = convertAttValueToModel(attVal);
				avm.setEcomItem(model);
				attValueModels.add(avm);
			}
		}
		
		List<EcomItemMediaModel> itemMediaList = new ArrayList<EcomItemMediaModel>();
		
		if (null != item.getItemMediaList()) {
			
			for(EcomItemMedia media:item.getItemMediaList()){
				
				EcomItemMediaModel eim = convertMediaToModel(media);
				eim.setEcomItem(model);
				itemMediaList.add(eim);
				
			}
		}
		
		model.setItemMediaList(itemMediaList);

		model.setCatalogPropertyValues(attValueModels);

		return model;

	}

	private EcomItemMediaModel convertMediaToModel(EcomItemMedia media) {
		
		EcomItemMediaModel model = new EcomItemMediaModel();
		

		//model.setImageId(media.getImageId());

        model.setImageId(media.getImageId());

		model.setLargeImgAltText(media.getLargeImgAltText());
		model.setLargeImgLang(media.getLargeImgLang());
		model.setLargeImgName(media.getLargeImgName());
		model.setLargeImgType(media.getLargeImgType());
		model.setLargeImgUrl(media.getLargeImgUrl());
		model.setSmallImgAltText(media.getSmallImgAltText());
		model.setSmallImgLang(media.getSmallImgLang());
		model.setSmallImgName(media.getSmallImgName());
		model.setSmallImgType(media.getSmallImgType());
		model.setSmallImgUrl(media.getSmallImgUrl());
		return model;
	}

	public CatalogPropertyValueModel convertAttValueToModel(CatalogPropertyValue attValue) {

		CatalogPropertyValueModel attValModel = new CatalogPropertyValueModel();

		attValModel.setBlobValue(attValue.getBlobValue());
		attValModel.setBooleanValue(attValue.getBooleanValue());
		attValModel.setCatalogPropertyKey(convertAttToModel(attValue.getCatalogPropertyKey()));
		attValModel.setCreationDate(attValue.getCreationDate());
		attValModel.setDatetimeValue(attValue.getDatetimeValue());
		attValModel.setDoubleValue(attValue.getDoubleValue());
		attValModel.setLongValue(attValue.getLongValue());
		attValModel.setModifiedDate(attValue.getModifiedDate());
		attValModel.setPropertyType(attValue.getPropertyType());
		attValModel.setPropertyValueId(attValue.getPropertyValueId());
		attValModel.setTextValue(attValue.getTextValue());
		return attValModel;

	}

	public CatalogPropertyKeyModel convertAttToModel(
			CatalogPropertyKey catalogPropertyKey) {

		CatalogPropertyKeyModel attModel = new CatalogPropertyKeyModel();

		attModel.setPropertyKeyId(catalogPropertyKey.getPropertyKeyId());
		attModel.setCreationDate(catalogPropertyKey.getCreationDate());
		attModel.setModifiedDate(catalogPropertyKey.getModifiedDate());
		attModel.setPropertyCode(catalogPropertyKey.getPropertyCode());
		attModel.setPropertyName(catalogPropertyKey.getPropertyName());
		attModel.setPropertySetType(catalogPropertyKey.getPropertySetType());

		return attModel;

	}
	
	public EcomLoginModel convertLoginToModle(EcomLogin ecomLogin){
		EcomLoginModel elModel = new EcomLoginModel();
		elModel.setId(ecomLogin.getId());
		elModel.setLoginName(ecomLogin.getLoginName());
		elModel.setPassword(ecomLogin.getPassword());
		
		return elModel;
	}

	public EcomCustomerModel convertCustomerToModel(EcomCustomer ecomCustomer) {
		
		EcomCustomerModel ecomCust = new EcomCustomerModel();
		ecomCust.setCustomerId(ecomCustomer.getCustomerId());
		ecomCust.setCustomerType(ecomCustomer.getCustomerType());
		ecomCust.setFirstContactEmail(ecomCustomer.getFirstContactEmail());
		ecomCust.setFirstContactFirstName(ecomCustomer.getFirstContactFirstName());
		ecomCust.setFirstContactLastName(ecomCustomer.getFirstContactLastName());
		ecomCust.setFirstContactMobileNum(ecomCustomer.getFirstContactMobileNum());
		ecomCust.setIndiFirstName(ecomCustomer.getIndiFirstName());
		ecomCust.setIndiLastName(ecomCustomer.getIndiLastName());
		ecomCust.setIndiMobileNum(ecomCustomer.getIndiMobileNum());
		ecomCust.setSecondContactEmail(ecomCustomer.getSecondContactEmail());
		ecomCust.setSecondContactFirstName(ecomCustomer.getSecondContactFirstName());
		ecomCust.setSecondContactLastName(ecomCustomer.getSecondContactLastName());
		ecomCust.setSecondContactMobileNum(ecomCustomer.getSecondContactMobileNum());
		ecomCust.setJsonData(ecomCustomer.getJsonData());
		
		ecomCust.setAddresses(convertAddressToModel(ecomCustomer.getAddresses()));
		
		return ecomCust;
	}

	public List<CustomerAddressModel> convertAddressToModel(List<CustomerAddress> addresses) {
		
		List<CustomerAddressModel> custAddList = new ArrayList<CustomerAddressModel>();
		for(CustomerAddress address:addresses){
			CustomerAddressModel addModel = new CustomerAddressModel();
			addModel.setAddress(address.getAddress());
			addModel.setAddressId(address.getAddressId());
			addModel.setAddressType(address.getAddressType());
			addModel.setCity(address.getCity());
			addModel.setCountry(address.getCountry());
			addModel.setFirstName(address.getFirstName());
			addModel.setLandMark(address.getLandMark());
			addModel.setLastName(address.getLastName());
			addModel.setMobileNo(address.getMobileNo());
			addModel.setPinCode(address.getPinCode());
			addModel.setState(address.getState());
			
			custAddList.add(addModel);
		}
		
		return custAddList;
	}

	public EcomCartModel convertCartToModel(EcomCart cart) {
		
		EcomCartModel cartModel = new EcomCartModel();
		
		if(cart.getId() != null)
		cartModel.setId(cart.getId());
		cartModel.setCustId(cart.getEcomCustomer().getCustomerId());
		cartModel.setSku(cart.getItemId());
		if(cart.getQty() != null)
		cartModel.setQty(cart.getQty());
		if(cart.getJson_data() != null)
		cartModel.setJson_data(cart.getJson_data());
		if(cart.getRootCategory() != null)
		cartModel.setRootCategory(cart.getRootCategory());
		if(cart.getProductId() != null)
		cartModel.setProductId(cart.getProductId());
		return cartModel;
	}
	
	public EcomOrderModel converOrderToModel(EcomOrder ecomOrder){
		
		EcomOrderModel order = new EcomOrderModel();
		
		order.setOrderId(ecomOrder.getOrderId());
		 
		order.setEcomCustomer(this.convertCustomerToModel(ecomOrder.getEcomCustomer()));
//		order.setEcomTransaction(converTransactionToModel(eom.getEcomTransaction()));
		
//		if(ecomOrder.getTransactionId() != null)
//		order.setTransactionId(ecomOrder.getTransactionId());
		
		order.setOrderDate(ecomOrder.getOrderDate());
		order.setOrderSubtotal(ecomOrder.getOrderSubtotal());
		order.setPriceAmount(ecomOrder.getOrderSubtotal());
		order.setPriceCurrency(ecomOrder.getPriceCurrency());
		order.setShippingAmount(ecomOrder.getShippingAmount());
		order.setShippingCity(ecomOrder.getShippingCity());
		order.setShippingCountry(ecomOrder.getShippingCountry());
		order.setShippingCurrency(ecomOrder.getShippingCurrency());
		order.setShippingGeogode(ecomOrder.getShippingGeogode());
		order.setShippingMethod(ecomOrder.getShippingMethod());
		order.setShippingPobox(ecomOrder.getShippingPobox());
		order.setShippingPostalCode(ecomOrder.getShippingPostalCode());
		order.setShippingState(ecomOrder.getShippingState());
		order.setShippingStreet1(ecomOrder.getShippingStreet1());
		order.setShippingStreet2(ecomOrder.getShippingStreet2());
		order.setSpecialInstructions(ecomOrder.getSpecialInstructions());
		order.setSplittingPreference(ecomOrder.getSplittingPreference());
		order.setStatus(ecomOrder.getStatus());
		order.setSkuId(ecomOrder.getSkuId());
		order.setLongDesc(ecomOrder.getLongDesc());
		order.setMsrpAmount(ecomOrder.getMsrpAmount());
		order.setName(ecomOrder.getName());
		order.setShortDesc(ecomOrder.getShortDesc());
		order.setTaxCode(ecomOrder.getTaxCode());
		order.setDiscount(ecomOrder.getDiscount());
		order.setQuantity(ecomOrder.getQuantity());
		order.setDiscountPrice(ecomOrder.getDiscountPrice());
		order.setJsonData(ecomOrder.getJsonData());
		order.setOrderType(ecomOrder.getOrderType());
		order.setPaymentMode(ecomOrder.getPaymentMode());
		
		List<EcomOrderLineModel> eom = new ArrayList<EcomOrderLineModel>();
		for(EcomOrderLine eo : ecomOrder.getEcomOrderLines()){
			EcomOrderLineModel ecomolm = convertOrderItemToModel(eo);
			ecomolm.setEcomOrder(order);
			eom.add(convertOrderItemToModel(eo));
		}
		order.setEcomOrderLines(eom);
		
		List<EcomPaymentModel> epmList = new ArrayList<EcomPaymentModel>();
		
		for(EcomPayment ep: ecomOrder.getPaymentDetails()){
			EcomPaymentModel epm = convertPaymentsToModel(ep);
			//epm.setEcomOrder(null);
			epmList.add(epm);
			
		}
		order.setPaymentDetails(epmList);
		return order;
		
	}
	public EcomOrderLineModel convertOrderItemToModel(final EcomOrderLine eolm) {
		final EcomOrderLineModel eol = new EcomOrderLineModel();
		//if(eolm.getDescription() != null)
		eol.setDescription(eolm.getDescription());
		//if(eolm.getMsrpAmount() != -1)
		eol.setMsrpAmount(eolm.getMsrpAmount());
		//if(eolm.getMsrpCurrency() != null)
		eol.setMsrpCurrency(eolm.getMsrpCurrency());
		//if(eolm.getOrderLineId() != null)
		eol.setOrderLineId(eolm.getOrderLineId());
		//if(eolm.getQuantity() != 0)
		eol.setQuantity(eolm.getQuantity());
		//if(eolm.getShippingAmount() != -1)
		eol.setShippingAmount(eolm.getShippingAmount());
		//if(eolm.getShippingCurrency() != null)
		eol.setShippingCurrency(eolm.getShippingCurrency());
		//if(eolm.getOrderLineId() != null)
		eol.setSku(eolm.getSku());
		//if(eolm.getTaxAmount() != -1)
		eol.setTaxAmount(eolm.getTaxAmount());
		//if(eolm.getTaxCurrency() != null)
		eol.setTaxCurrency(eolm.getTaxCurrency());
		//if(eolm.getUnitPriceAmount() != -1)
		eol.setUnitPriceAmount(eolm.getUnitPriceAmount());
		//if(eolm.getUnitPriceCurrency() != null)
		eol.setUnitPriceCurrency(eolm.getUnitPriceCurrency());
		//if(eolm.getOrderLineId() != null)
		eol.setStatus(eolm.getStatus());
		eol.setDiscount(eolm.getDiscount());
		eol.setDiscountPrice(eolm.getDiscountPrice());
		eol.setCalculatedAmount(eolm.getCalculatedAmount());
		
		return eol;
	}

	public HomePageProductModel convertHomePageProductModel(final HomePageProduct ecomProduct) {
		final HomePageProductModel hppm =  new HomePageProductModel();
		if(ecomProduct.getHpproductId() != 0)
		hppm.setHpproductId(ecomProduct.getHpproductId());
		hppm.setHpProduct(convertProductTypeToModel(ecomProduct.getProduct()));
		hppm.setCategoryId(ecomProduct.getCategoryId());
		
		/*if(ecomProduct.getProductId() != 0)
		hppm.setProductId(ecomProduct.getProductId());
		if(ecomProduct.getCategoryId() != 0)
		hppm.setCategoryId(ecomProduct.getCategoryId());
		if(ecomProduct.getProductname() != null)
		hppm.setProductname(ecomProduct.getProductname());
		if(ecomProduct.getCategoryname() != null)
		hppm.setCategoryname(ecomProduct.getCategoryname());*/
		//hppm.setEcomProduct(convertProductTypeToModel(ecomProduct.getEcomProduct()));
		
		
		//if(homePageProduct.getEcomProducts().isEmpty()){			
		/*List<EcomProductModel> ptmSet = new ArrayList<EcomProductModel>();
		for(EcomProduct pt : ecomProduct.getEcomProducts()) {
				EcomProductModel ptm = convertProductTypeToModel(pt);
				ptm.setEcomProduct(hppm);
				ptmSet.add(ptm);
			}
		
		hppm.setEcomProducts(ptmSet);*/
		
		/*List<EcomItemModel> itemModels = new ArrayList<EcomItemModel>();
		if (null != ecomProduct.getEcomItems()) {
			for (EcomItem item : ecomProduct.getEcomItems()) {
				EcomItemModel im = convertItemToModel(item);
				im.setEcomProduct(hppm);
				itemModels.add(im);
			}
		}
		hppm.setEcomProduct(itemModels);*/
		return hppm;			
	}

	public IziWearDataModel convertIziWareToModel(IziWearData wearData) {
		IziWearDataModel iziWDM=new IziWearDataModel();
		
		iziWDM.setIziWearId(wearData.getIziWearId());
		iziWDM.setIziWearLogoDetails(wearData.getIziWearLogoDetails());
		iziWDM.setIziWearWashInstruction(wearData.getIziWearWashInstruction());
		iziWDM.setIziWearSizeChartTemplate(wearData.getIziWearSizeChartTemplate());
		iziWDM.setIziWearPriceMatrixDetails(wearData.getIziWearPriceMatrixDetails());
		iziWDM.setIziWearLogoType(wearData.getIziWearLogoType());
		iziWDM.setIziWearText(wearData.getIziWearText());
		iziWDM.setIziWear_LogoImage(wearData.getIziWear_LogoImage());
		iziWDM.setIziWearCustImage(wearData.getIziWearCustImage());
		iziWDM.setJson_Data(wearData.getJson_Data());
		return iziWDM;
	}
	

	public EcomPinCodeModel convertPincodeToModel(EcomPinCode pincode) {
		
		EcomPinCodeModel pcode = new EcomPinCodeModel();
		
		pcode.setBuyerId(pincode.getBuyerId());
		pcode.setBuyerPincode(pincode.getBuyerPincode());
		pcode.setBuyerHub(pincode.getBuyerHub());
		pcode.setBuyerState(pincode.getBuyerState());
		pcode.setBuyerVillageName(pincode.getBuyerVillageName());
		pcode.setBuyerAreaDividion(pincode.getBuyerAreaDividion());
		pcode.setBuyerTaluka(pincode.getBuyerTaluka());
		pcode.setBuyerDistric(pincode.getBuyerDistric());
		pcode.setCategoryId(pincode.getCategoryId());
		
		return pcode;
	}


	public EcomPaymentModel convertPaymentsToModel(EcomPayment ecomPayment){

		
		EcomPaymentModel ecomPaymentModel = new EcomPaymentModel();
		
		ecomPaymentModel.setId(ecomPayment.getId());
		ecomPaymentModel.setTransactionId(ecomPayment.getTransactionId());
		ecomPaymentModel.setType(ecomPayment.getType());
		ecomPaymentModel.setTranEntryStatus(ecomPayment.getTranEntryStatus());
		ecomPaymentModel.setTransactionAmount(ecomPayment.getTransactionAmount());
		ecomPaymentModel.setImageUrl(ecomPayment.getImageUrl());
		ecomPaymentModel.setBankName(ecomPayment.getBankName());
		ecomPaymentModel.setIfscCode(ecomPayment.getIfscCode());
		ecomPaymentModel.setCreatedBy(ecomPayment.getCreatedBy());
		ecomPaymentModel.setCreatedDate(ecomPayment.getCreatedDate());
		ecomPaymentModel.setModifiedBy(ecomPayment.getModifiedBy());
		ecomPaymentModel.setModifiedDate(ecomPayment.getModifiedDate());
		//ecomPaymentModel.setVersion(ecomPayment.getVersion());
		
		return ecomPaymentModel;
	}
	
	public EcomEmailTemplateModel convertEmilEntityToModel(EcomEmailTemplate emailEmail)
	{
		EcomEmailTemplateModel emailModel=new EcomEmailTemplateModel();
		emailModel.setId(emailEmail.getId());
		emailModel.setEmailName(emailEmail.getEmailName());
		emailModel.setEmailDescription(emailEmail.getEmailDescription());
		emailModel.setIsActive(emailEmail.getIsActive());
		
		return emailModel;
	}
	
	public EcomAlterationLiveModel convertEcomAlterationLiveToModel(EcomAlterationLive ecomAlterationLive)
	{
		EcomAlterationLiveModel altLiveModel=new EcomAlterationLiveModel();
		altLiveModel.setId(ecomAlterationLive.getId());
		altLiveModel.setUserName(ecomAlterationLive.getUserName());
		altLiveModel.setEmailId(ecomAlterationLive.getEmailId());
		altLiveModel.setMobileNo(ecomAlterationLive.getMobileNo());
		altLiveModel.setJsonData(ecomAlterationLive.getJsonData());
		
		return altLiveModel;
	}
	
	
	public EcomProductRequirementModel convertProductRequirementToModel(EcomProductRequirement ecomProductRequirement)
	{
		EcomProductRequirementModel ecomProductRequirementModel=new EcomProductRequirementModel();
		ecomProductRequirementModel.setId(ecomProductRequirement.getId());
		ecomProductRequirementModel.setUserId(ecomProductRequirement.getUserId());
		ecomProductRequirementModel.setUserName(ecomProductRequirement.getUserName());
		ecomProductRequirementModel.setEmailId(ecomProductRequirement.getEmailId());
		ecomProductRequirementModel.setMobileNo(ecomProductRequirement.getMobileNo());
		ecomProductRequirementModel.setJsonData(ecomProductRequirement.getJsonData());
		
		return ecomProductRequirementModel;
	}
	
	public EcomQuotationModel convertQuotationEntityToModel(EcomQuotation quotation) {
		
		EcomQuotationModel quotationModel = new EcomQuotationModel();
		
		quotationModel.setId(quotation.getId());
		quotationModel.setUserId(quotation.getUserId());
		quotationModel.setCategoryId(quotation.getCategoryId());
		quotationModel.setProductId(quotation.getProductId());
		quotationModel.setCreationDate(quotation.getCreationDate());
		quotationModel.setUpdationDate(quotation.getUpdationDate());
		quotationModel.setStatus(quotation.getStatus());
		quotationModel.setJsonData(quotation.getJsonData());
		
		return quotationModel;
	}
	
	public EcomOrderLineModel convertOrderLineToModel(EcomOrderLine orderLine) {
		EcomOrderLineModel orderLM=new EcomOrderLineModel();
		
		orderLM.setOrderLineId(orderLine.getOrderLineId());
		orderLM.setDescription(orderLine.getDescription());
		orderLM.setMsrpAmount(orderLine.getMsrpAmount());
		orderLM.setMsrpCurrency(orderLine.getMsrpCurrency());
		orderLM.setQuantity(orderLine.getQuantity());
		orderLM.setShippingAmount(orderLine.getShippingAmount());
		orderLM.setShippingCurrency(orderLine.getShippingCurrency());
		orderLM.setSku(orderLine.getSku());
		orderLM.setTaxAmount(orderLine.getTaxAmount());
		orderLM.setTaxCurrency(orderLine.getTaxCurrency());
		orderLM.setUnitPriceAmount(orderLine.getUnitPriceAmount());
		orderLM.setUnitPriceCurrency(orderLine.getUnitPriceCurrency());
		orderLM.setStatus(orderLine.getStatus());
		
		return orderLM;
	}
	
}
	


	

