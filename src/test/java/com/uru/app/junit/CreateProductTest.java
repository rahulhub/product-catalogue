package com.uru.app.junit;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import org.junit.Test;

import com.uru.app.model.CatalogPropertyKeyModel;
import com.uru.app.model.CatalogPropertyValueModel;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomItemModel;
import com.uru.app.model.EcomProductModel;

/**
 * @author Rahul Dev
 * 
 */
@Named("uruDao")
@Dependent
public class CreateProductTest {
	
	
	@Test
	public void testCreate(){
		
		EcomCatalogModel ecomCatalogTop = new EcomCatalogModel();
		
		ecomCatalogTop.setName("Optimet");
		
		
		EcomCatalogModel ecomCatalogChild1 = new EcomCatalogModel();
		ecomCatalogChild1.setName("Steel");
		ecomCatalogChild1.setParentCategory(ecomCatalogTop);
		
		List<EcomCatalogModel> subCategories = new ArrayList<EcomCatalogModel>();
		subCategories.add(ecomCatalogChild1);
		
		ecomCatalogTop.setEcomCategories(subCategories);
		
		List<EcomProductModel> products = new ArrayList<EcomProductModel>();
		
		EcomProductModel ecomProduct = new EcomProductModel();
		ecomProduct.setName("Sheets");
		ecomProduct.setEcomCategory(ecomCatalogChild1);
		
		EcomProductModel ecomProduct1 = new EcomProductModel();
		ecomProduct1.setName("CR Section");
		ecomProduct1.setEcomCategory(ecomCatalogChild1);
		
		products.add(ecomProduct);
		products.add(ecomProduct1);
		
		ecomCatalogChild1.setEcomProducts(products);
		
		List<CatalogPropertyValueModel> valList1 = new ArrayList<CatalogPropertyValueModel>();
		List<CatalogPropertyValueModel> valList2 = new ArrayList<CatalogPropertyValueModel>();
		
		CatalogPropertyKeyModel key1 = new CatalogPropertyKeyModel();
		key1.setPropertyCode("LenCode");
		key1.setPropertyName("length");
		
		CatalogPropertyKeyModel key2 = new CatalogPropertyKeyModel();
		key2.setPropertyCode("widCode");
		key2.setPropertyName("width");
		
		CatalogPropertyValueModel catPropValModel1 = new CatalogPropertyValueModel();
		catPropValModel1.setTextValue("100");
		catPropValModel1.setCatalogPropertyKey(key1);
		
		CatalogPropertyValueModel catPropValModel2 = new CatalogPropertyValueModel();
		catPropValModel2.setTextValue("200");
		catPropValModel2.setCatalogPropertyKey(key2);
		
		
		valList1.add(catPropValModel1);
		valList1.add(catPropValModel2);
		valList2.add(catPropValModel1);
		valList2.add(catPropValModel2);
		
		EcomItemModel ecomItem11 = new EcomItemModel();
		ecomItem11.setEcomProduct(ecomProduct);
		ecomItem11.setCatalogPropertyValues(valList1);
		
		
		EcomItemModel ecomItem12 = new EcomItemModel();
		ecomItem12.setEcomProduct(ecomProduct);
		ecomItem12.setCatalogPropertyValues(valList2);
		
		EcomItemModel ecomItem21 = new EcomItemModel();
		ecomItem21.setEcomProduct(ecomProduct1);
		ecomItem21.setCatalogPropertyValues(valList1);
		
		EcomItemModel ecomItem22 = new EcomItemModel();
		ecomItem22.setEcomProduct(ecomProduct1);
		ecomItem22.setCatalogPropertyValues(valList2);
		
		
		List<EcomItemModel> itemList1 = new ArrayList<EcomItemModel>();
		itemList1.add(ecomItem11);
		itemList1.add(ecomItem12);
		
		List<EcomItemModel> itemList2 = new ArrayList<EcomItemModel>();
		itemList2.add(ecomItem21);
		itemList2.add(ecomItem22);
		
		
		ecomProduct.setEcomItems(itemList1);
		ecomProduct1.setEcomItems(itemList2);
		
		
		
		
		
		
		
		
	}
	
	

	//@Override
	/*public UruModel fetchUserDetails(String loginName) {
		List<UruEntity> uruList = null;*/
//		UruEntity uruEnt = null;
//		try {
//			Query query = (Query) em
//					.createQuery("Select ue from UruEntity ue where ue.loginName= :loginName");
//			// entityManager.getTransaction().commit();
//			query.setParameter("loginName", loginName);
//			if (!query.getResultList().isEmpty()) {
//				uruList = (List<UruEntity>) query.getResultList();
//				uruEnt = uruList
//						.get(0);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		/*ProductCatalog pCatTop = new ProductCatalog();
		pCatTop.setCatName("Optimet");
		pCatTop.setCatDescription("asdasdasdd");
		
		ProductCatalog pCat1 = new ProductCatalog();
		pCat1.setCatName("Steel");
		pCat1.setCatDescription("asdasdasdd");
		pCat1.setParentCategory(pCatTop);
		
		Set<ProductCatalog> subCate = new HashSet<ProductCatalog>();
		subCate.add(pCat1);
		
		pCatTop.setSubCategories(subCate);
		
		ProductType prodType = new ProductType();
		prodType.setProdType("Sheets");
		prodType.setProdCategory(pCat1);
		
		Set<ProductType> prodSet = new HashSet<ProductType>();
		prodSet.add(prodType);
		
		pCat1.setProductTypes(prodSet);
		
		Attribute att1 = new Attribute();
		att1.setAtrributeName("size");
		att1.setAtrributeType("String");
		att1.setProductType(prodType);
		
		Attribute att2 = new Attribute();
		att2.setAtrributeName("color");
		att2.setAtrributeType("String");
		att2.setProductType(prodType);
		
		Set<Attribute> atts = new HashSet<Attribute>();
		
		atts.add(att1);
		atts.add(att2);
		
		prodType.setAttributes(atts);
		
		Item item1 = new Item();
		item1.setProductType(prodType);
		item1.setItemName("1.8");
		Set<AttributeValue> setAtt = new HashSet<AttributeValue>();
		for(Attribute attT : prodType.getAttributes()){
			AttributeValue attv1 = new AttributeValue();
			attv1.setAttValue("10000");
			attv1.setAttribute(attT);
			attv1.setItem(item1);
			setAtt.add(attv1);
		}
		
		item1.setAttributeValues(setAtt);
		
		Item item2 = new Item();
		item2.setProductType(prodType);
		item2.setItemName("1.9");
		Set<AttributeValue> setAtt1 = new HashSet<AttributeValue>();
		for(Attribute attT1 : prodType.getAttributes()){
			AttributeValue attv1 = new AttributeValue();
			attv1.setAttValue("90000");
			attv1.setAttribute(attT1);
			attv1.setItem(item2);
			setAtt1.add(attv1);
		}
		
		item2.setAttributeValues(setAtt1);
		
		
		Set<Item> setItem = new HashSet<Item>();
		setItem.add(item1);
		setItem.add(item2);
		prodType.setItems(setItem);
		
		em.persist(pCatTop);
		
		
		
		
		//TODO: create util class to change from entity to Model
		UruModel um = new UruModel();
		um.setLoginName("Rahul");
		um.setPassword("Password");
		return um;*/
//	}

}
