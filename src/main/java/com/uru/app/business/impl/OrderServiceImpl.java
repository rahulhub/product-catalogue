package com.uru.app.business.impl;

import java.util.List;

import javax.ejb.AccessTimeout;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;


import com.uru.app.business.service.IOrderService;
import com.uru.app.common.response.IziResponse;

import com.uru.app.dao.IOrderDao;
import com.uru.app.model.EcomOrderLineModel;
import com.uru.app.model.EcomOrderModel;
import com.uru.app.model.EcomPaymentModel;


/**
 * @author Rahul Dev
 *
 */

@javax.ejb.Stateless
@AccessTimeout(value = 20000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderServiceImpl implements IOrderService {

	@Inject 
	IOrderDao orderDao;
	
	@Override
	public EcomOrderModel createOrder(EcomOrderModel eom) throws Exception {
		return orderDao.createOrder(eom);
	}

	@Override
	public EcomOrderModel updateOrder(EcomOrderModel eom) {
		return orderDao.updateOrder(eom);
	}

	@Override
	public List<EcomOrderModel> getOrdersByCustomerId(String custId) {
		return orderDao.getOrdersByCustomerId(custId);
	}

	@Override
	public List<EcomOrderModel> getOrdersByCustomerIdNStatus(String custId, String status) {
		return orderDao.getOrdersByCustomerIdNStatus(custId, status);
	}

	@Override
	public EcomOrderLineModel updateOrderLineItem(EcomOrderLineModel eolm) {
		
		return orderDao.updateOrderLineItem(eolm.getOrderLineId(), eolm.getStatus());
	}

	@Override
	public List<EcomOrderModel> findAllOrder() {
		return orderDao.findAllOrder();
	}

	@Override
	public List<EcomOrderModel> findOrderByStatus(String status) {
		return orderDao.findOrderByStatus(status);
	}

	@Override
	public List<EcomOrderModel> findOrderByStatusWithPaging(String status,int pageNumber, int pageSize) {
		return orderDao.findOrderByStatusWithPaging(status,pageNumber,pageSize);
	}

	@Override
	public List<EcomOrderModel> findAllOrderWithPaging(int pageNumber,int pageSize) {
		return orderDao.findAllOrderWithPaging(pageNumber,pageSize);
	}

	@Override
	public IziResponse updateOrderPayment(EcomPaymentModel epm) {
		return orderDao.updateOrderPayment(epm);
	}

	

}
