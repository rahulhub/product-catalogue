/**
 * 
 */
package com.uru.app.junit;

import java.math.BigInteger;

import com.google.gson.Gson;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomProductModel;

/**
 * @author Girish.Yadav
 *
 */
public class ProductJsonProducer {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out.println(produceProductJson());

	}

	/**
	 * @return
	 */
	private static String produceProductJson() {
		final Gson gson = new Gson();
		final EcomProductModel ptModel = new EcomProductModel();
		final EcomCatalogModel model = new EcomCatalogModel();
		//model.setCreationDate(System.);
		model.setCategoryId(Long.valueOf(3));
		// model.setDisplayJspUrl("");
		// model.setLang("en_US");
		model.setLargeImgAltText("optimetLarge");
		model.setLargeImgLang("en_US");
		model.setLargeImgName("large1");
		model.setLargeImgType(1);
		model.setLargeImgUrl("");
		model.setLongDesc("");
		//model.setModifiedDate(new Date());		
		model.setName("optimetName");		
		model.setShortDesc("");
		model.setSmallImgAltText("optimetSmall");
		model.setSmallImgLang("en_US");
		model.setSmallImgName("small1");
		model.setSmallImgType(1);
		model.setSmallImgUrl("");
		model.setSource("source1");
		
		ptModel.setEcomCategory(model);
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
		
		final String commandBody = gson.toJson(ptModel);
		return commandBody;
	}

}
