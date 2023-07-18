/*package com.cordis.vca.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.ClearScrollResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cordis.vca.search.client.SearchClient;
import com.cordis.vca.search.constants.Constants;
import com.cordis.vca.search.service.GenericVariableValueSearchService;
import com.cordis.vca.search.vo.GenericVariableValueSearchVo;
import com.cordis.vca.search.vo.SearchOperationVo;
import com.cordis.vca.search.vo.SearchResultVo;

*//**
 * @author DOMAIN\md.tousif
 * @date 03-Sep-2019 1:38:26 PM
 *//*
@Component
public class GenericVariableValueSearchServiceImpl implements GenericVariableValueSearchService {

	@Autowired
	private SearchClient searchClient;
	
	private static final Logger logger = LoggerFactory.getLogger(GenericVariableValueSearchServiceImpl.class);
	
	@Override
	public Map<String, Object> genericVariableValueSearch(GenericVariableValueSearchVo genericVariableValueSearchVo) {
		
		Map<String, Object> responseMap = new HashMap<>();

		if (genericVariableValueSearchVo == null) {
			logger.info("input is null...");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"input is null");
			return responseMap;
		}
		if (genericVariableValueSearchVo.getBaseTable() == null || genericVariableValueSearchVo.getBaseTable().trim().isEmpty()) {
			logger.info("BaseTable Name is null or empty...");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"BaseTable Name is null");
			return responseMap;
		}
		if (genericVariableValueSearchVo.getExpression() == null || genericVariableValueSearchVo.getExpression().trim().isEmpty()) {
			logger.info("Expression is null or empty...");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"Expression is null or empty...");
			return responseMap;
		}
		if (genericVariableValueSearchVo.getFilterMap() == null || genericVariableValueSearchVo.getFilterMap().isEmpty()) {
			logger.info("FilterMap is null or empty...");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"FilterMap is null or empty...");
			return responseMap;
		}
		
		String baseTable = genericVariableValueSearchVo.getBaseTable().trim();
		baseTable = convertCamelCaseToUnderScoreFormat(baseTable);
		
		String infixExpression = genericVariableValueSearchVo.getExpression().trim();
		String[] postfixExpressionArray = infixToPostfix(infixExpression).trim().split("\\s");
//		List<String> postfixExpressionArrayList = Arrays.asList(postfixExpressionArray);
		
		List<String> expressionVariableArrayList = Arrays.asList(expressionVariables(postfixExpressionArray));
		
		Map<String, SearchOperationVo> filter = genericVariableValueSearchVo.getFilterMap();
		for(String variable : expressionVariableArrayList) {
			if(!filter.containsKey(variable)) {
				logger.info("FilterMap doesn't contain variable "+variable+"...");
				responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE,"FilterMap doesn't contain variable "+variable+"...");
				return responseMap;	
			}
		}
	
		String sortByFieldName = genericVariableValueSearchVo.getSortedColumn() == null || genericVariableValueSearchVo.getSortedColumn().trim().isEmpty()
				? "" : genericVariableValueSearchVo.getSortedColumn().trim();
		
		Map<String, Object> expressionQueryResponseMap = expressionQueryBuilder(baseTable, sortByFieldName, postfixExpressionArray, filter);
		
		if(expressionQueryResponseMap.get(Constants.STATUS).equals(Constants.STATUS_SUCCESS)){
			responseMap.put(Constants.STATUS,Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE,"records found");
			responseMap.put(Constants.SEARCH_RESULT_VO, expressionQueryResponseMap.get(Constants.SEARCH_RESULT_VO));
		}else {
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,expressionQueryResponseMap.get(Constants.MESSAGE));
		}
		
		return responseMap;
	}

	Map<String, Object> expressionQueryBuilder(String indexName, String sortByFieldName ,String[] postfixExpressionArray, Map<String, SearchOperationVo> filter) {

		Map<String, Object> responseMap = new HashMap<>();
		
		Map<String, BoolQueryBuilder> variableMapBoolQuery = new HashMap<>();
		
		for(Entry<String, SearchOperationVo> filterKeyValue : filter.entrySet()) {
			
			String key = filterKeyValue.getKey();
			SearchOperationVo searchOperation = filterKeyValue.getValue();

			String operation = searchOperation.getOperation() == null ? "" : searchOperation.getOperation().trim().toUpperCase();
			String fieldName = searchOperation.getFieldName() == null ? "" : searchOperation.getFieldName().trim();
			String fieldValue = searchOperation.getFieldValue() == null ? "" : searchOperation.getFieldValue().toString().trim();
			String lowerValue = searchOperation.getLowerValue() == null ? "" : searchOperation.getLowerValue().toString().trim();
			String upperValue = searchOperation.getUpperValue() == null ? "" : searchOperation.getUpperValue().toString().trim();

			if (operation.isEmpty()) {
				logger.info("operation is null or empty...");
				responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE,"operation is null or empty");
				return responseMap;
			}
			if(fieldName.isEmpty()) {
				logger.info("fieldName is null or empty...");
				responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE,"fieldName is null or empty");
				return responseMap;
			}
			fieldName = convertCamelCaseToUnderScoreFormat(fieldName);
			
			BoolQueryBuilder operationQueryBuilder = QueryBuilders.boolQuery();

			switch(operation) {

			case Constants.SEARCH_OPERATION_EXACT :
				
				if(fieldValue.isEmpty()) {
					logger.info("fieldValue is null or empty...");
					responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE,"fieldValue is null or empty...");
					return responseMap;
				}
				
				if(fieldValue.contains("-") || fieldValue.toString().contains("#") || fieldValue.contains(" ")) {
					String[] fieldValueArray = fieldValue.toString().split("\\-|\\#|\\ ");
					for(String value : fieldValueArray) {
						operationQueryBuilder
						.must(QueryBuilders
								.matchQuery(fieldName, value));
					}
				}
				else {
					operationQueryBuilder
					.must(QueryBuilders
							.matchQuery(fieldName, fieldValue));
				}
				
				variableMapBoolQuery.put(key, operationQueryBuilder);
				break;

			case Constants.SEARCH_OPERATION_LIKE :

				if(fieldValue.isEmpty()) {
					logger.info("fieldValue is null or empty...");
					responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE,"fieldValue is null or empty...");
					return responseMap;
				}
				
				operationQueryBuilder
				.must(QueryBuilders.wildcardQuery(fieldName, fieldValue.toLowerCase()+"*"));
				
				variableMapBoolQuery.put(key, operationQueryBuilder);
				break;

			case Constants.SEARCH_OPERATION_LTE :

				if(fieldValue.isEmpty()) {
					logger.info("fieldValue is null or empty...");
					responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE,"fieldValue is null or empty...");
					return responseMap;
				}
				
				operationQueryBuilder
				.must(QueryBuilders
						.rangeQuery(fieldName)
						.lte(fieldValue));
				variableMapBoolQuery.put(key, operationQueryBuilder);
				
				break;

			case Constants.SEARCH_OPERATION_GTE :

				if(fieldValue.isEmpty()) {
					logger.info("fieldValue is null or empty...");
					responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE,"fieldValue is null or empty...");
					return responseMap;
				}
				
				operationQueryBuilder
				.must(QueryBuilders
						.rangeQuery(fieldName)
						.gte(fieldValue));
				variableMapBoolQuery.put(key, operationQueryBuilder);
				break;

			case Constants.SEARCH_OPERATION_BETWEEN :

				if(lowerValue.isEmpty()) {
					logger.info("lowerValue is null or empty...");
					responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE,"lowerValue is null or empty");
					return responseMap;
				}
				if(upperValue.isEmpty()) {
					logger.info("upperValue is null or empty...");
					responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
					responseMap.put(Constants.MESSAGE,"upperValue is null or empty");
					return responseMap;
				}
				
				operationQueryBuilder
				.must(QueryBuilders
						.rangeQuery(fieldName)
						.from(lowerValue)
						.to(upperValue)
						.includeLower(true)
						.includeUpper(true));
				variableMapBoolQuery.put(key, operationQueryBuilder);
				break;

			default :
				logger.info("Invalid operation: " + operation + ".......");
				responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
				responseMap.put(Constants.MESSAGE,"Invalid operation: " + operation);
				return responseMap;
			}
		}
		
		
		Stack<Object> stack = new Stack<>();
		for(String expression : postfixExpressionArray) {

			if(expression.equals("&&")) {
				BoolQueryBuilder boolQuery1 = variableMapBoolQuery.containsKey(stack.peek()) ? variableMapBoolQuery.get(stack.pop()) : (BoolQueryBuilder)stack.pop();
				BoolQueryBuilder boolQuery2 = variableMapBoolQuery.containsKey(stack.peek()) ? variableMapBoolQuery.get(stack.pop()) : (BoolQueryBuilder)stack.pop();
				BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
						.must(boolQuery1)
						.must(boolQuery2);
				stack.push(boolQuery);
			}
			else if(expression.equals("||")) {
				BoolQueryBuilder boolQuery1 = variableMapBoolQuery.containsKey(stack.peek()) ? variableMapBoolQuery.get(stack.pop()) : (BoolQueryBuilder)stack.pop();
				BoolQueryBuilder boolQuery2 = variableMapBoolQuery.containsKey(stack.peek()) ? variableMapBoolQuery.get(stack.pop()) : (BoolQueryBuilder)stack.pop();
				BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
						.should(boolQuery1)
						.should(boolQuery2).minimumShouldMatch(1);
				stack.push(boolQuery);
			}
			else {
				stack.push(expression);
			}
		}
		
		BoolQueryBuilder finalBoolQuery = (BoolQueryBuilder)stack.pop();
		
//		BoolQueryBuilder activeQueryBuilder = QueryBuilders.boolQuery();
//		activeQueryBuilder.must(QueryBuilders
//				.termsQuery(Constants.ACTIVE_FIELD_NAME, true));		
//		boolQueryBuilder.must(activeQueryBuilder);
		
		String[] includeFields = null;
		String[] excludeFields = new String[] {Constants.TIMESTAMP_FIELD_NAME, Constants.VERSION_FIELD_NAME};
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		if(!sortByFieldName.trim().isEmpty())
			searchSourceBuilder.sort(new FieldSortBuilder(sortByFieldName).order(SortOrder.ASC));
		else
			searchSourceBuilder.sort(new FieldSortBuilder(Constants.ID_FIELD_NAME).order(SortOrder.ASC));

		searchSourceBuilder.query(finalBoolQuery).fetchSource(includeFields, excludeFields);
		SearchResultVo searchResult = queryExecutor(indexName, searchSourceBuilder);
		
		responseMap.put(Constants.STATUS,Constants.STATUS_SUCCESS);
		responseMap.put(Constants.SEARCH_RESULT_VO, searchResult);
		return responseMap;
	}
	
	private SearchResultVo queryExecutor(String indexName, SearchSourceBuilder searchSourceBuilder) {
		
		RestHighLevelClient client = searchClient.getClient();
		SearchRequest searchRequest = new SearchRequest();
		searchSourceBuilder.size(10000);
		searchRequest.indices(indexName).source(searchSourceBuilder);
		searchRequest.scroll(TimeValue.timeValueMinutes(1));
		
		SearchResponse searchResponse = null;
		try {
			logger.info("searching "+indexName+".......");
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String scrollId = searchResponse.getScrollId();
		SearchHits searchHits = searchResponse.getHits();
		Integer totalHits = (int)searchHits.getTotalHits().value;
		logger.info(indexName+"'s TotalHits: "+searchHits.getTotalHits()+".......");
		logger.info(indexName+"'s TimeTook: "+searchResponse.getTook()+".......");
		
		SearchHit[] hits = searchHits.getHits();
		
		Map<String, List<Map<String, Object>>>	sourceMap = new HashMap<>();
		
		while(hits != null && hits.length > 0){

			for(SearchHit hit : hits) {
				String index = hit.getIndex();

				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				
				if(sourceMap.containsKey(index)) {
					sourceMap.get(index).add(sourceAsMap);
				}else {
					List<Map<String, Object>> listOfMap = new ArrayList<>();					
					listOfMap.add(sourceAsMap);
					sourceMap.put(index, listOfMap);
				}
					
			}

			SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
			scrollRequest.scroll(TimeValue.timeValueSeconds(30));
			SearchResponse searchScrollResponse = null;
			try {
				searchScrollResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
			} catch (IOException e) {
				e.printStackTrace();
			}
			scrollId = searchScrollResponse.getScrollId();
			hits = searchScrollResponse.getHits().getHits();
		}
		
		SearchResultVo searchResultVo = new SearchResultVo();
		searchResultVo.setSourceMap(sourceMap);
		searchResultVo.setTotalHits(totalHits);
		
		ClearScrollRequest clearScrollRequest = new ClearScrollRequest(); 
		clearScrollRequest.addScrollId(scrollId);
		ClearScrollResponse clearScrollResponse = null;
		try {
			clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean succeeded = clearScrollResponse.isSucceeded();
		logger.info("clearScrollResponse.isSucceeded(): "+succeeded+".......");
		return searchResultVo;
	}
	
	String infixToPostfix(String expression) {
		String result = "";
		String[] expressionArray = expression.split("\\s");

		Stack<String> stack = new Stack<>();

		for(String exp : expressionArray) {

			if(exp.equals("("))
				stack.push(exp);

			else if(exp.equals(")")) {

				while(!stack.isEmpty() && !stack.peek().equals("(")) {
					result += " "+stack.pop();
				}
				if (!stack.isEmpty() && !stack.peek().equals("(")) 
					return "Invalid Expression"; // invalid expression                 
				else
					stack.pop(); 
			} 
			else if(exp.equals("&&") || exp.equals("||")) {
				while(!!stack.isEmpty()) {
					result += " "+stack.pop();
				}
				stack.push(exp);
			}
			else
				result += " "+exp;
		}

		// pop all the operators from the stack 
		while (!stack.isEmpty()){ 
			if(stack.peek().equals("(")) 
				return "Invalid Expression"; 
			result += " "+stack.pop(); 
		} 
		return result;
	}

	String[] expressionVariables(String[] postfixExpressionArray) {
		String expressionVariables = "";
		
		for(String string : postfixExpressionArray) {
			if(!string.equals("&&") && !string.equals("||"))
				expressionVariables += " " + string;
		}
		
		return expressionVariables.trim().split("\\s");
	}
	
	public String convertCamelCaseToUnderScoreFormat(String text) {
		String result="";
		for (int i = 0; i < text.length(); i++) {

			if(Character.isUpperCase(text.charAt(i))){    
				String temp=""+text.charAt(i);
				result=result+"_"+temp.toLowerCase();
			}
			else
				result=result+text.charAt(i);
		}
		return result;
	}

}
*/