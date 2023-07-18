package com.tousif.service.impl;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.ClearScrollResponse;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tousif.client.SearchClient;
import com.tousif.model.SearchResultVo;


@Component
public class SearchService {

	@Autowired
	private SearchClient searchClient;
	
	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);
	
	/**
	 * @SEARCH_REQUEST
	 * The SearchRequest is used for any operation that has to do with searching documents, aggregations, suggestions
	 * and also offers ways of requesting highlighting on the resulting documents.
	 * In its most basic form, we can add a query to the request:
	 * 
	 * 1. Creates the SeachRequest. Without arguments this runs against all indices.
	 * 2. Most search parameters are added to the SearchSourceBuilder. It offers setters for everything that goes into the search request body.
	 * 3. Add a match_all query to the SearchSourceBuilder.
	 * 4. Add the SearchSourceBuilder to the SeachRequest.
	 */
	public SearchResponse searchAll() {

		RestHighLevelClient client = searchClient.getClient();
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 

		
		SearchRequest searchRequest = new SearchRequest(); //Search all indices
		
		/**
		 * @OPTIONAL_ARGUMENTS
		 * Restricts the request to an index
		 */
//		SearchRequest searchRequest = new SearchRequest("vca_mdm_index"); //search only passed index

		searchRequest.source(searchSourceBuilder);
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
		
//		CfgBusinessIndustry cfgBusinessIndustry = result.getFirstHit(CfgBusinessIndustry.class).source;
		
	}

	
	/**
	 * @SEARCH_SOURCE_BUILDER
	 * Most options controlling the search behavior can be set on the SearchSourceBuilder, which contains more or less the equivalent
	 * of the options in the search request body of the Rest API.
	 * 
	 * 1. Create a SearchSourceBuilder with default options.
	 * 2. Set the query. Can be any type of QueryBuilder
	 * 3. Set the from option that determines the result index to start searching from. Defaults to 0.
	 * 4. Set the size option that determines the number of search hits to return. Defaults to 10.
	 * 5. Set an optional timeout that controls how long the search is allowed to take.
	 * 6. After this, the SearchSourceBuilder only needs to be added to the SearchRequest:
	 */
	public SearchResponse searchAllWithinIndex(String index) {
		
		RestHighLevelClient client = searchClient.getClient();
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 

		/**
		 * @OPTIONAL_ARGUMENTS
		 * Restricts the request to an index
		 */
//		SearchRequest searchRequest = new SearchRequest("vca_mdm_index"); //search only passed index
		
		SearchRequest searchRequest = new SearchRequest(); 
		searchRequest.indices(index).source(searchSourceBuilder);
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}

	
	/**
	 * @BUILDING_QUERIES
	 * Search queries are created using QueryBuilder objects. A QueryBuilder exists for every search query type supported by Elasticsearch’s Query DSL.
	 * 
	 * @QUERY_BUILDER
	 * A QueryBuilder can be created using its constructor:
	 * 
	 * MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user", "kimchy");
	 * 
	 * Create a full text Match Query that matches the text "kimchy" over the field "user".
	 */
	public SearchResponse searchFieldInIndex(String index, String fieldName, String fieldValue) {
		RestHighLevelClient client = searchClient.getClient();
		
		MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(fieldName, fieldValue);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
//		searchSourceBuilder.query(QueryBuilders.existsQuery(field)); 
		searchSourceBuilder.query(matchQueryBuilder);
		
		SearchRequest searchRequest = new SearchRequest(); 
		searchRequest.source(searchSourceBuilder).indices(index);
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}
	
	
	/**
	 * @FUZZY_MATCHING
	 * Once created, the QueryBuilder object provides methods to configure the options of the search query it creates:
	 * 
	 * matchQueryBuilder.fuzziness(Fuzziness.AUTO); 
	 * matchQueryBuilder.prefixLength(3); 
	 * matchQueryBuilder.maxExpansions(10);
	 * 
	 * 1. Enable fuzzy matching on the match query
	 * 2. Set the prefix length option on the match query
	 * 3. Set the max expansion options to control the fuzzy process of the query
	 */
	public SearchResponse searchFieldInIndexFuzziness(String index, String fieldName, String fieldValue) {
		RestHighLevelClient client = searchClient.getClient();
		
		MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(fieldName, fieldValue);
		matchQueryBuilder.fuzziness(Fuzziness.AUTO); 
		matchQueryBuilder.prefixLength(3); 
		matchQueryBuilder.maxExpansions(10);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
//		searchSourceBuilder.query(QueryBuilders.existsQuery(field)); 
		searchSourceBuilder.query(matchQueryBuilder);
		
		
		SearchRequest searchRequest = new SearchRequest(); 
		searchRequest.source(searchSourceBuilder).indices(index);
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}
	
	
	
	
	/**
	 * @QUERY_BUILDER
	 * QueryBuilder objects can also be created using the QueryBuilders utility class. This class provides
	 * helper methods that can be used to create QueryBuilder objects using a fluent programming style.
	 */
	public SearchResponse searchOptions(String index, String fieldName, String fieldValue) {
		RestHighLevelClient client = searchClient.getClient();
		
//		MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(fieldName, fieldValue);
//		matchQueryBuilder.fuzziness(Fuzziness.AUTO); 
//		matchQueryBuilder.prefixLength(3); 
//		matchQueryBuilder.maxExpansions(10);

		QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(fieldName, fieldValue)
                .fuzziness(Fuzziness.AUTO)
                .prefixLength(3)
                .maxExpansions(10);
		
		/**
		 * Whatever the method used to create it, the QueryBuilder object must be added to the SearchSourceBuilder as follows:
		 */
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
//		searchSourceBuilder.query(QueryBuilders.existsQuery(field)); 
		searchSourceBuilder.query(matchQueryBuilder);
		
		SearchRequest searchRequest = new SearchRequest(); 
		searchRequest.source(searchSourceBuilder).indices(index);
		

		/**
		 * @SOURCE_FILTERING
		 * By default, search requests return the contents of the document _source but like in the Rest API you can overwrite this behavior.
		 * For example, you can turn off _source retrieval completely:
		 */
//		searchSourceBuilder.fetchSource(false);
		
		/**
		 * The method also accepts an array of one or more wildcard patterns to control which fields get included or excluded in a more fine grained way:
		 */
		String[] includeFields = new String[] {"business_industry_desc", "created_by", "*industry*"};
//		String[] includeFields = null;
		String[] excludeFields = new String[] {"@timestamp", "@version"};
//		String[] excludeFields = null;
		searchSourceBuilder.fetchSource(includeFields, excludeFields);
		
		/**
		 * @SPECIFYING_SORTING
		 * The SearchSourceBuilder allows to add one or more SortBuilder instances. There are four special implementations
		 * (Field-, Score-, GeoDistance- and ScriptSortBuilder).
		 */
		searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.ASC));
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}
	
	/**
	 * @REQUESTING_HIGHLIGHTING
	 * Highlighting search results can be achieved by setting a HighlightBuilder on the SearchSourceBuilder.
	 * Different highlighting behaviour can be defined for each fields by adding one or more HighlightBuilder.
	 * Field instances to a HighlightBuilder.
	 * 
	 * 1. Creates a new HighlightBuilder
	 * 2. Create a field highlighter for the title field
	 * 3. Set the field highlighter type
	 * 4. Add the field highlighter to the highlight builder
	 */
	public SearchResponse requestingHighlighting(String index, String fieldName, String fieldValue) {
		RestHighLevelClient client = searchClient.getClient();
		
		QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(fieldName, fieldValue)
                .fuzziness(Fuzziness.AUTO)
                .prefixLength(3)
                .maxExpansions(10);
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(matchQueryBuilder));
		
		SearchRequest searchRequest = new SearchRequest(index); 
		searchRequest.source(searchSourceBuilder);
		
