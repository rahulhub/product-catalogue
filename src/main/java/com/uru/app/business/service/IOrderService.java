package com.uru.app.business.service;

import java.util.List;

import javax.naming.NamingException;

import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomOrderLineModel;
import com.uru.app.model.EcomOrderModel;
import com.uru.app.model.EcomPaymentModel;
import com.uru.app.model.EcomProductModel;

/**
 * @author Rahul Dev
 *
 */
public interface IOrderService {
	
	EcomOrderModel createOrder(EcomOrderModel eom) throws NamingException, Exception;
	EcomOrderModel updateOrder(EcomOrderModel eom);
	List<EcomOrderModel> getOrdersByCustomerId(String custId);
	List<EcomOrderModel> getOrdersByCustomerIdNStatus(String custId,String status);
	
	EcomOrderLineModel updateOrderLineItem(EcomOrderLineModel eolm);
	List<EcomOrderModel> findAllOrder();
	List<EcomOrderModel> findOrderByStatus(String status);
	List<EcomOrderModel> findOrderByStatusWithPaging(String status,int pageNumber, int pageSize);
	List<EcomOrderModel> findAllOrderWithPaging(int pageNumber, int pageSize);
	IziResponse updateOrderPayment(EcomPaymentModel epm);
	
	
}
