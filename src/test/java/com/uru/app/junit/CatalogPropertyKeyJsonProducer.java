/**
 * 
 */
package com.uru.app.junit;

import com.google.gson.Gson;
import com.uru.app.model.CatalogPropertyKeyModel;

/**
 * @author Girish.Yadav
 *
 */
public class CatalogPropertyKeyJsonProducer {

	
	public static void main(String[] args) {
		System.out.println(produceCatalogPropertyKeyJson());
	}
	
	public static String produceCatalogPropertyKeyJson(){
		Gson gson = new Gson();
		CatalogPropertyKeyModel model = new CatalogPropertyKeyModel();
		model.setPropertyCode("PROP1");
		model.setPropertyName("size");
		model.setPropertySetType("1");
		
		
		String commandBody = gson.toJson(model);
		/*JsonObject obj = new JsonObject();	
		obj.getAsJsonObject(request);*/
		return commandBody;
	}
	

}
