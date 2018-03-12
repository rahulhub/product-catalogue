package com.uru.app.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.type.StringType;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.IProductDao;
import com.uru.app.entity.Discount;
import com.uru.app.entity.DiscountAssociation;
import com.uru.app.entity.DiscountSet;
import com.uru.app.entity.EcomCategory;
import com.uru.app.entity.EcomItem;
import com.uru.app.entity.EcomLogin;
import com.uru.app.entity.EcomPinCode;
import com.uru.app.entity.EcomProduct;
import com.uru.app.entity.HomePageProduct;
import com.uru.app.entity.IziWearData;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomDiscountAssociationModel;
import com.uru.app.model.EcomDiscountModel;
import com.uru.app.model.EcomDiscountSetModel;
import com.uru.app.model.EcomProductModel;
import com.uru.app.model.FilterData;

public class ProductDaoImpl implements IProductDao {

	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;
	
	@Override
	@Transactional
	public String createProduct(EcomProductModel ecomProductModel) {
		if(ecomProductModel == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		EcomProduct entity = m2e.convertProductTypeModelToEntity(ecomProductModel);
		em.persist(entity);
		return entity.getProductId().toString();
	}

	@Override
	@Transactional
	public boolean updateProduct(EcomProductModel ecomProductModel) {
		if(ecomProductModel == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		ecomProductModel.setModifiedDate(new Date());
		EcomProduct entity = this.m2e.convertProductTypeModelToEntity(ecomProductModel);
		em.merge(entity);
		return true;
	}
	
	/*public boolean deleteProduct(long productId) {
		final Query query = this.em.createNamedQuery("EcomProduct.findProductById", EcomProduct.class);
		query.setParameter("productId", productId);
		final EcomProduct wearData = (EcomProduct)query.getSingleResult();
		em.remove(wearData);
		return true;
	}*/

	@Override
	public List<EcomProductModel> getProductsByCategory(String categoryId) {	
		if(categoryId == null) {			
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		
		EcomCategory ec = em.find(EcomCategory.class,Long.valueOf(categoryId));
		
		List<EcomProduct> prodList = ec.getEcomProducts();
	
		List<EcomProductModel> prodEcomList = new ArrayList<EcomProductModel>();
		
		for(EcomProduct ep:prodList){
			int visible=ep.getVisible();
			if(visible==1)
			prodEcomList.add(e2m.convertProductTypeToModel(ep));
		}
		return prodEcomList;
		
	}
	
	
	@Override
	public List<Object> getAllForIndex() {
		Query query = em
				.createNativeQuery("select p.PRODUCT_ID as ProductId, p.DET_DISPLAY_JSP_URL as ProductDisplayUrl, "
						+ "p.LONG_DESC as ProductLongDescription, p.SHORT_DESC as ProductShortDescription, c.CATEGORY_ID as CategoryId,"
						+ "c.LONG_DESC as "
						+ "CategoryLongDesciption,"
						+ "c.SHORT_DESC as CategoryShortDescription , "
						+ "pk.KEYWORD as ProductKeyword,"
						+ "item.NAME as ItemName,"
						+ "item.LONG_DESC as ItemLongDescription,"
						+ "item.SHORT_DESC as ItemShortDescription,"
						+ "item.sku as ItemId,"
						+ "p.rootCategory as RootCat,"
						+ "c.name as CatName"
						+ " from "
						+ "ecom_product p left join ecom_product_keyword pk on (p.PRODUCT_ID=pk.PRODUCT_ID) JOIN ecom_category c"
						+ " on p.CATEGORY_ID=c.CATEGORY_ID left join ecom_item item on item.PRODUCT_ID=p.PRODUCT_ID");
//		query.unwrap(org.hibernate.SQLQuery.class)
//        .addScalar("PRODUCT_ID", StringType.INSTANCE)
//        .addScalar("DET_DISPLAY_JSP_URL", StringType.INSTANCE)
//        .addScalar("LONG_DESC", StringType.INSTANCE)
//        .addScalar("SHORT_DESC", StringType.INSTANCE)
//        .addScalar("KEYWORD", StringType.INSTANCE)
//        .addScalar("NAME", StringType.INSTANCE)
//        .addScalar("sku", StringType.INSTANCE)
//        .addScalar("rootCategory", StringType.INSTANCE);
//		 CacheHelper.formQueryCache(query,UruAppConstants.PRODUCT_GET_ALL_FOR_INDEX);
		List<Object> list = (List<Object>) query.getResultList();
		return list;
	}

	@Override
	public boolean updateDiscount(EcomDiscountModel ecomDisModel) {
		if(ecomDisModel == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		Discount discount = m2e.convertDiscountModelToEntity(ecomDisModel);
		em.merge(discount);
		return true;
	}

	@Override
	public boolean updateDiscountSet(EcomDiscountSetModel ecomDisSetModel) {
		if(ecomDisSetModel == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		DiscountSet discountSet = m2e.convertDiscountSetModelToEntity(ecomDisSetModel);
		em.merge(discountSet);
		return true;
	}

	@Override
	public boolean updateDiscountAssociation(EcomDiscountAssociationModel ecomDisAssoModel) {
		if(ecomDisAssoModel == null) {
			throw new UruApplicationException("Illegal Product data. Product creation failed.");
		}
		DiscountAssociation discountAsso = m2e.convertDiscountAssociationModelToEntity(ecomDisAssoModel);
		em.merge(discountAsso);
		return true;
	}

	@Override
	public IziResponse deleteProductById(long productId, int isDeleted) 
	{
		IziResponse resp = new IziResponse();
		resp.setMessage("Product Id doesn't exist");
		resp.setStatus(false);
		resp.setResponse(null);
		try {
			
			Query query = (Query) em
					.createQuery("Select product from EcomProduct product where product.isDeleted=:isDeleted and product.productId= :productId");
			query.setParameter("productId",productId).setParameter("isDeleted", isDeleted);
			List<EcomProduct> result = (List<EcomProduct>) query.getResultList();
			if( result != null && result.size() > 0){
				EcomProduct ecomProduct=new EcomProduct();
				resp.setMessage("Product Id Soft Deleted");
				resp.setStatus(true);
				resp.setResponse(null);
				resp.setObjectId(String.valueOf(ecomProduct.getProductId()));
			}
			else
				return resp;
			
			} catch(Exception _ex) {
				_ex.printStackTrace();
			}
		
		return resp;
	}
	
/*------Pagination---------------*/
	
	@Override
	public List<EcomProductModel> productLevelPagination(Long categoryId,int pageNumber, int pageSize) {
	
		int offSet = (pageNumber-1) * pageSize;
		Query query = em.createNativeQuery("select * from ecom_product where CATEGORY_ID = :categoryId AND VISIBLE=1 AND IS_DELETED=0 LIMIT "+pageSize+" OFFSET "+offSet+" ", EcomProduct.class);
		query.setParameter("categoryId", categoryId);
		CacheHelper.formQueryCache(query, UruAppConstants.PRODUCT_PAGING);
		@SuppressWarnings("unchecked")
		List<EcomProduct> ecomProductList =  (List<EcomProduct>)query.getResultList();
		List<EcomProductModel> ecomProductModelList = new ArrayList<EcomProductModel>();
		for(EcomProduct ecomProduct: ecomProductList)
		{
			//int isDelete=ecomProduct.getIsDeleted();
			//int visible=ecomProduct.getVisible();
			//if(isDelete==0 && visible == 1)
			//{
				EcomProductModel ecomProductModel = e2m.convertProductTypeToModel(ecomProduct);
				ecomProductModelList.add(ecomProductModel);
			//}
		}
		return ecomProductModelList;
		
	}

	/****************** getAllProduct  for Category***********************/
	@Override
	public List<EcomProductModel> getAllProductsByCategory(String categoryId) {
		if(categoryId == null) {			
			throw new UruApplicationException("Enter CategoryId...");
		}
		
		EcomCategory ec = em.find(EcomCategory.class,Long.valueOf(categoryId));
		
		List<EcomProduct> prodList = ec.getEcomProducts();
	
		List<EcomProductModel> prodEcomList = new ArrayList<EcomProductModel>();
		
		for(EcomProduct ep:prodList){
			prodEcomList.add(e2m.convertProductTypeToModel(ep));
		}
		return prodEcomList;
	}

	@Override
	public List<EcomProductModel> getAllNonDeletedProductsByCategory(Long categoryId) {
		if(categoryId == null) {			
			throw new UruApplicationException("Eneter CategoryId....");
		}
		
		EcomCategory ec = em.find(EcomCategory.class,Long.valueOf(categoryId));
		
		List<EcomProduct> prodList = ec.getEcomProducts();
	
		List<EcomProductModel> prodEcomList = new ArrayList<EcomProductModel>();
		
		for(EcomProduct ep:prodList){
			int isDelete=ep.getIsDeleted();
			int visible=ep.getVisible();
			if(isDelete==0 && visible == 1)
			prodEcomList.add(e2m.convertProductTypeToModel(ep));
		}
		return prodEcomList;
	}	
	
	
}
