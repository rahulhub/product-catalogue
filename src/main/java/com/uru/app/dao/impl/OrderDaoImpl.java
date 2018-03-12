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
import com.uru.app.business.util.ValocityTemplate;
import com.uru.app.common.MySQLURUDatabase;
import com.uru.app.common.response.IziResponse;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.dao.IOrderDao;
import com.uru.app.entity.EcomCustomer;
import com.uru.app.entity.EcomOrder;
import com.uru.app.entity.EcomOrderLine;
import com.uru.app.entity.EcomPayment;
import com.uru.app.model.EcomOrderLineModel;
import com.uru.app.model.EcomOrderModel;
import com.uru.app.model.EcomPaymentModel;



public class OrderDaoImpl implements IOrderDao {
	
	@Inject
	@MySQLURUDatabase
	EntityManager em;
	
	@Inject
	EntityToModelUtil e2m;
	
	@Inject
	ModelToEntityUtil m2e;

	@Override
	@Transactional
	public EcomOrderModel createOrder(EcomOrderModel eom) throws Exception {
		
		EcomCustomer ecomCust = em.find(EcomCustomer.class, (Long.valueOf(eom.getEcomCustomer().getCustomerId())));
		
		EcomOrder eo = m2e.convertOrderToEntity(eom);
		eo.setEcomCustomer(ecomCust);
		em.persist(eo);
		em.flush();
		String to_mail1=eo.getEcomCustomer().getFirstContactEmail();
		String to_mail2=eo.getEcomCustomer().getSecondContactEmail();
		String account_email="accounts@izigro.com";
		String ibrar_email="izigro.ibrar@gmail.com";
		String parmeshewr_email="izigro.parmeshwar@gmail.com";
		Long orderid=eo.getOrderId();
		
		Query query = em.createNativeQuery("select * from ecom_order_line where order_id = :orderid ", EcomOrderLine.class);
		query.setParameter("orderid", orderid);
		CacheHelper.formQueryCache(query, UruAppConstants.FIND_ORDERID_FROM_ORDERLINE);
		@SuppressWarnings("unchecked")
		List<EcomOrderLine> ecomOrderList =  (List<EcomOrderLine>)query.getResultList();
		String[] mailAddressTo={to_mail1,to_mail2,account_email,ibrar_email,parmeshewr_email};
		ValocityTemplate.order_notify("create_order.vm",mailAddressTo,eo,ecomOrderList);

		return e2m.converOrderToModel(eo);
	}

	@Override
	@Transactional
	public EcomOrderModel updateOrder(EcomOrderModel eom) {
		EcomOrder eo = m2e.convertOrderToEntity(eom);
		return e2m.converOrderToModel(em.merge(eo));
		
	}

	@Override
	public List<EcomOrderModel> getOrdersByCustomerId(String custId) {
		
		@SuppressWarnings("unchecked")
		Query query = em.createNamedQuery("EcomOrder.findOrderForCustomer");
		query.setParameter("n", Long.valueOf(custId));
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_ORDER_FINDFOR_CUST);
		List<EcomOrder> orders = (List<EcomOrder>) query.getResultList();
		
		List<EcomOrderModel> orderModels = new ArrayList<EcomOrderModel>();

		for (EcomOrder order : orders) {
			orderModels.add(e2m.converOrderToModel(order));
		}
		
