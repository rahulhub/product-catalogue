/**
 * 
 */
package com.uru.app.junit;

import com.google.gson.Gson;
import com.uru.app.model.EcomCatalogModel;

/**
 * @author Girish.Yadav
 *
 */
public class CatalogJsonProducer {
	
	
	public static void main(final String[] args) {
		System.out.println(produceCatalogJson());
	}
	
	public static String produceCatalogJson(){
		final Gson gson = new Gson();
		final EcomCatalogModel model = new EcomCatalogModel();
		//model.setCreationDate(System.);
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
		
		
		
		final String commandBody = gson.toJson(model);
		/*JsonObject obj = new JsonObject();	
		obj.getAsJsonObject(request);*/
		return commandBody;
	}
	
	

}
