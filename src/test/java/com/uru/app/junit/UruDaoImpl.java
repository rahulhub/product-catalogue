package com.uru.app.junit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.uru.app.common.MySQLURUDatabase;

/**
 * @author Rahul Dev
 * 
 */
@Named("uruDao")
@Dependent
public class UruDaoImpl  {
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;

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
