package com.uru.app.rest;

import java.util.List;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.IOrderService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomOrderLineModel;
import com.uru.app.model.EcomOrderModel;
import com.uru.app.model.EcomPaymentModel;


import io.swagger.annotations.Api;

@Path("/orderService")
@Api(value="/orderService")
@Produces(MediaType.APPLICATION_JSON)
public class OrderRestService {
	
	@Inject
	IOrderService orderService;
	
	@POST
	@Path("/createOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	public EcomOrderModel createOrder(EcomOrderModel eom) throws Exception{
		return orderService.createOrder(eom);
	}
	
	@POST
	@Path("/updateOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	public EcomOrderModel updateOrder(EcomOrderModel eom){
		return orderService.updateOrder(eom);
	}
	
	@GET
	@Path("/getOrdersByCustomerId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomOrderModel> getOrdersByCustomerId(@QueryParam(value = "custId")String custId){
		return orderService.getOrdersByCustomerId(custId);
	}
	
	@GET
	@Path("/getOrdersByCustomerIdNStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomOrderModel> getOrdersByCustomerIdNStatus(@QueryParam(value = "custId")String custId,@QueryParam(value = "status")String status){
		return orderService.getOrdersByCustomerIdNStatus(custId, status);
	}
	
	@POST
	@Path("/updateOrderLineStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	public EcomOrderLineModel updateOrderLineStatus(EcomOrderLineModel eolm){
		return orderService.updateOrderLineItem(eolm);
	}
	
	@GET
	@Path("/findAllOrder")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomOrderModel> findAllOrder() {
		return orderService.findAllOrder();
	}
	
	@GET
	@Path("/findAllOrderWithPaging")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomOrderModel> findAllOrderWithPaging(@QueryParam("pageNumber") int pageNumber,@QueryParam("pageSize") int pageSize) {
		return orderService.findAllOrderWithPaging(pageNumber,pageSize);
	}
	
	@GET
	@Path("/findOrderByStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomOrderModel> findOrderByStatus(@QueryParam(value = "status")String status) {
		return orderService.findOrderByStatus(status);
	}
	
	@GET
	@Path("/findOrderByStatusWithPaging")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomOrderModel> findOrderByStatusWithPaging(@QueryParam("status") String status,@QueryParam("pageNumber") int pageNumber,@QueryParam("pageSize") int pageSize) {
		return orderService.findOrderByStatusWithPaging(status,pageNumber,pageSize);
	}
	
	@POST
	@Path("/updateOrderPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public IziResponse updateOrderPayment(EcomPaymentModel epm) {
		return orderService.updateOrderPayment(epm);
	}
	
	
}