		return orderModels;
	}

	@Override
	public List<EcomOrderModel> getOrdersByCustomerIdNStatus(String custId, String status) {
		
		@SuppressWarnings("unchecked")
		Query query =  em.createNamedQuery("EcomOrder.findOrderForCustomerNStatus");
		query.setParameter("n", Long.valueOf(custId)).setParameter("m", status);
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_ORDER_FINDFOR_CUST_STATUS);
		List<EcomOrder> orders = (List<EcomOrder>)query.getResultList();
		
		List<EcomOrderModel> orderModels = new ArrayList<EcomOrderModel>();
		for (EcomOrder order : orders) {
			orderModels.add(e2m.converOrderToModel(order));
		}
		return orderModels;
	}

	@Override
	public EcomOrderLineModel updateOrderLineItem(Long orderLineId, String status) {

		EcomOrderLine eol = em.find(EcomOrderLine.class, orderLineId);
		eol.setStatus(status);
		return e2m.convertOrderItemToModel(em.merge(eol));
	}

	@Override
	public List<EcomOrderModel> findAllOrder() {
		Query query = em.createNamedQuery("EcomOrder.findAll", EcomOrder.class);
		List<EcomOrder> ecomOrder = query.getResultList();
		if (ecomOrder != null && ecomOrder.size() > 0) {
			List<EcomOrderModel> ordermodels = new ArrayList<EcomOrderModel>();
			for (EcomOrder pc : ecomOrder) {
				ordermodels.add(e2m.converOrderToModel(pc));
			}
			return ordermodels;
		}
		return null;
	}

	@Override
	public List<EcomOrderModel> findOrderByStatus(String status) {
		
		@SuppressWarnings("unchecked")
		Query query = em.createNamedQuery("EcomOrder.findOrderForStatus");
		query.setParameter("s", String.valueOf(status));
		CacheHelper.formQueryCache(query, UruAppConstants.ECOM_ORDER_FINDFOR_STATUS);
		List<EcomOrder> orders = (List<EcomOrder>) query.getResultList();
		
		List<EcomOrderModel> orderModels = new ArrayList<EcomOrderModel>();

		for (EcomOrder order : orders) {
			orderModels.add(e2m.converOrderToModel(order));
		}
		
		return orderModels;
	}

	@Override
	public List<EcomOrderModel> findOrderByStatusWithPaging(String status,int pageNumber, int pageSize) {
		int offSet = (pageNumber-1) * pageSize;
		Query query = em.createNativeQuery("select * from ecom_order where status = :status order by order_id desc LIMIT "+pageSize+" OFFSET "+offSet+" ", EcomOrder.class);
		query.setParameter("status", status);
		CacheHelper.formQueryCache(query, UruAppConstants.ORDER_FINDBYSTATUS_WITH_PAGING);
		@SuppressWarnings("unchecked")
		List<EcomOrder> ecomOrderList =  (List<EcomOrder>)query.getResultList();
		List<EcomOrderModel> ecomOrderModelList = new ArrayList<EcomOrderModel>();
		for(EcomOrder ecomOrder: ecomOrderList)
		{
			EcomOrderModel ecomOrderModel = e2m.converOrderToModel(ecomOrder);
			ecomOrderModelList.add(ecomOrderModel);
			
		}
		return ecomOrderModelList;
	}

	@Override
	public List<EcomOrderModel> findAllOrderWithPaging(int pageNumber,int pageSize) {
		int offSet = (pageNumber-1) * pageSize;
		Query query = em.createNativeQuery("select * from ecom_order order by order_id desc LIMIT "+pageSize+" OFFSET "+offSet+" ", EcomOrder.class);

		CacheHelper.formQueryCache(query, UruAppConstants.FINDALL_ORDER_WITH_PAGING);
		@SuppressWarnings("unchecked")
		List<EcomOrder> ecomOrderList =  (List<EcomOrder>)query.getResultList();
		List<EcomOrderModel> ecomOrderModelList = new ArrayList<EcomOrderModel>();
		for(EcomOrder ecomOrder: ecomOrderList)
		{
			EcomOrderModel ecomOrderModel = e2m.converOrderToModel(ecomOrder);
			ecomOrderModelList.add(ecomOrderModel);
			
		}
		return ecomOrderModelList;
	}

	@Override
	@Transactional
	public IziResponse updateOrderPayment(EcomPaymentModel epm) {
		IziResponse resp = new IziResponse();
		resp.setMessage("sorry,Id is not present");
		resp.setStatus(false);
		resp.setResponse(null);
		List<EcomPayment> ecompayment =  em
				.createNamedQuery("EcomPayment.findById")
				.setParameter("n", (Long)epm.getId()).getResultList();
		if(ecompayment.size() > 0){
			EcomPayment payment=new EcomPayment();
			payment.setId(epm.getId());
			payment.setTransactionId(epm.getTransactionId());
			payment.setType(epm.getType());
			payment.setTranEntryStatus(epm.getTranEntryStatus());
			payment.setTransactionAmount(epm.getTransactionAmount());
			payment.setImageUrl(epm.getImageUrl());
			payment.setBankName(epm.getBankName());
			payment.setIfscCode(epm.getIfscCode());
			payment.setCreatedBy(epm.getCreatedBy());
			payment.setCreatedDate(epm.getCreatedDate());
			payment.setModifiedBy(epm.getModifiedBy());
			payment.setModifiedDate(epm.getModifiedDate());
			em.merge(payment);
			resp.setMessage("Updation Successfull");
			resp.setStatus(true);
			resp.setResponse(null);
			resp.setObjectId(String.valueOf(payment.getId()));
		}
		
		return resp;
	}

	
	
}	
	
