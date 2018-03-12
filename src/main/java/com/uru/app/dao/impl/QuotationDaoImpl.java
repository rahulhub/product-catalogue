package com.uru.app.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.uru.app.business.util.CacheHelper;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.IQuotationDao;
import com.uru.app.entity.EcomProduct;
import com.uru.app.entity.EcomQuotation;
import com.uru.app.model.EcomQuotationModel;

public class QuotationDaoImpl implements IQuotationDao {
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;

	@Override
	@Transactional
	public IziResponse addQuotationData(EcomQuotationModel quotationModel) {
		
		IziResponse resp = new IziResponse();
		resp.setMessage("Quotation Not Saved");
		resp.setStatus(false);
		resp.setResponse(null);

		if(quotationModel == null){
			return resp;
		}
			EcomQuotation quotation=new EcomQuotation();
			quotation.setId(quotationModel.getId());
			quotation.setUserId(quotationModel.getUserId());
			quotation.setCategoryId(quotationModel.getCategoryId());
			quotation.setProductId(quotationModel.getProductId());
			quotation.setCreationDate(quotationModel.getCreationDate());
			quotation.setUpdationDate(quotationModel.getUpdationDate());
			quotation.setStatus(quotationModel.getStatus());
			quotation.setJsonData(quotationModel.getJsonData());
			em.persist(quotation);
			em.flush();
			resp.setMessage("Quotation Saved Successfull");
			resp.setStatus(true);
			resp.setResponse(null);
			resp.setObjectId(String.valueOf(quotation.getId()));
			return resp;
		
	}

	@Override
	@Transactional
	public IziResponse updateQuotationData(EcomQuotationModel quotationModel) {
		IziResponse resp = new IziResponse();
		resp.setMessage("sorry,Id is not present");
		resp.setStatus(false);
		resp.setResponse(null);
		List<EcomQuotation> ecomQuotation =  em
				.createNamedQuery("EcomQuotation.findById")
				.setParameter("n", (Long)quotationModel.getId()).getResultList();
		if(ecomQuotation.size() > 0){
			EcomQuotation quotation = new EcomQuotation();
			quotation.setId(quotationModel.getId());
			quotation.setUserId(quotationModel.getUserId());
			quotation.setCategoryId(quotationModel.getCategoryId());
			quotation.setProductId(quotationModel.getProductId());
			quotation.setCreationDate(quotationModel.getCreationDate());
			//quotation.setUpdationDate(quotationModel.getUpdationDate());
			quotation.setUpdationDate(new Date());
			quotation.setStatus(quotationModel.getStatus());
			quotation.setJsonData(quotationModel.getJsonData());
			em.merge(quotation);
			resp.setMessage("Updation Successfull");
			resp.setStatus(true);
			resp.setResponse(null);
			resp.setObjectId(String.valueOf(quotation.getId()));
		}
		return resp;
	}

	@Override
	@Transactional
	public IziResponse deleteQuotationeById(long Id) {
		IziResponse resp = new IziResponse();
		resp.setMessage("sorry,Id is not present");
		resp.setStatus(false);
		resp.setResponse(null);
		try{
			Query query = this.em.createNamedQuery("EcomQuotation.findById", EcomQuotation.class);
			query.setParameter("n",Id);
			EcomQuotation result = (EcomQuotation)query.getSingleResult();
			List<EcomQuotation> quotationList = (List<EcomQuotation>) query.getResultList();
			if( result != null )
			{
				EcomQuotation ecomQuotation=new EcomQuotation();
				resp.setMessage("Id Deleted");
				resp.setStatus(true);
				resp.setResponse(quotationList.get(0));
				em.remove(result);
				return resp;
			}
			else
			return resp;
			
			} catch(Exception _ex) {
				_ex.printStackTrace();
			}
		return resp;
	}

	@Override
	public List<EcomQuotationModel> findAllQuotationWithPaging(int pageNumber,int pageSize) {
		int offSet = (pageNumber-1) * pageSize;
		Query query = em.createNativeQuery("select * from ecom_quotation order by id desc LIMIT "+pageSize+" OFFSET "+offSet+" ", EcomQuotation.class);

		CacheHelper.formQueryCache(query, UruAppConstants.FINDALL_QUOTATION_WITH_PAGING);
		@SuppressWarnings("unchecked")
		List<EcomQuotation> quotationList =  (List<EcomQuotation>)query.getResultList();
		List<EcomQuotationModel> quotationModelList = new ArrayList<EcomQuotationModel>();
		for(EcomQuotation ecomQuotation: quotationList)
		{
			EcomQuotationModel ecomQuitationModel = e2m.convertQuotationEntityToModel(ecomQuotation);
			quotationModelList.add(ecomQuitationModel);
			
		}
		return quotationModelList;
	}

	@Override
	public List<EcomQuotationModel> findQuotationByUserIdWithPaging(Long userId, int pageNumber, int pageSize) {
		int offSet = (pageNumber-1) * pageSize;
		Query query = em.createNativeQuery("select * from ecom_quotation where user_id = :userId order by id desc LIMIT "+pageSize+" OFFSET "+offSet+" ", EcomQuotation.class);
		query.setParameter("userId", userId);
		CacheHelper.formQueryCache(query, UruAppConstants.QUOTATION_FINDBYUSERID_WITH_PAGING);
		@SuppressWarnings("unchecked")
		List<EcomQuotation> ecomQuotationList =  (List<EcomQuotation>)query.getResultList();
		List<EcomQuotationModel> ecomQuotationModelList = new ArrayList<EcomQuotationModel>();
		for(EcomQuotation quotation: ecomQuotationList)
		{
			EcomQuotationModel quotationModel = e2m.convertQuotationEntityToModel(quotation);
			ecomQuotationModelList.add(quotationModel);	
		}
		return ecomQuotationModelList;
	}
		
}


