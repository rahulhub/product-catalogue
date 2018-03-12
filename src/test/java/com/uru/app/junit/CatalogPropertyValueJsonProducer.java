/**
 * 
 */
package com.uru.app.junit;

import com.google.gson.Gson;
import com.uru.app.model.CatalogPropertyKeyModel;
import com.uru.app.model.CatalogPropertyValueModel;

/**
 * @author Girish.Yadav
 *
 */
public class CatalogPropertyValueJsonProducer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(produceCatalogPropertyValueJson());

	}

	public static String produceCatalogPropertyValueJson(){
		Gson gson = new Gson();
		CatalogPropertyValueModel model = new CatalogPropertyValueModel();
		model.setTextValue("textvalue");
		model.setPropertyType(1);
		//model.setEcomItem();
		
		
		String commandBody = gson.toJson(model);
		/*JsonObject obj = new JsonObject();	
		obj.getAsJsonObject(request);*/
		return commandBody;
	}
}
