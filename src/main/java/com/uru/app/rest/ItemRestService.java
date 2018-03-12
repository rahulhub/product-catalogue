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

import com.uru.app.business.service.IItemService;
import com.uru.app.common.response.IziResponse;
import com.uru.app.model.EcomItemMediaModel;
import com.uru.app.model.EcomItemModel;

import io.swagger.annotations.Api;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
public class ItemRestService {

	@Inject
	IItemService itemService;

	@GET
	@Path("/allItems")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomItemModel> getAllItems() {
		return itemService.getAllItems();
	}
	
	@GET
	@Path("/itemById")
	@Produces(MediaType.APPLICATION_JSON)
	public EcomItemModel getItemById(@QueryParam("skuId") Long skuId) {
		return itemService.getItemById(skuId);
	}

	@POST
	@Path("/createItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createItem(EcomItemModel ecomItemModel) {

		return itemService.createItem(ecomItemModel);
	}
	
	@POST
	@Path("/deleteItemById")
	@Consumes(MediaType.APPLICATION_JSON)
	public IziResponse deleteItemById(@QueryParam("sku") long sku,@QueryParam("isDeleted") int isDeleted) {

		return itemService.deleteItemById(sku,isDeleted);
	}
	
	@POST
	@Path("/updateItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateItem(EcomItemModel ecomItemModel) {

		return itemService.updateItem(ecomItemModel);
	}
	
	@POST
	@Path("/addItemMedia")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addItemMedia(EcomItemMediaModel ecomItemMediaModel) {

		return itemService.addItemMedia(ecomItemMediaModel);
	}
	
	@POST
	@Path("/updateItemMedia")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateItemMedia(EcomItemMediaModel ecomItemModel) {

		return itemService.updateItemMedia(ecomItemModel);
	}
	
}
