package com.uru.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.uru.app.business.exception.UruApplicationException;
import com.uru.app.business.util.EntityToModelUtil;
import com.uru.app.business.util.ModelToEntityUtil;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.entity.EcomCategory;
import com.uru.app.entity.EcomCustomer;
import com.uru.app.entity.EcomLogin;
import com.uru.app.entity.EcomPinCode;
import com.uru.app.entity.EcomProduct;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomLoginModel;
import com.uru.app.model.EcomPinCodeModel;
import com.uru.app.model.EcomProductModel;

public class PinCodeDaoImpl implements com.uru.app.dao.IPinCodeDao {
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;

	@Override
	@Transactional
	public IziResponse createPinCode(EcomPinCodeModel epcm) {
			IziResponse resp = new IziResponse();
			resp.setMessage("Pincode already exist");
			resp.setStatus(false);
			resp.setResponse(null);
//			List<EcomPinCode> ecomPinCode =  em
//					.createNamedQuery("EcomPinCode.findByPincode")
//					.setParameter("n", epcm.getBuyerId()).getResultList();
			Query query = em.createNativeQuery("select * from ecom_pin_code where BUYER_PINCODE=:buyerPincode and CATEGORY_ID =:categoryId", EcomPinCode.class);
			query.setParameter("buyerPincode", epcm.getBuyerPincode()).setParameter("categoryId", epcm.getCategoryId());
			@SuppressWarnings("unchecked")
			List<EcomPinCode> result = (List<EcomPinCode>) query.getResultList();
			
			if(result.size() <= 0){
				EcomPinCode ecomPinCodeModel=new EcomPinCode();
				ecomPinCodeModel.setBuyerPincode(epcm.getBuyerPincode());
				ecomPinCodeModel.setBuyerId(epcm.getBuyerId());
				ecomPinCodeModel.setBuyerHub(epcm.getBuyerHub());
				ecomPinCodeModel.setBuyerState(epcm.getBuyerState());
				ecomPinCodeModel.setBuyerVillageName(epcm.getBuyerVillageName());
				ecomPinCodeModel.setBuyerAreaDividion(epcm.getBuyerAreaDividion());
				ecomPinCodeModel.setBuyerTaluka(epcm.getBuyerTaluka());
				ecomPinCodeModel.setBuyerDistric(epcm.getBuyerDistric());
				ecomPinCodeModel.setCategoryId(epcm.getCategoryId());
				
				em.persist(ecomPinCodeModel);
				em.flush();
				resp.setMessage("Creation Success");
				resp.setStatus(true);
				resp.setResponse(null);
				resp.setObjectId(String.valueOf(ecomPinCodeModel.getBuyerId()));
		}
			return resp;
	}

	@Override
	public IziResponse updatePinCode(EcomPinCodeModel epcmodel) {
		IziResponse resp = new IziResponse();
		resp.setMessage("sorry,Id is not present");
		resp.setStatus(false);
		resp.setResponse(null);
		List<EcomPinCode> ecomPinCode =  em
				.createNamedQuery("EcomPinCode.findById")
				.setParameter("n", (Long)epcmodel.getBuyerId()).getResultList();
		if(ecomPinCode.size() > 0){
			EcomPinCode ecomPinCodeModel=new EcomPinCode();
			ecomPinCodeModel.setBuyerPincode(epcmodel.getBuyerPincode());
			ecomPinCodeModel.setBuyerId(epcmodel.getBuyerId());
			ecomPinCodeModel.setBuyerHub(epcmodel.getBuyerHub());
			ecomPinCodeModel.setBuyerState(epcmodel.getBuyerState());
			ecomPinCodeModel.setBuyerVillageName(epcmodel.getBuyerVillageName());
			ecomPinCodeModel.setBuyerAreaDividion(epcmodel.getBuyerAreaDividion());
			ecomPinCodeModel.setBuyerTaluka(epcmodel.getBuyerTaluka());
			ecomPinCodeModel.setBuyerDistric(epcmodel.getBuyerDistric());
			ecomPinCodeModel.setCategoryId(epcmodel.getCategoryId());
			em.merge(ecomPinCodeModel);
			resp.setMessage("Updation Successfull");
			resp.setStatus(true);
			resp.setResponse(null);
			resp.setObjectId(String.valueOf(ecomPinCodeModel.getBuyerId()));
		}
		
		return resp;
	}

