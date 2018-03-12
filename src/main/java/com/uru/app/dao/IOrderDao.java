package com.uru.app.dao;

import java.util.List;

import javax.naming.NamingException;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomOrderLineModel;
import com.uru.app.model.EcomOrderModel;
import com.uru.app.model.EcomPaymentModel;


public interface IOrderDao {

	EcomOrderModel createOrder(EcomOrderModel eom) throws NamingException, Exception;
	EcomOrderModel updateOrder(EcomOrderModel eom);
	List<EcomOrderModel> getOrdersByCustomerId(String custId);
	List<EcomOrderModel> getOrdersByCustomerIdNStatus(String custId,String status);
	EcomOrderLineModel updateOrderLineItem(Long orderLineId, String status);
	List<EcomOrderModel> findAllOrder();
	List<EcomOrderModel> findOrderByStatus(String status);
	List<EcomOrderModel> findOrderByStatusWithPaging(String status,int pageNumber, int pageSize);
	List<EcomOrderModel> findAllOrderWithPaging(int pageNumber, int pageSize);
	IziResponse updateOrderPayment(EcomPaymentModel epm);
	
	
	
}
