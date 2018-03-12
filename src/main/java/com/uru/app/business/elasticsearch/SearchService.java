package com.uru.app.business.elasticsearch;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;

import com.uru.app.dao.IProductDao;
import com.uru.app.entity.EcomItem;

public class SearchService {
	
	@Inject
	ElasticSearchConfig elasticSearchConfig;
	
	@Inject
	IProductDao productDao;
	
	public static final String INDEX="product_item_search";
	public static final String MAPPING="products";

	
	public SearchResponse getAll(String value){
		FuzzyQueryBuilder query= QueryBuilders.fuzzyQuery("_all", value).fuzziness(Fuzziness.AUTO).maxExpansions(15);
		SortBuilder sortBuilder= SortBuilders.scoreSort();
		
		SearchResponse response = elasticSearchConfig.getClient().prepareSearch(INDEX)
		        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
		        .setQuery(query)              // Query
		        .addSort(sortBuilder)
		        .setFrom(0).setSize(60).setExplain(true)
		        .execute()
		        .actionGet();	
		
		
		
		return response;
		
	}

	public BulkResponse refresh() throws IOException, InterruptedException, ExecutionException{
		
		List<Object> list=productDao.getAllForIndex();
		BulkRequestBuilder bulkRequest = elasticSearchConfig.getClient().prepareBulk();

		
		for(Object obj: list){
		Object[] array=(Object[])obj;
		
		String id=  String.valueOf(array[11])==null?"P": String.valueOf(array[11])+"_"+ String.valueOf(array[0]);
		
		bulkRequest.add(elasticSearchConfig.getClient().prepareIndex(INDEX,MAPPING,id).setSource(jsonBuilder()
	            .startObject()
                .field("ProductId", array[0])
                .field("ProductDisplayUrl", array[1])
                .field("ProductLongDescription", array[2])
                .field("ProductShortDescription", array[3])
                .field("CategoryId", array[4])
                .field("CategoryLongDesciption", array[5])
                .field("CategoryShortDescription", array[6])
                .field("ProductKeyword", array[7])
                .field("ItemName", array[8])
                .field("ItemLongDescription", array[9])
                .field("ItemShortDescription", array[10])
                .field("ItemId", array[11])
                .field("RootCat", array[12])
                .field("CatName", array[13])
            .endObject()));
		
		}
		BulkResponse bulkResponse = bulkRequest.get();
	//	refreshIndex(INDEX);
		return bulkResponse;
	}
	
	public UpdateResponse addItem(EcomItem ecomItem) throws IOException{
		UpdateResponse up=null;
		
		String id=  String.valueOf(ecomItem.getSku())==null?"P": String.valueOf(ecomItem.getSku())+"_"+ String.valueOf(ecomItem.getEcomProduct().getProductId());
		
		IndexRequest indexRequest = new IndexRequest(INDEX, MAPPING,id)
		        .source(jsonBuilder()
		            .startObject()
		                .field("_id", id)
		                .field("ProductId", ecomItem.getEcomProduct().getProductId())
		                .field("ProductDisplayUrl",ecomItem.getEcomProduct().getDetDisplayJspUrl())
		                .field("ProductLongDescription", ecomItem.getEcomProduct().getLongDesc())
		                .field("ProductShortDescription", ecomItem.getEcomProduct().getShortDesc())
		                .field("CategoryId", ecomItem.getEcomProduct().getEcomCategory().getCategoryId())
		                .field("CategoryLongDesciption",ecomItem.getEcomProduct().getEcomCategory().getLongDesc())
		                .field("CategoryShortDescription", ecomItem.getEcomProduct().getEcomCategory().getShortDesc())
		                .field("ProductKeyword", ecomItem.getEcomProduct().getEcomProductKeywords())
		                .field("ItemName",ecomItem.getName())
		                .field("ItemLongDescription", ecomItem.getLongDesc())
		                .field("ItemShortDescription", ecomItem.getShortDesc())
		                .field("ItemId", ecomItem.getSku())
		            
		            .endObject());
		
		UpdateRequest updateRequest = new UpdateRequest(INDEX, MAPPING,  id)
		        .doc(jsonBuilder()
		            .startObject()		           
		            .field("_id", id)
	                .field("ProductId", ecomItem.getEcomProduct().getProductId())
	                .field("ProductDisplayUrl",ecomItem.getEcomProduct().getDetDisplayJspUrl())
	                .field("ProductLongDescription", ecomItem.getEcomProduct().getLongDesc())
	                .field("ProductShortDescription", ecomItem.getEcomProduct().getShortDesc())
	                .field("CategoryId", ecomItem.getEcomProduct().getEcomCategory().getCategoryId())
	                .field("CategoryLongDesciption",ecomItem.getEcomProduct().getEcomCategory().getLongDesc())
	                .field("CategoryShortDescription", ecomItem.getEcomProduct().getEcomCategory().getShortDesc())
	                .field("ProductKeyword", ecomItem.getEcomProduct().getEcomProductKeywords())
	                .field("ItemName",ecomItem.getName())
	                .field("ItemLongDescription", ecomItem.getLongDesc())
	                .field("ItemShortDescription", ecomItem.getShortDesc())
	                .field("ItemId", ecomItem.getSku())
		            .endObject())
		        .upsert(indexRequest);  
		
		  up=elasticSearchConfig.getClient().update(updateRequest).actionGet();
		  refreshIndex(INDEX);

		return up;
		
	}
	
	   public void delete(String id) {
		   try{
	        DeleteResponse response = elasticSearchConfig.getClient().prepareDelete(INDEX, MAPPING, id).execute().actionGet();
	        refreshIndex(INDEX);
		   }
		   catch(Exception e){
			   e.printStackTrace();
		   }
	    }
	
	 public void refreshIndex(String index){
	        RefreshRequest r=new RefreshRequest(index);
	        elasticSearchConfig.getClient().admin().indices().refresh(r).actionGet();
	    }
	
	
}