//		searchSourceBuilder.fetchSource(false);
		searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.ASC));
		
		HighlightBuilder highlightBuilder = new HighlightBuilder(); 
		
		HighlightBuilder.Field highlightState = new HighlightBuilder.Field(fieldName);
		highlightState.highlighterType("unified");
		highlightBuilder.field(highlightState);  
		
		HighlightBuilder.Field highlightCountry = new HighlightBuilder.Field(fieldValue);
		highlightBuilder.field(highlightCountry);
		
		searchSourceBuilder.highlighter(highlightBuilder);
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SearchHits hits = searchResponse.getHits();
		
		for (SearchHit hit : hits.getHits()) {
		    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
		    HighlightField highlight = highlightFields.get(fieldName); 
		    Text[] fragments = highlight.fragments();  
		    String fragmentString = fragments[0].string();
		    System.out.println();
		}
		
		return searchResponse;
	}
	
	/**
	 * @REQUESTING_AGGREGATIONS
	 * Aggregations can be added to the search by first creating the appropriate AggregationBuilder and then setting it on the SearchSourceBuilder.
	 * In the following example we create a terms aggregation on "lowest_generic_line_hierarchy_id" with a sub-aggregation on the average number:
	 */
	@SuppressWarnings("unused")
	public SearchResponse requestingAggregations(String index, String fieldName1, String fieldName2) {
		
		RestHighLevelClient client = searchClient.getClient();

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		
		SearchRequest searchRequest = new SearchRequest(index);
		
		
		TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_business_city")
		        .field(fieldName1+".keyword");
		
		aggregation.subAggregation(AggregationBuilders.avg("avg_inspection_scores")
		        .field(fieldName2));
		
		searchSourceBuilder.aggregation(aggregation);
		
		searchRequest.source(searchSourceBuilder);
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SearchHits hits = searchResponse.getHits();
		
		Aggregations aggregations = searchResponse.getAggregations();
		Terms by_business_city = aggregations.get("by_business_city");
		Bucket elasticBucket = by_business_city.getBucketByKey("San Francisco"); 
		Avg avg_inspection_scores = elasticBucket.getAggregations().get("avg_inspection_scores"); 
		double avg = avg_inspection_scores.getValue();
		
//		  "aggregations": {
//		    "sterms#by_business_city": {
//		      "doc_count_error_upper_bound": 0,
//		      "sum_other_doc_count": 0,
//		      "buckets": [
//		        {
//		          "key": "San Francisco",
//		          "doc_count": 5,
//		          "avg#avg_inspection_scores": {
//		            "value": 90.8
//		          }
//		        },
//		        {
//		          "key": "San Francisco Whard Restaurant",
//		          "doc_count": 1,
//		          "avg#avg_inspection_scores": {
//		            "value": 56.0
//		          }
//		        }
//		      ]
//		    }
//		  }
		
		
		return searchResponse;
	}

	
	public SearchResponse searchDifferentOperations(String index, String fieldName, String value1, String value2, String operation) {
		
		RestHighLevelClient client = searchClient.getClient();
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		
		
		if(operation.equalsIgnoreCase("between")) {
			
			searchSourceBuilder.query(QueryBuilders.boolQuery()
					.must(QueryBuilders.rangeQuery(fieldName).from(value1).to(value2).includeLower(true).includeUpper(true)));
			
		}
		
		if(operation.equalsIgnoreCase("gte")) {
			
			searchSourceBuilder.query(QueryBuilders.boolQuery()
					.must(QueryBuilders.rangeQuery(fieldName).gte(value1)));
			
		}
		
		if(operation.equalsIgnoreCase("lte")) {
			
			searchSourceBuilder.query(QueryBuilders.boolQuery()
					.must(QueryBuilders.rangeQuery(fieldName).lte(value2)));
			
		}
		
		if(operation.equalsIgnoreCase("exact")) {
			
			searchSourceBuilder.query(QueryBuilders.disMaxQuery().add(QueryBuilders.boolQuery() 
					.must(QueryBuilders.matchQuery(fieldName, value1))));
			
			searchSourceBuilder.query(QueryBuilders.disMaxQuery().add(QueryBuilders.boolQuery() 
					.must(QueryBuilders.rangeQuery("front_id").lte(value2)))); 
			
			System.out.println();
		}
		
		SearchRequest searchRequest = new SearchRequest(index);
		searchRequest.source(searchSourceBuilder);
		
		SearchResponse searchResponse = null;
		
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		SearchHits hits = searchResponse.getHits();
		TotalHits totalHits = hits.getTotalHits();
		
		
		return searchResponse;
	}


	public SearchResponse sqlQueryTesting(String string) {

		RestHighLevelClient client = searchClient.getClient();
		
//		Map<String, Object> json = new HashMap<String, Object>();
//		json.put("query","SELECT business_industry FROM cfg_business_industry_esi");

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		//searchSourceBuilder.query(QueryBuilders.queryStringQuery("SELECT business_industry FROM cfg_business_industry_esi"));

		QueryBuilder qb = QueryBuilders.simpleQueryStringQuery("SELECT business_industry FROM cfg_business_industry_esi");
		searchSourceBuilder.query(qb);

		SearchRequest searchRequest = new SearchRequest(); //Search all indices

		searchRequest.source(searchSourceBuilder);

		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;

		SearchResponse searchResponse = null;

		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}
	
	public SearchResponse andOrQueryTesting(Map<String ,String > inputMap) {

		String field1 = inputMap.get("field1");
		String value1 = inputMap.get("value1");
		String field2 = inputMap.get("field2");
		String value2 = inputMap.get("value2");
		String field3 = inputMap.get("field3");
		String value3 = inputMap.get("value3");

		RestHighLevelClient client = searchClient.getClient();

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 

		QueryBuilder qb = QueryBuilders
				.boolQuery()
				.must(QueryBuilders.matchQuery(field1, value1))
				.should(QueryBuilders.matchQuery(field2, value2))
				.should(QueryBuilders.matchQuery(field3, value3)).minimumShouldMatch(1);
		
		searchSourceBuilder.query(qb);
		
		String[] includeFields = new String[] {"id", field1, field2, field3};
		searchSourceBuilder.fetchSource(includeFields, null);
		
		searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.ASC));

		SearchRequest searchRequest = new SearchRequest(); //Search all indices

		searchRequest.source(searchSourceBuilder);

		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;

		SearchResponse searchResponse = null;

		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}


	public UpdateResponse updateAPITesting(Map<String, String> inputMap) {

		String index = inputMap.get("index");
		String id = inputMap.get("id");
		String field1 = inputMap.get("field1");
		String value1 = inputMap.get("value1");
		String field2 = inputMap.get("field2");
		String value2 = inputMap.get("value2");
		
		
		RestHighLevelClient client = searchClient.getClient();
		
		//XContentBuilder is used to convert string to json
	    XContentBuilder json = null;
		try {
			json = XContentFactory.jsonBuilder()
			        .startObject()
			            .field(field1, value1)
			            .field(field2,value2)
			        .endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.index(index).id(id);
		updateRequest.doc(json);
		
		UpdateResponse response = null;
		try {
		response = client.update(updateRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public SearchResponse andOrDynamicQueryTesting(Map<String ,String > inputMap) {

		List<Integer> lineIds = Arrays.asList(96, 97, 98, 94, 95);
		RestHighLevelClient client = searchClient.getClient();

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		for(Entry<String, String> entry : inputMap.entrySet()) {
			for(Integer lineId : lineIds) {
				boolQueryBuilder
				.should(QueryBuilders
						.boolQuery()
						.must(QueryBuilders.matchQuery("line_id", lineId).operator(Operator.AND))
						.must(QueryBuilders.matchQuery("variable_name", entry.getKey()).operator(Operator.AND))
						.must(QueryBuilders.matchQuery("value", entry.getValue()).operator(Operator.AND))).minimumShouldMatch(1);
			}
		}
		
		searchSourceBuilder.query(boolQueryBuilder);
		String[] includeFields = new String[] {"line_id", "value"};;
		String[] excludeFields = new String[] {"@timestamp", "@version"};
		searchSourceBuilder.fetchSource(includeFields, excludeFields).size(10000);
		searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));

		SearchRequest searchRequest = new SearchRequest("line_single_variable_join_variable_value");
		searchRequest.source(searchSourceBuilder);

		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}
	
	public Map<String, List<Map<String, Object>>> scrollAPITesting(Map<String ,String > inputMap) {

		String indexName = inputMap.get("indexName");
		String fieldName1 = inputMap.get("fieldName1");
		String fieldValue1 = inputMap.get("fieldValue1");
		String fieldName2 = inputMap.get("fieldName2");
		String fieldName3 = inputMap.get("fieldName3");
		
		String[] excludeFields = new String[] {"@timestamp", "@version"};
		String[] includeFields = null;
		
		RestHighLevelClient client = searchClient.getClient();

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		searchSourceBuilder.query(QueryBuilders.matchQuery(fieldName1, fieldValue1));
		searchSourceBuilder.fetchSource(includeFields, excludeFields).size(30);
		searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));
		
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.source(searchSourceBuilder);
		searchRequest.scroll(TimeValue.timeValueMinutes(1));
//		searchRequest.scroll("60s");//Also Valid
//		searchRequest.scroll("1m");//Also Valid
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
			System.out.println("\n\n"+searchResponse+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String scrollId = searchResponse.getScrollId();
		SearchHit[] hits = searchResponse.getHits().getHits();

		Map<String, List<Map<String, Object>>>	sourceMap = new HashMap<>();
		
		int i = 1;
		while(hits != null && hits.length > 0){
			List<Map<String, Object>> listOfMap = new ArrayList<>();
			for(SearchHit hit : hits) {
				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				Map<String, Object> map = new HashMap<>();
				map.put(sourceAsMap.get(fieldName2).toString(), sourceAsMap.get(fieldName3));
				listOfMap.add(map);
			}
			sourceMap.put(scrollId +" - "+i++, listOfMap);
			
			SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
			scrollRequest.scroll(TimeValue.timeValueSeconds(30));
//			scrollRequest.scroll("30s"); //Also Valid
			SearchResponse searchScrollResponse = null;
			try {
				searchScrollResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
			} catch (IOException e) {
				e.printStackTrace();
			}
			scrollId = searchScrollResponse.getScrollId();
			hits = searchScrollResponse.getHits().getHits();
		}
		
		/** The search contexts used by the Search Scroll API are automatically deleted when the scroll times out.
		 * But it is advised to release search contexts as soon as they are not necessary anymore using the Clear Scroll API.*/
		ClearScrollRequest clearScrollRequest = new ClearScrollRequest(); 
		clearScrollRequest.addScrollId(scrollId);
		ClearScrollResponse clearScrollResponse = null;
		try {
			clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean succeeded = clearScrollResponse.isSucceeded();
		if(succeeded)
			return sourceMap;
		else
			return null;
	}
	
//	public Map<String, List<Map<String, Object>>> multiSearchTesting(Map<String ,String > inputMap) {
//		
//		Map<String, List<Map<String, Object>>>	responseMap = new HashMap<>();
//		
//		String indexName1 = inputMap.get("indexName1");
//		String indexName2 = inputMap.get("indexName2");
//		String fieldName1 = inputMap.get("fieldName1");
//		String fieldValue1 = inputMap.get("fieldValue1");
//		String fieldName2 = inputMap.get("fieldName2");
//		String fieldValue2 = inputMap.get("fieldValue2");
//		String fieldName3 = inputMap.get("fieldName3");
//		String fieldValue3 = inputMap.get("fieldValue3");
//		
//		String[] excludeFields = new String[] {"@timestamp", "@version"};
//		String[] includeFields = null;
//		
//		RestHighLevelClient client = searchClient.getClient();
//
//		MultiSearchRequest request = new MultiSearchRequest(); 
//		
//		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
//		searchSourceBuilder.query(QueryBuilders.matchQuery(fieldName1, fieldValue1));
//		searchSourceBuilder.fetchSource(includeFields, excludeFields);
//		searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));
//		searchSourceBuilder.size(100);
//		SearchRequest firstSearchRequest = new SearchRequest(indexName1);
//		firstSearchRequest.source(searchSourceBuilder);
//		firstSearchRequest.scroll(TimeValue.timeValueMinutes(1));
//		request.add(firstSearchRequest);
//		
//		searchSourceBuilder = new SearchSourceBuilder();
//		searchSourceBuilder.query(QueryBuilders.matchQuery(fieldName3, fieldValue3));
//		searchSourceBuilder.fetchSource(includeFields, excludeFields);
//		searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));
//		searchSourceBuilder.size(100);
//		SearchRequest secondSearchRequest = new SearchRequest(indexName2); 
//		secondSearchRequest.source(searchSourceBuilder);
//		secondSearchRequest.scroll(TimeValue.timeValueMinutes(1));
//		request.add(secondSearchRequest);
//		
//		MultiSearchResponse response = null;
//		try {
//			response = client.msearch(request, RequestOptions.DEFAULT);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		MultiSearchResponse.Item firstResponse = response.getResponses()[0];   
//		SearchResponse searchResponse = firstResponse.getResponse();
//		
//		MultiSearchResponse.Item secondResponse = response.getResponses()[1];  
//		searchResponse = secondResponse.getResponse();
//		
//		
//		
//		return responseMap;
//		
//	}
	
	public SearchResultVo multiSearchTesting(Map<String ,String > inputMap) {
		
		SearchResultVo searchResultVo = new SearchResultVo();
		Map<String, List<Map<String, Object>>>	responseMap = new HashMap<>();
		Integer totalHits = 0;
		
		String indexName1 = inputMap.get("indexName1");
		String fieldName1 = inputMap.get("fieldName1");
		String fieldValue1 = inputMap.get("fieldValue1");

		String indexName2 = inputMap.get("indexName2");
		String fieldName2 = inputMap.get("fieldName2");
		String fieldValue2 = inputMap.get("fieldValue2");
		
		String fieldName3 = inputMap.get("fieldName3");
		String fieldValue3 = inputMap.get("fieldValue3");
		

		MultiSearchRequest request = new MultiSearchRequest(); 
		
		String[] includeFields = null;
		SearchRequest firstSearchRequest = queryBuilder(indexName1, fieldName1, fieldValue1, includeFields);
		request.add(firstSearchRequest);
		
		includeFields = null;
		SearchRequest secondSearchRequest = queryBuilder(indexName2, fieldName2, fieldValue2, includeFields);	
		request.add(secondSearchRequest);
		
		RestHighLevelClient client = searchClient.getClient();
		MultiSearchResponse response = null;
		try {
			logger.warn("\n\n\nexecuting multisearch request.......\n\n\n");
			response = client.msearch(request, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MultiSearchResponse.Item firstResponse = response.getResponses()[0];   
		SearchResponse searchResponse = firstResponse.getResponse();
		SearchResultVo firstSearchResult = responseProcessor(searchResponse, indexName1, client);
		totalHits = totalHits + firstSearchResult.getTotalHits();
		responseMap.put(indexName1, firstSearchResult.getSourceMap().get(indexName1));
		
		MultiSearchResponse.Item secondResponse = response.getResponses()[1];  
		searchResponse = secondResponse.getResponse();
		SearchResultVo secondSearchResult = responseProcessor(searchResponse, indexName2, client);
		totalHits = totalHits + secondSearchResult.getTotalHits();
		responseMap.put(indexName2, secondSearchResult.getSourceMap().get(indexName2));
		
		searchResultVo.setTotalHits(totalHits);
		searchResultVo.setSourceMap(responseMap);
		return searchResultVo;
	}
	
	private SearchRequest queryBuilder(String indexName, String fieldName, String fieldValue, String[] includeFields) {
		
		String[] excludeFields = new String[] {"@timestamp", "@version"};
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		searchSourceBuilder.query(QueryBuilders.matchQuery(fieldName, fieldValue));
		searchSourceBuilder.fetchSource(includeFields, excludeFields);
		searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));
		searchSourceBuilder.size(100);
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.source(searchSourceBuilder);
		searchRequest.scroll(TimeValue.timeValueMinutes(1));
		
		return searchRequest;
	}
	
	private SearchResultVo responseProcessor(SearchResponse searchResponse, String indexName, RestHighLevelClient client) {

		SearchResultVo searchResultVo = new SearchResultVo();
		Map<String, List<Map<String, Object>>>	sourceMap = new HashMap<>();
		List<Map<String, Object>> listOfMap = new ArrayList<>();

//		String scrollId = searchResponse.getScrollId();
		SearchHits searchHits = searchResponse.getHits();
		Integer totalHits = (int)searchHits.getTotalHits().value;

		SearchHit[] hits = searchHits.getHits();

//		while(hits != null && hits.length > 0){

			for(SearchHit hit : hits) {
				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				listOfMap.add(sourceAsMap);
			}

//			SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
//			scrollRequest.scroll(TimeValue.timeValueSeconds(30));
//			SearchResponse searchScrollResponse = null;
//			try {
//				searchScrollResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			scrollId = searchScrollResponse.getScrollId();
//			hits = searchScrollResponse.getHits().getHits();
//		}

		sourceMap.put(indexName, listOfMap);
		searchResultVo.setSourceMap(sourceMap);
		searchResultVo.setTotalHits(totalHits);
//
//		ClearScrollRequest clearScrollRequest = new ClearScrollRequest(); 
//		clearScrollRequest.addScrollId(scrollId);
//		ClearScrollResponse clearScrollResponse = null;
//		try {
//			clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		boolean succeeded = clearScrollResponse.isSucceeded();
//		if(succeeded) 
//			return searchResultVo;
//		else 
//			return null;
		return searchResultVo;
	}
	
	
	public SearchResultVo test(Map<String ,String > inputMap) {

		String indexName = inputMap.get("indexName");
		String fieldName1 = inputMap.get("fieldName1");
		String fieldName2 = inputMap.get("fieldName2");
		String fieldName3 = inputMap.get("fieldName3");
		String fieldName4 = inputMap.get("fieldName4");
		String fieldName5 = inputMap.get("fieldName5");
		String searchKey = inputMap.get("value");

		List<Integer> lineHierarchyLowestIdList = Arrays.asList(14, 16, 12, 13, 15);
		List<Integer> companyVariantHierarchyLowestIdList = Arrays.asList(22, 20, 21);
		
		String[] excludeFields = new String[] {"@timestamp", "@version"};
		String[] includeFields = new String[] {"id", "active", "generic_line_hierarchy_id", "universal_line_name",
				"company_variant_hierarchy_id", "generic_line_hierarchy_name", "company_variant_hierarchy_name", "line_description", "line_name"};
		String[] fieldNameArray = new String[] {"generic_line_hierarchy_name", "universal_line_name", "company_variant_hierarchy_name", "line_description", "line_name"};
		
		RestHighLevelClient client = searchClient.getClient();

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		if(searchKey.contains("-") || searchKey.contains("#") || searchKey.contains(" ")) {
			String[] searchKeyArray = searchKey.split("\\-|\\#|\\ ");

			BoolQueryBuilder innerBoolQueryBuilder = QueryBuilders.boolQuery();

			for(String searchKeyValue : searchKeyArray) {
				innerBoolQueryBuilder
				.must(QueryBuilders.multiMatchQuery(searchKeyValue, fieldNameArray).operator(Operator.AND));
			}

			boolQueryBuilder
			.should(QueryBuilders
					.boolQuery()
					.must(QueryBuilders
							.termsQuery("generic_line_hierarchy_id", lineHierarchyLowestIdList))
					.must(QueryBuilders
							.termsQuery("company_variant_hierarchy_id", companyVariantHierarchyLowestIdList))
					.must(QueryBuilders
							.boolQuery()
							.must(innerBoolQueryBuilder
									)));
		}
		
		searchSourceBuilder.query(boolQueryBuilder);
		System.out.println();
		
		
//		searchSourceBuilder.query(QueryBuilders.matchQuery(fieldName1, fieldValue1));
		searchSourceBuilder.fetchSource(includeFields, excludeFields);
		searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));
		searchSourceBuilder.size(10000);
		
		SearchRequest searchRequest = new SearchRequest(indexName);
		searchRequest.source(searchSourceBuilder);
		searchRequest.scroll(TimeValue.timeValueMinutes(1));
		
		RequestOptions COMMON_OPTIONS = RequestOptions.DEFAULT;
		
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, COMMON_OPTIONS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String scrollId = searchResponse.getScrollId();
		SearchHits searchHits = searchResponse.getHits();
		SearchHit[] hits = searchHits.getHits();
		Integer totalHits = (int)searchHits.getTotalHits().value;
		
		SearchResultVo searchResultVo = new SearchResultVo();
		Map<String, List<Map<String, Object>>>	sourceMap = new HashMap<>();
		List<Map<String, Object>> listOfMap = new ArrayList<>();
	
		
		while(hits != null && hits.length > 0){

			for (SearchHit hit : hits) {
				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				listOfMap.add(sourceAsMap);
			}

			sourceMap.put(indexName, listOfMap);
			searchResultVo.setSourceMap(sourceMap);
			
			
			SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
			scrollRequest.scroll(TimeValue.timeValueSeconds(7));
			SearchResponse searchScrollResponse = null;
			try {
				searchScrollResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
			} catch (IOException e) {
				e.printStackTrace();
			}
			scrollId = searchScrollResponse.getScrollId();
			hits = searchScrollResponse.getHits().getHits();

		}
		
		searchResultVo.setTotalHits(totalHits);
		return searchResultVo;
	}

}
