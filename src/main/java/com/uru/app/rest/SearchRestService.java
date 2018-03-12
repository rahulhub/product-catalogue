package com.uru.app.rest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchResponse;

import com.uru.app.business.elasticsearch.SearchService;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@JsonSerialize
public class SearchRestService {

	@Inject 
	private SearchService searchService;	
	
	@GET
	@Path("/fetchAll")
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResponse fetchAll(@QueryParam("keyword") String keyword) {
		refresh();
		return searchService.getAll(keyword);
		
	}
	
	
	@GET
	@Path("/refresh")
	@Produces(MediaType.APPLICATION_JSON)
	public BulkResponse refresh() {
		try {
			return searchService.refresh();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