	@Override
	public IziResponse findByPincode(int buyerPincode) {
		
		IziResponse resp = new IziResponse();
		resp.setMessage("sorry,pincode is not ");
		resp.setStatus(false);
		resp.setResponse(null);
		try {
			Query query = (Query) em
					.createQuery("Select pinc from EcomPinCode pinc where pinc.buyerPincode= :buyerPincode");
			query.setParameter("buyerPincode", buyerPincode);
			List<EcomPinCode> result = (List<EcomPinCode>) query.getResultList();
			if( result != null && result.size() > 0)
			{
				resp.setMessage("Match Pincode");
				resp.setStatus(true);
				resp.setResponse(result.get(0));
				return resp;
			}
			else
			return resp;
			
			} catch(Exception _ex) {
				_ex.printStackTrace();
			}
		
		return null;
	}

	@Override
	public List<EcomPinCodeModel> findAllPincode() {
		Query query = em.createNamedQuery("EcomPinCode.findAll", EcomPinCode.class);
		List<EcomPinCode> pincode = query.getResultList();
		if (pincode != null && pincode.size() > 0) {
			List<EcomPinCodeModel> models = new ArrayList<EcomPinCodeModel>();
			for (EcomPinCode pc : pincode) {
				models.add(e2m.convertPincodeToModel(pc));
			}
			return models;
		}
		return null;
	}

	@Override
	public IziResponse deletePincodeById(long buyerId) {
		IziResponse resp = new IziResponse();
		resp.setMessage("sorry,BuyerId is not present");
		resp.setStatus(false);
		resp.setResponse(null);
		try{
			Query query = this.em.createNamedQuery("EcomPinCode.findById", EcomPinCode.class);
			query.setParameter("n", buyerId);
			EcomPinCode result = (EcomPinCode)query.getSingleResult();
			List<EcomPinCode> result1 = (List<EcomPinCode>) query.getResultList();
			if( result != null )
			{
				EcomPinCode ecomPinCode=new EcomPinCode();
				resp.setMessage("BuyerId Deleted");
				resp.setStatus(true);
				resp.setResponse(result1.get(0));
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
	public List<EcomPinCodeModel> getAllPincodeByCategory(long categoryId) {
		/*if(categoryId == null) {			
			throw new UruApplicationException("Enter CategoryId...");
		}
		
		EcomCategory ec = em.find(EcomCategory.class,Long.valueOf(categoryId));
		
		List<EcomPinCode> pincodeList = ec.getEcomPinCode();

		List<EcomPinCodeModel> pincodeMidelList = new ArrayList<EcomPinCodeModel>();
		
		for(EcomPinCode ep:pincodeList){
			pincodeMidelList.add(e2m.convertPincodeToModel(ep));
		}
		return pincodeMidelList;
		//return null;*/
		Query query = (Query) em
				.createQuery("Select cat from EcomPinCode cat where cat.categoryId= :categoryId");
		query.setParameter("categoryId", categoryId);
		List<EcomPinCode> pincodeList = (List<EcomPinCode>) query.getResultList();
		List<EcomPinCodeModel> pincodeModelList = new ArrayList<EcomPinCodeModel>();
		for(EcomPinCode ep:pincodeList){
			pincodeModelList.add(e2m.convertPincodeToModel(ep));
		}
		return pincodeModelList;
	}

	@Override
	public List<EcomPinCodeModel> findByPincodeAndCategoryId(int buyerPincode,long categoryId) {
		Query query = em.createNativeQuery("select * from ecom_pin_code where BUYER_PINCODE=:buyerPincode and CATEGORY_ID =:categoryId", EcomPinCode.class);
		query.setParameter("buyerPincode", buyerPincode).setParameter("categoryId", categoryId);
		@SuppressWarnings("unchecked")
		List<EcomPinCode> result = (List<EcomPinCode>) query.getResultList();
		if( result != null && result.size() > 0)
		{
			List<EcomPinCodeModel> pincodeEcomList = new ArrayList<EcomPinCodeModel>();
			for(EcomPinCode ep:result){
				pincodeEcomList.add(e2m.convertPincodeToModel(ep));
			}
			return pincodeEcomList;
		}
		return null;
	}
	
}
