package com.uru.app.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.uru.app.business.service.ICartService;
import com.uru.app.model.EcomCartModel;
import com.uru.app.model.EcomItemModel;
import com.uru.app.model.EcomProductModel;

import io.swagger.annotations.Api;

@Path("/cartService")
@Api(value = "/cartService")
@Produces(MediaType.APPLICATION_JSON)
public class CartRestService {
	
	@Inject
	ICartService cartService;
	
	@POST
	@Path("/addToCart")
	@Consumes(MediaType.APPLICATION_JSON)
	public EcomCartModel addToCart(EcomCartModel cartModel) {
		return cartService.addToCart(cartModel);
	}
	
	@POST
	@Path("/deleteAllItemsForUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteAllItemsForUser(EcomCartModel cartModel) {
		return cartService.deleteAllItemsForUser(cartModel.getCustId());
	}
	
	@POST
	@Path("/removeItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean removeItem(EcomCartModel cartModel) {
		return cartService.removeItem(cartModel.getCustId(), cartModel.getSku());
	}
	
	@GET
	@Path("/getItemsInCart")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<EcomCartModel> getItemsInCart(@QueryParam(value = "custId") Long custId) {
		return cartService.getItemsInCart(custId);
	}
	
	@POST
	@Path("/updateItemQty")
	@Consumes(MediaType.APPLICATION_JSON)
	public EcomCartModel updateItemQty(EcomCartModel cartModel) {
		return cartService.updateItemQty(cartModel);
	}

}
