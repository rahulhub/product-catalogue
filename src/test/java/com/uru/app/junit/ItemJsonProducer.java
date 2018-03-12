/**
 * 
 */
package com.uru.app.junit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.uru.app.model.CatalogPropertyValueModel;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomItemModel;
import com.uru.app.model.EcomProductModel;

/**
 * @author Girish.Yadav
 *
 */
public class ItemJsonProducer {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out.println(produceItemJson());

	}

	/**
	 * @return
	 */
	private static String produceItemJson() {
		final Gson gson = new Gson();
		
		final EcomCatalogModel ecomCatalogModel = new EcomCatalogModel();
		//ecomCatalogModel.setCreationDate(System.);
		ecomCatalogModel.setCategoryId(Long.valueOf(3));
		// ecomCatalogModel.setDisplayJspUrl("");
		// ecomCatalogModel.setLang("en_US");
		ecomCatalogModel.setLargeImgAltText("optimetLarge");
		ecomCatalogModel.setLargeImgLang("en_US");
		ecomCatalogModel.setLargeImgName("large1");
		ecomCatalogModel.setLargeImgType(1);
		ecomCatalogModel.setLargeImgUrl("");
		ecomCatalogModel.setLongDesc("");
		//ecomCatalogModel.setModifiedDate(new Date());		
		ecomCatalogModel.setName("optimetName");		
		ecomCatalogModel.setShortDesc("");
		ecomCatalogModel.setSmallImgAltText("optimetSmall");
		ecomCatalogModel.setSmallImgLang("en_US");
		ecomCatalogModel.setSmallImgName("small1");
		ecomCatalogModel.setSmallImgType(1);
		ecomCatalogModel.setSmallImgUrl("");
		ecomCatalogModel.setSource("source1");
		
		final EcomProductModel ptModel = new EcomProductModel();		
		ptModel.setEcomCategory(ecomCatalogModel);
		ptModel.setCreator("girish");
		ptModel.setDetDisplayJspUrl("");
		ptModel.setEstimateShipTime("");
		ptModel.setInStock(1);
		ptModel.setLang("en_US");
		ptModel.setLargeImgAltText("");
		ptModel.setLargeImgLang("");
		ptModel.setLargeImgName("");
		ptModel.setLargeImgType(1);
		ptModel.setLargeImgUrl("");
		ptModel.setLongDesc("");
		ptModel.setMsrpAmount(new BigInteger("25"));
		ptModel.setMsrpCurrency("INR");
		ptModel.setName("");
		ptModel.setPriceAmount(new BigInteger("25"));
		ptModel.setPriceCurrency("INR");
		ptModel.setShippingCode("201014");
		ptModel.setShortDesc("");
		ptModel.setSmallImgAltText("");
		ptModel.setSmallImgLang("");
		ptModel.setSmallImgName("");
		ptModel.setSmallImgType(1);
		ptModel.setSmallImgUrl("");
		ptModel.setSource("");
		ptModel.setSpecialNotes("");
		ptModel.setSumDisplayJspUrl("");
		ptModel.setTaxCode(0.0);
		ptModel.setType("");
		ptModel.setVisible(1);
		ptModel.setExciseDuty(1);
		ptModel.setTaxAmount(0.0);
		ptModel.setTaxRetailAmount(0.0);
		
		
		final EcomItemModel model = new EcomItemModel();
		//model.setCreationDate(System.);
		model.setCreator("pappu");
		model.setDetDisplayJspUrl("");
		model.setEcomProduct(ptModel);
		model.setEstimateShipTime("");
		model.setInStock(1);
		model.setLang("en_UK");
		model.setLongDesc("");
		model.setMsrpAmount(new BigInteger("253"));
		model.setMsrpCurrency("USD");
		model.setName("");
		model.setPriceAmount(new BigInteger("253"));
		model.setPriceCurrency("EURO");
		model.setShippingCode("201014");
		model.setShortDesc("");
		model.setSource("");
		model.setSpecialNotes("");
		model.setSumDisplayJspUrl("");
		model.setType("");
		model.setVisible(1);
		model.setExciseDuty(1);
		model.setTaxAmount(0.0);
		model.setTaxRetailAmount(0.0);
		final List<CatalogPropertyValueModel> attValueModels = new ArrayList<CatalogPropertyValueModel>();

		final CatalogPropertyValueModel catalogPropertyValueModel = new CatalogPropertyValueModel();
		catalogPropertyValueModel.setTextValue("textvalue");
		catalogPropertyValueModel.setPropertyType(1);
		catalogPropertyValueModel.setPropertyValueId(Long.valueOf(1));
		attValueModels.add(catalogPropertyValueModel);
		model.setCatalogPropertyValues(attValueModels);
		
		final String commandBody = gson.toJson(model);
		return commandBody;
	}

}
