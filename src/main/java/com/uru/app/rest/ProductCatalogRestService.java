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

import com.uru.app.business.IConfigManager;
import com.uru.app.business.service.ICatalogService;
import com.uru.app.business.service.IAttributeService;
import com.uru.app.business.service.IProductService;
import com.uru.app.business.util.CalcTemplate;
import com.uru.app.common.response.IziResponse;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.entity.EcomProduct;
import com.uru.app.model.CatalogPropertyKeyModel;
import com.uru.app.model.CatalogPropertyValueModel;
import com.uru.app.model.CategoryRates;
import com.uru.app.model.EcomCatalogModel;
import com.uru.app.model.EcomDiscountAssociationModel;
import com.uru.app.model.EcomDiscountModel;
import com.uru.app.model.EcomDiscountSetModel;
import com.uru.app.model.EcomProductModel;
import com.uru.app.model.FilterData;

import io.swagger.annotations.Api;

@Path("/prodCategory")
@Produces(MediaType.APPLICATION_JSON)
public class ProductCatalogRestService {

	@Inject
	IProductService productService;
	
	@Inject
	ICatalogService catalogService;
	
	@Inject
	IAttributeService attService;
	
	@Inject
	IConfigManager configManager;

	@GET
	@Path("/getAllRootCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomCatalogModel> getAllRootCategories() {
		return catalogService.getAllRootCategories();
	}
	
	@GET
	@Path("/getAttributes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CatalogPropertyKeyModel> getAllAttributes() {
		return attService.getAllPropertyKeys();
	}
	
	@GET
	@Path("/getAllSubCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomCatalogModel> getAllSubCategories(@QueryParam("categoryId") String categoryId) {
		return catalogService.getAllSubCategories(categoryId);
	}
	
	/**************** API for find all Product for visible is true *********************/
	@GET
	@Path("/getProductsByCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomProductModel> getProductsByCategory(@QueryParam("categoryId") String categoryId) {
		return productService.getProductsByCategory(categoryId);
	}
	
	@GET
	@Path("/getCategoryById")
	@Produces(MediaType.APPLICATION_JSON)
	public EcomCatalogModel getCategoryById(@QueryParam("categoryId") Long categoryId) {
		return catalogService.getCategoryById(Long.valueOf(categoryId));
	}
	
	@POST
	@Path("/createProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createProduct(EcomProductModel ecomProductModel) {

		return productService.createProduct(ecomProductModel);
	}
	
	@POST
	@Path("/createCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createCategory(EcomCatalogModel ecomCatalogModel) {

		return catalogService.createCategory(ecomCatalogModel);
	}
	
	@POST
	@Path("/updateProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateProduct(EcomProductModel ecomProductModel) {

		return productService.updateProduct(ecomProductModel);
	}
	
	@POST
	@Path("/uppdateCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean uppdateCategory(EcomCatalogModel ecomCatalogModel) {

		return catalogService.updateCategory(ecomCatalogModel);
	}
	
	
	@POST
	@Path("/deleteProductById")
	@Consumes(MediaType.APPLICATION_JSON)
	public IziResponse deleteProductById(@QueryParam("productId") long productId,@QueryParam("isDeleted") int isDeleted) {

		return productService.deleteProductById(productId,isDeleted);
	}
	
	/*@POST
	@Path("/deleteProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteProduct(@QueryParam("productId") long productId) {

		return productService.deleteProduct(productId);
	}*/

	@POST
	@Path("/deleteCategoryById")
	@Consumes(MediaType.APPLICATION_JSON)
	public IziResponse deleteCategoryById(@QueryParam("categoryId") long categoryId,@QueryParam("isDeleted") int isDeleted) {

		return catalogService.deleteCategoryById(categoryId,isDeleted);
	}
	
	@POST
	@Path("/createCatalogPropertyKey")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createCatalogPropertyKey(CatalogPropertyKeyModel catalogPropertyKeyModel) {

		return catalogService.createCatalogPropertyKey(catalogPropertyKeyModel);
	}
	
	@POST
	@Path("/updateCatalogPropertyKey")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateCatalogPropertyKey(CatalogPropertyKeyModel catalogPropertyKeyModel) {

		return catalogService.updateCatalogPropertyKey(catalogPropertyKeyModel);
	}
	
	
	@POST
	@Path("/deleteCatalogPropertyKey")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteCatalogPropertyKey(CatalogPropertyKeyModel catalogPropertyKeyModel) {

		return catalogService.deleteCatalogPropertyKey(catalogPropertyKeyModel);
	}
	
	@POST
	@Path("/createCatalogPropertyValue")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createCatalogPropertyValue(CatalogPropertyValueModel catalogPropertyValueModel) {

		return catalogService.createCatalogPropertyValue(catalogPropertyValueModel);
	}
	
	@POST
	@Path("/updateCatalogPropertyValue")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateCatalogPropertyValue(CatalogPropertyValueModel catalogPropertyValueModel) {

		return catalogService.updateCatalogPropertyValue(catalogPropertyValueModel);
	}
	
	
	@POST
	@Path("/deleteCatalogPropertyValue")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteCatalogPropertyValue(CatalogPropertyValueModel catalogPropertyValueModel) {

		return catalogService.deleteCatalogPropertyValue(catalogPropertyValueModel);
	}
	
//	@GET
//	@Path("test")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String testCreate(){
//		return catalogService.testCreate();
//	}
	
	@POST
	@Path("/updateCategoryRates")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateProduct(CategoryRates categoryRates) {
		return catalogService.updateCategoryRates(categoryRates);
	}
	
	@GET
	@Path("/getCalcTemplates")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CalcTemplate> getCalcTemplates(){
		return configManager.getTemplates();
	}
	
	@GET
	@Path("/getCalcTemplateByName")
	@Produces(MediaType.APPLICATION_JSON)
	public CalcTemplate getCalcTemplateByName(@QueryParam("templateName") String templateName){
		return configManager.getTemplateByName(templateName);
	}
	
	@GET
	@Path("/getFilterByCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FilterData> getFilterByCategory(@QueryParam("categoryId")Long categoryId){
		return catalogService.getFilterByCategory(categoryId);
	}
	
	@POST
	@Path("/updateDiscount")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateDiscount(EcomDiscountModel ecomDisModel) {

		return productService.updateDiscount(ecomDisModel);
	}
	
	@POST
	@Path("/updateDiscountSet")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateDiscountSet(EcomDiscountSetModel ecomDisSetModel) {

		return productService.updateDiscountSet(ecomDisSetModel);
	}
	
	@POST
	@Path("/updateDiscountAssociation")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateDiscountAssociation(EcomDiscountAssociationModel ecomDisAssoModel) {

		return productService.updateDiscountAssociation(ecomDisAssoModel);
	}
	
	/******************** API for Product Pagination  ***********************/
	@GET
	@Path("/productPaging")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomProductModel> productLevelPagination(@QueryParam("categoryId") Long categoryId,@QueryParam("pageNumber") int pageNumber,@QueryParam("pageSize") int pageSize) {
		return productService.productLevelPagination(categoryId,pageNumber,pageSize);
	}
	
	/************** API for find All Product for Category ******************/
	@GET
	@Path("/getAllProductsByCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EcomProductModel> getAllProductsByCategory(@QueryParam("categoryId") String categoryId) {
		return productService.getAllProductsByCategory(categoryId);
	}
	
	
}
