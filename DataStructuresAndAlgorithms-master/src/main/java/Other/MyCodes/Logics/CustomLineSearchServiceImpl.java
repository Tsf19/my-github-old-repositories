/*package com.cordis.vca.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsRequest;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.ClearScrollResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
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
import com.cordis.vca.search.service.CustomLineSearchService;
import com.cordis.vca.search.vo.FlatTableVo;
import com.cordis.vca.search.vo.CustomLineSearchByFilterVo;
import com.cordis.vca.search.vo.SearchOperationVo;
import com.cordis.vca.search.vo.SearchResultVo;


*//**
 * @author DOMAIN\md.tousif
 * @date 07-May-2019 11:07:03 AM
 *//*
@Component
public class CustomLineSearchServiceImpl implements CustomLineSearchService {

	@Autowired
	private SearchClient searchClient;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomLineSearchServiceImpl.class);
	
	@Override
	public Map<String, Object> customLineSearchByFilter(CustomLineSearchByFilterVo inputVo) {
		
		Map<String, Object> responseMap = new HashMap<>();

		if (inputVo == null) {
			logger.info("input is null...");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"input is null");
			return responseMap;
		}
		if(inputVo.getLineHierarchy().trim().isEmpty()) {
			logger.warn("lineHierarchy is null.......");			
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"lineHierarchy is null");
			return responseMap;
		}
		if(inputVo.getCompanyVariantHierarchy().trim().isEmpty()) {
			logger.warn("companyVariantHierarchy is null.......");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"companyVariantHierarchy is null");
			return responseMap;
		}
		
		*//** ############################################################################
		 * finding cfg_generic_line_hierarchy lowest nodes for particular lineHierarchy*//*
		
		
		String[] includeFields = new String[] { Constants.ID_FIELD_NAME, Constants.LINE_HIERARCHY_NAME_FIELD_NAME,
												Constants.LEVEL_FIELD_NAME, Constants.PARENT_ID_FIELD_NAME,
												Constants.IS_LOWEST_FIELD_NAME,Constants.ACTIVE_FIELD_NAME };
		
		//finding cfg_generic_line_hierarchy records for fields in "includeFields"
		SearchResultVo cfgGenericLineHierarchySearchResult = matchAllGenericQueryBuilder(Constants.CFG_GENERIC_LINE_HIERARCHY_INDEX_NAME, includeFields, null);
		
		//Converting the result into lineHierarchyName-Object Map
		Map<String, Map<String, Object>> lineHierarchyNameMapCfgGenericLineHierarchy = cfgGenericLineHierarchySearchResult
				.getSourceMap()
				.get(Constants.CFG_GENERIC_LINE_HIERARCHY_INDEX_NAME)
				.stream()
				.filter(Objects::nonNull)
				.collect(Collectors
						.toMap(map -> map.get(Constants.LINE_HIERARCHY_NAME_FIELD_NAME).toString(), Function.identity()));
		
		//finding input lineHierarchyId
		String lineHierarchy = inputVo.getLineHierarchy();
		if(!lineHierarchyNameMapCfgGenericLineHierarchy.containsKey(lineHierarchy)) {
			logger.warn("no record exist for "+lineHierarchy+".......");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"no record exist for "+lineHierarchy);
			return responseMap;
		}
		Map<String, Object> lineHierarchyMap = lineHierarchyNameMapCfgGenericLineHierarchy.get(lineHierarchy);
		Integer lineHierarchyId = (Integer) lineHierarchyMap.get(Constants.ID_FIELD_NAME);

		//finding lowest nodes of input lineHierarchy
		List<Integer> lineHierarchyLowestIdList = findLowestHierarchyIds(lineHierarchyId, lineHierarchyNameMapCfgGenericLineHierarchy);
		if(lineHierarchyLowestIdList.isEmpty()) {
			logger.warn("no lineHierarchyLowestId exist");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"no lineHierarchyLowestId exist");
			return responseMap;
		}

		
		*//** #########################################################################################
		 * finding cfg_company_variant_hierarchy lowest nodes for particular companyVariantHierarchy*//*
		
		includeFields = new String[] {	Constants.ID_FIELD_NAME, Constants.CATEGORY_NAME_FIELD_NAME,
										Constants.LEVEL_FIELD_NAME, Constants.PARENT_ID_FIELD_NAME,
										Constants.IS_LOWEST_FIELD_NAME, Constants.ACTIVE_FIELD_NAME };
		
		//finding cfg_company_variant_hierarchy records for fields in "includeFields"
		SearchResultVo cfgCompanyVariantHierarchySearchResult = matchAllGenericQueryBuilder(Constants.CFG_COMPANY_VARIANT_LINE_HIERARCHY_INDEX_NAME, includeFields, null);
		
		//Converting the result into categoryName-Object Map
		Map<String, Map<String, Object>> categoryNameMapCfgCompanyVariantHierarchy = cfgCompanyVariantHierarchySearchResult
				.getSourceMap()
				.get(Constants.CFG_COMPANY_VARIANT_LINE_HIERARCHY_INDEX_NAME)
				.stream()
				.filter(Objects::nonNull)
				.collect(Collectors
						.toMap(map -> map.get(Constants.CATEGORY_NAME_FIELD_NAME).toString(), Function.identity()));
		
		//finding input companyVariantHierarchyId
		String companyVariantHierarchy = inputVo.getCompanyVariantHierarchy();
		if(!categoryNameMapCfgCompanyVariantHierarchy.containsKey(companyVariantHierarchy)) {
			logger.warn("no record exist for "+companyVariantHierarchy+".......");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"no record exist for ");
			return responseMap;
		}
		Map<String, Object> companyVariantHierarchyMap = categoryNameMapCfgCompanyVariantHierarchy.get(companyVariantHierarchy);
		Integer companyVariantHierarchyId = (Integer) companyVariantHierarchyMap.get("id");

		//finding lowest nodes of input companyVariantHierarchy
		List<Integer> companyVariantHierarchyLowestIdList = findLowestHierarchyIds(companyVariantHierarchyId, categoryNameMapCfgCompanyVariantHierarchy);
		if(companyVariantHierarchyLowestIdList.isEmpty()) {
			logger.warn("no companyVariantHierarchyLowestIdList exist");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"no companyVariantHierarchyLowestIdList exist");
			return responseMap;
		}
		
		
		*//** #############################################################################################################
		 * finding customLineIdMapLineName from custom_line for lineHierarchyLowestIdList and companyVariantHierarchyLowestIdList combinations*//*
		
		String searchKey = inputVo.getSearchKey() == null ? "" : inputVo.getSearchKey().trim();
		
		List<SearchOperationVo> searchOperationVos = inputVo.getSearchOperationVos() == null ? Collections.emptyList() : inputVo.getSearchOperationVos();
		
		Map<Integer,Map<String,Object>> customLineIdMapObject = findCustomLineIdMapObject(lineHierarchyLowestIdList, companyVariantHierarchyLowestIdList, searchKey, searchOperationVos);
		
		List<Integer> customLineIds = new ArrayList<>(customLineIdMapObject.keySet());
		
		if(customLineIds.isEmpty()) {
			logger.warn("no customLineIds exist");
			responseMap.put(Constants.STATUS,Constants.STATUS_ERROR);
			responseMap.put(Constants.MESSAGE,"no customLineIds exist");
			return responseMap;
		}
		
		SearchResultVo searchResultVo = new SearchResultVo();
		Map<String, List<Map<String, Object>>>	outputMap = new HashMap<>();
		List<Map<String, Object>> listOfMap = new ArrayList<>();

		// if input filterMap is null, just returning all the customLineIds
		if(inputVo.getFilterMap() == null || inputVo.getFilterMap().isEmpty()) {
			searchResultVo.setTotalHits(customLineIds.size());
			for(Integer customLineId : customLineIds) {
				Map<String, Object> map = new HashMap<>();
				map.put(customLineId.toString(), customLineIdMapObject.get(customLineId));
				listOfMap.add(map);
			}
			outputMap.put(Constants.CUSTOM_LINE_INDEX_NAME, listOfMap);
			searchResultVo.setSourceMap(outputMap);
	
			logger.warn("unfiltered records found...");
			responseMap.put(Constants.STATUS,Constants.STATUS_SUCCESS);
			responseMap.put(Constants.MESSAGE,"unfiltered records found");
			responseMap.put(Constants.SEARCH_RESULT_VO, searchResultVo);
			return responseMap;
		}
		
		*//** ###############################################
		 * Filtering Line ids according to input filterMap*//*
		List<Integer> filteredCustomLineIds = filteringCustomLineQueryExecutor(inputVo.getFilterMap(), customLineIds);
		
		searchResultVo.setTotalHits(filteredCustomLineIds.size());
		
		for(Integer customLineId : filteredCustomLineIds) {
			
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(customLineId.toString(), customLineIdMapObject.get(customLineId));
			listOfMap.add(map);
		}
		outputMap.put(Constants.CUSTOM_LINE_INDEX_NAME, listOfMap);
		searchResultVo.setSourceMap(outputMap);
		
		logger.warn("filtered records found...");
		responseMap.put(Constants.STATUS,Constants.STATUS_SUCCESS);
		responseMap.put(Constants.MESSAGE,"filtered records found");
		responseMap.put(Constants.SEARCH_RESULT_VO, searchResultVo);
		return responseMap;
	}

	
	*//**
	 * @param parentId whose leaf nodes we need to find
	 * @param indexValue from which we need to find leaf nodes
	 * @return
	 *//*
	private List<Integer> findLowestHierarchyIds(Integer parentId, Map<String, Map<String, Object>> indexValue){
		
		List<Integer> lowestIdList = new ArrayList<>();
		//if parentId is itself lowest node, then just return parent id
		for(Entry<String, Map<String, Object>> entry : indexValue.entrySet()) {
			if(entry.getValue().get(Constants.ID_FIELD_NAME).equals(parentId) && (Boolean)entry.getValue().get(Constants.IS_LOWEST_FIELD_NAME)) {
				lowestIdList.add(parentId);
				return lowestIdList;
			}
		}
		
		List<FlatTableVo> flatTableVoList = new ArrayList<>();
		for(Entry<String, Map<String, Object>> entry : indexValue.entrySet()) {
			FlatTableVo flatTableVo = new FlatTableVo(
					(Integer)entry.getValue().get(Constants.ID_FIELD_NAME), 
					(Integer)entry.getValue().get(Constants.PARENT_ID_FIELD_NAME), 
					(Boolean)entry.getValue().get(Constants.IS_LOWEST_FIELD_NAME));
			flatTableVoList.add(flatTableVo);
		}
		
		findLowestHierarchyIdsRec(parentId, flatTableVoList, lowestIdList);
		
		if(!lowestIdList.isEmpty())
			return lowestIdList;
		else
			return Collections.emptyList();
	}
	private void findLowestHierarchyIdsRec(Integer parentId, List<FlatTableVo> flatTableVoList, List<Integer> lowestIdList) {
		List<Integer> childNodesList = new ArrayList<>();
		for(FlatTableVo nodes : flatTableVoList) {
			if(parentId == nodes.getParentId() && !nodes.getIsLowest())
				childNodesList.add(nodes.getId());
			else if(parentId == nodes.getParentId() && nodes.getIsLowest() && !lowestIdList.contains(nodes.getId()))
				lowestIdList.add(nodes.getId());
		}
		if(childNodesList.isEmpty())
			return;
		for(Integer cid : childNodesList) {
			findLowestHierarchyIdsRec(cid, flatTableVoList, lowestIdList);
		}
	}


	*//**
	 * @param lineHierarchyLowestIdList
	 * @param companyVariantHierarchyLowestIdList
	 * @return
	 * 
	 * finding lineIdMapLineName using lineHierarchyLowestIdList and companyVariantHierarchyLowestIdList combinations
	 *//*
	private Map<Integer,Map<String,Object>> findCustomLineIdMapObject(List<Integer> lineHierarchyLowestIdList, List<Integer> companyVariantHierarchyLowestIdList, String searchKey, List<SearchOperationVo> searchOperationVos) {

		RestHighLevelClient client = searchClient.getClient();
		SearchRequest searchRequest = new SearchRequest(); 
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 

		String[] includeFields = new String[] {	Constants.ID_FIELD_NAME, Constants.ACTIVE_FIELD_NAME,
												Constants.GENERIC_LINE_HIERARCHY_ID_FIELD_NAME, Constants.PRODUCER_BUSINESS_ICON_FIELD_NAME,
												Constants.COMPANY_VARIANT_HIERARCHY_ID_FIELD_NAME, Constants.LINE_NAME_FIELD_NAME,
												Constants.GENERIC_LINE_HIERARCHY_NAME_FIELD_NAME, Constants.UNIVERSAL_LINE_NAME_FIELD_NAME,
												Constants.COMPANY_VARIANT_HIERARCHY_NAME_FIELD_NAME, Constants.LINE_DESCRIPTION_FIELD_NAME,
												Constants.LINE_AUDIANCE_FIELD_NAME, Constants.LINE_TYPE_FIELD_NAME,
												Constants.LINE_SELL_TYPE_FIELD_NAME, Constants.TRANSACTIONAL_FIELD_NAME};
		
		String[] excludeFields = new String[] {	Constants.TIMESTAMP_FIELD_NAME, Constants.VERSION_FIELD_NAME};
		
		List<BoolQueryBuilder> boolQueryBuilderList = new ArrayList<>();
		
		BoolQueryBuilder lineHierarchyQueryBuilder = QueryBuilders.boolQuery();
		lineHierarchyQueryBuilder
		.must(QueryBuilders
				.termsQuery(Constants.GENERIC_LINE_HIERARCHY_ID_FIELD_NAME, lineHierarchyLowestIdList));
		boolQueryBuilderList.add(lineHierarchyQueryBuilder);
		
		BoolQueryBuilder companyVariantHierarchyQueryBuilder = QueryBuilders.boolQuery();
		companyVariantHierarchyQueryBuilder
		.must(QueryBuilders
				.termsQuery(Constants.COMPANY_VARIANT_HIERARCHY_ID_FIELD_NAME, companyVariantHierarchyLowestIdList));
		boolQueryBuilderList.add(companyVariantHierarchyQueryBuilder);
		
		BoolQueryBuilder activeQueryBuilder = QueryBuilders.boolQuery();
		activeQueryBuilder.must(QueryBuilders
				.termsQuery(Constants.ACTIVE_FIELD_NAME, true));		
		boolQueryBuilderList.add(activeQueryBuilder);
		
		BoolQueryBuilder searchKeyQueryBuilder = QueryBuilders.boolQuery();
		if(!searchKey.isEmpty()) {	
			String[] fieldsToSearch = new String[] {Constants.LINE_NAME_FIELD_NAME,
					Constants.GENERIC_LINE_HIERARCHY_NAME_FIELD_NAME, Constants.UNIVERSAL_LINE_NAME_FIELD_NAME,
					Constants.COMPANY_VARIANT_HIERARCHY_NAME_FIELD_NAME, Constants.LINE_DESCRIPTION_FIELD_NAME};

			if(searchKey.contains("-") || searchKey.contains("#") || searchKey.contains(" ")) {
				String[] searchKeyArray = searchKey.split("\\-|\\#|\\ ");
				for(String searchKeyValue : searchKeyArray) {
					searchKeyQueryBuilder
					.must(QueryBuilders.multiMatchQuery(searchKeyValue, fieldsToSearch).operator(Operator.AND));
				}
			}
			else {
				searchKeyQueryBuilder.must(QueryBuilders.multiMatchQuery(searchKey, fieldsToSearch));
			}
			boolQueryBuilderList.add(searchKeyQueryBuilder);
		}

		if(!searchOperationVos.isEmpty()) {

			for(SearchOperationVo searchOperation : searchOperationVos) {
				
				String operation = searchOperation.getOperation() == null ? "" : searchOperation.getOperation().trim().toUpperCase();
				String fieldName = searchOperation.getFieldName() == null ? "" : searchOperation.getFieldName().trim();
				String fieldValue = searchOperation.getFieldValue() == null ? "" : searchOperation.getFieldValue().toString().trim();
				String lowerValue = searchOperation.getLowerValue() == null ? "" : searchOperation.getLowerValue().toString().trim();
				String upperValue = searchOperation.getUpperValue() == null ? "" : searchOperation.getUpperValue().toString().trim();

				if (operation.isEmpty() || fieldName.isEmpty())
					continue;
				
				BoolQueryBuilder operationQueryBuilder = QueryBuilders.boolQuery();

				switch(operation) {

				case Constants.SEARCH_OPERATION_EXACT :
					
					if(fieldValue.isEmpty())
						break;
					
					if(fieldValue.toString().contains("-") || fieldValue.toString().contains("#") || fieldValue.toString().contains(" ")) {
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
					
					boolQueryBuilderList.add(operationQueryBuilder);
					break;

				case Constants.SEARCH_OPERATION_LIKE :
					
					if(fieldValue.isEmpty())
						break;
					
					operationQueryBuilder
					.must(QueryBuilders.wildcardQuery(fieldName, fieldValue.toLowerCase()+"*"));
					
					boolQueryBuilderList.add(operationQueryBuilder);
					break;

				case Constants.SEARCH_OPERATION_LTE :

					if(fieldValue.isEmpty())
						break;
					
					operationQueryBuilder
					.must(QueryBuilders
							.rangeQuery(fieldName)
							.lte(fieldValue));
					boolQueryBuilderList.add(operationQueryBuilder);
					
					break;

				case Constants.SEARCH_OPERATION_GTE :

					if(fieldValue.isEmpty())
						break;
					
					operationQueryBuilder
					.must(QueryBuilders
							.rangeQuery(fieldName)
							.gte(fieldValue));
					boolQueryBuilderList.add(operationQueryBuilder);
					break;

				case Constants.SEARCH_OPERATION_BETWEEN :

					if(lowerValue.isEmpty() || upperValue.isEmpty())
						break;
					
					operationQueryBuilder
					.must(QueryBuilders
							.rangeQuery(fieldName)
							.from(lowerValue)
							.to(upperValue)
							.includeLower(true)
							.includeUpper(true));
					boolQueryBuilderList.add(operationQueryBuilder);
					break;

				default :
					logger.info("Invalid operation: " + operation + ".......");
				}
			}
		}

		
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		for(BoolQueryBuilder queryBuilder : boolQueryBuilderList) {
			boolQueryBuilder
			.must(queryBuilder);			
		}
		
		
//		if(searchKey.isEmpty()) {
//			boolQueryBuilder
//			.should(QueryBuilders
//					.boolQuery()
//					.must(QueryBuilders
//							.termsQuery(Constants.GENERIC_LINE_HIERARCHY_ID_FIELD_NAME, lineHierarchyLowestIdList))
//					.must(QueryBuilders
//							.termsQuery(Constants.COMPANY_VARIANT_HIERARCHY_ID_FIELD_NAME, companyVariantHierarchyLowestIdList))
//					.must(QueryBuilders
//							.termsQuery(Constants.ACTIVE_FIELD_NAME, true)))
//			.minimumShouldMatch(1);
//		} 
//		else {
//			boolQueryBuilder
//			.should(QueryBuilders
//					.boolQuery()
//					.must(QueryBuilders
//							.termsQuery(Constants.GENERIC_LINE_HIERARCHY_ID_FIELD_NAME, lineHierarchyLowestIdList))
//					.must(QueryBuilders
//							.termsQuery(Constants.COMPANY_VARIANT_HIERARCHY_ID_FIELD_NAME, companyVariantHierarchyLowestIdList))
//					.must(QueryBuilders
//							.termsQuery(Constants.ACTIVE_FIELD_NAME, true))
//					.must(searchKeyQueryBuilder));
//		}
		
		searchSourceBuilder.query(boolQueryBuilder).fetchSource(includeFields, excludeFields);
		searchSourceBuilder.size(10000);
		searchRequest.indices(Constants.CUSTOM_LINE_INDEX_NAME).source(searchSourceBuilder);
		searchRequest.scroll(TimeValue.timeValueMinutes(1));
		
		SearchResponse searchResponse = null;
		long start = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
		try {
			logger.info("searching "+Constants.CUSTOM_LINE_INDEX_NAME+".......");
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
		System.out.println("\n Latency of firing query" + (end - start) + "ms\n");	//<-------########## Temporary Lines ##########

		
		String scrollId = searchResponse.getScrollId();
		SearchHits searchHits = searchResponse.getHits();
		SearchHit[] hits = searchHits.getHits();
		logger.info(Constants.CUSTOM_LINE_INDEX_NAME+"'s TotalHits: "+searchHits.getTotalHits()+".......");
		logger.info(Constants.CUSTOM_LINE_INDEX_NAME+"'s TimeTook: "+searchResponse.getTook()+".......");
	
		Map<Integer,Map<String,Object>> customLineIdMapObject = new HashMap<>();
		
		start = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
		
		while(hits != null && hits.length > 0) {

			long start2 = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
			
			for (SearchHit hit : hits) {
				Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				if((Boolean) sourceAsMap.get(Constants.ACTIVE_FIELD_NAME)) {
					customLineIdMapObject.put((Integer)sourceAsMap.get(Constants.ID_FIELD_NAME), sourceAsMap);
				}
			}

			long end2 = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
			System.out.println("Latency of while.for()" + (end2 - start2) + "ms");	//<-------########## Temporary Lines ##########
			
			start2 = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
			
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

			end2 = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
			System.out.println("Latency of scroll()" + (end2 - start2) + "ms\n");	//<-------########## Temporary Lines ##########

			
		}
		end = System.currentTimeMillis();	//<-------########## Temporary Lines ##########
		System.out.println("\n Latency of while()" + (end - start) + "ms\n");	//<-------########## Temporary Lines ##########

		return customLineIdMapObject;
	}


	*//**
	 * @param indexName to search
	 * @param includeFields
	 * @param key for map
	 * @return
	 *//*
	private SearchResultVo matchAllGenericQueryBuilder(String indexName, String[] includeFields, String sortByFieldName) {

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
	
		String[] excludeFields = new String[] {Constants.TIMESTAMP_FIELD_NAME, Constants.VERSION_FIELD_NAME};
		
		searchSourceBuilder.query(QueryBuilders
				.termsQuery(Constants.ACTIVE_FIELD_NAME, true)).fetchSource(includeFields, excludeFields);
		
		if(sortByFieldName != null && !sortByFieldName.trim().isEmpty())
			searchSourceBuilder.sort(new FieldSortBuilder(sortByFieldName).order(SortOrder.ASC));
		else
			searchSourceBuilder.sort(new FieldSortBuilder(Constants.ID_FIELD_NAME).order(SortOrder.ASC));
		
		SearchResultVo searchResult = queryExecutor(indexName, searchSourceBuilder);		

		return searchResult;
	}
	
	
	private List<Integer> filteringCustomLineQueryExecutor(Map<String, List<String>> filterMap, List<Integer> customLineIds) {

		String[] includeFields = null;
		String[] excludeFields = new String[] {Constants.TIMESTAMP_FIELD_NAME, Constants.VERSION_FIELD_NAME};
		
		RestHighLevelClient client = searchClient.getClient();
		
		SearchRequest searchRequest = new SearchRequest(); 
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
	
		GetSettingsRequest getSettingRequest = new GetSettingsRequest().indices(Constants.CUSTOM_LINE_EXTENDED_TABLE_INDEX_NAME); 
		getSettingRequest.names("index.max_terms_count");
		getSettingRequest.includeDefaults(true);
		
		GetSettingsResponse getSettingsResponse = null;
		try {
			getSettingsResponse = client.indices().getSettings(getSettingRequest, RequestOptions.DEFAULT);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		Integer maxTermsCount = Integer.valueOf(getSettingsResponse.getSetting(Constants.CUSTOM_LINE_EXTENDED_TABLE_INDEX_NAME, "index.max_terms_count"));
		
		if(maxTermsCount < customLineIds.size()) {
			UpdateSettingsRequest updateSettingRequest = new UpdateSettingsRequest(Constants.CUSTOM_LINE_EXTENDED_TABLE_INDEX_NAME); 
			String settingKey = "index.max_terms_count";
			Settings settings = Settings.builder()
					.put(settingKey, customLineIds.size())
					.build(); 
			updateSettingRequest.settings(settings);
			AcknowledgedResponse updateSettingsResponse = null;
			try {
				updateSettingsResponse = client.indices().putSettings(updateSettingRequest, RequestOptions.DEFAULT);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			boolean acknowledged = updateSettingsResponse.isAcknowledged();
		}
		

		//if value is alphanumeric, convert it to lower
//		Pattern pattern = Pattern.compile("(([A-Z].*[0-9])|([0-9].*[A-Z]))");
//		Matcher matcher = null;
		List<String> values = new ArrayList<>();
		for(Entry<String, List<String>> filter  : filterMap.entrySet()) {
			if(filter.getValue() != null && !filter.getValue().isEmpty())

				for(String value : filter.getValue()) {

					if(value != null && !value.trim().isEmpty() && (value.contains("-") || value.contains("#") || value.contains(" "))) {
						String[] valuesTokens = value.split("\\-|\\#|\\ ");
						for(String token : valuesTokens) {
//							matcher = pattern.matcher(token);
//							if(matcher.find())
//								token = token.toLowerCase();
							values.add(token);
						}
					}
					else if(value != null && !value.trim().isEmpty())

//						matcher = pattern.matcher(value);
//					if(matcher.find())
//						value = value.toLowerCase();
					values.add(value);
				}
		}
		
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		
		BoolQueryBuilder innerBoolQueryBuilder = QueryBuilders.boolQuery();
		
		for(String value : values) {
			innerBoolQueryBuilder.should(QueryBuilders.matchQuery(Constants.VALUE_FIELD_NAME, value).operator(Operator.OR));
		}
		
		boolQueryBuilder
		.should(QueryBuilders
				.boolQuery()
				.must(QueryBuilders.termsQuery(Constants.CUSTOM_LINE_ID_FIELD_NAME, customLineIds))
//				.must(QueryBuilders.termsQuery(Constants.VALUE_FIELD_NAME, values))
				.must(innerBoolQueryBuilder)
				.must(QueryBuilders.termsQuery(Constants.ACTIVE_FIELD_NAME, true))
				);

		searchSourceBuilder.query(boolQueryBuilder).fetchSource(includeFields, excludeFields);
		searchSourceBuilder.size(10000);
		searchSourceBuilder.sort(new FieldSortBuilder(Constants.ID_FIELD_NAME).order(SortOrder.ASC));
		
		searchRequest.indices(Constants.CUSTOM_LINE_EXTENDED_TABLE_INDEX_NAME).source(searchSourceBuilder);
		searchRequest.scroll(TimeValue.timeValueMinutes(1));
		
		SearchResponse searchResponse = null;
		try {
			logger.info("searching "+Constants.CUSTOM_LINE_EXTENDED_TABLE_INDEX_NAME+".......");
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String scrollId = searchResponse.getScrollId();
		SearchHits searchHits = searchResponse.getHits();
		SearchHit[] hits = searchHits.getHits();
		logger.info(Constants.CUSTOM_LINE_EXTENDED_TABLE_INDEX_NAME+"'s TotalHits: "+searchHits.getTotalHits()+".......");
		logger.info(Constants.CUSTOM_LINE_EXTENDED_TABLE_INDEX_NAME+"'s TimeTook: "+searchResponse.getTook()+".......");
		
		//filteredIdListMap to store the idList matching to filterValue
		Map<List<String>, List<Integer>> filteredIdListMap= new HashMap<>();
		
		*//**
		 * initially finalFilteredList stores idList for the first iteration of matched filterValue,
		 * later we will intersect finalFilteredList with filteredIdListMap,
		 * so that only all the common ids in idList of filteredIdListMap will be in finalFilteredList
		 *//*
		List<Integer> finalFilteredList = new ArrayList<>();
		while(hits != null && hits.length > 0){

			for(Entry<String, List<String>> filter : filterMap.entrySet()) {
				
				String filterName = filter.getKey().trim();

				String tableVariableName = null;
				String singlVariableName = null;
				
				if(filterName.contains(".")) {
					String[] split = filterName.split("\\.");
					tableVariableName = split[0].trim();
					singlVariableName = split[1].trim();
				}
				
				List<String> filterValues = filter.getValue();
				List<Integer> filterIdList = new ArrayList<>();

				if(tableVariableName != null && !tableVariableName.isEmpty()) {
					for (SearchHit hit : hits) {
						
						Map<String, Object> sourceAsMap = hit.getSourceAsMap();
						
						if(	sourceAsMap.get(Constants.TABLE_VARIABLE_NAME_FIELD_NAME) != null &&
							sourceAsMap.get(Constants.SINGLE_VARIABLE_NAME_FIELD_NAME) != null &&
							sourceAsMap.get(Constants.VALUE_FIELD_NAME) != null &&
							sourceAsMap.get(Constants.TABLE_VARIABLE_NAME_FIELD_NAME).equals(tableVariableName) &&
							sourceAsMap.get(Constants.SINGLE_VARIABLE_NAME_FIELD_NAME).equals(singlVariableName) &&
							filterValues.contains(sourceAsMap.get(Constants.VALUE_FIELD_NAME))){
							
							filterIdList.add((Integer) sourceAsMap.get(Constants.CUSTOM_LINE_ID_FIELD_NAME));
							
							if(!finalFilteredList.contains((Integer) sourceAsMap.get(Constants.CUSTOM_LINE_ID_FIELD_NAME)))
								finalFilteredList.add((Integer) sourceAsMap.get(Constants.CUSTOM_LINE_ID_FIELD_NAME));
						}
					}					
				}else {
					for (SearchHit hit : hits) {
						Map<String, Object> sourceAsMap = hit.getSourceAsMap();
						
						if(sourceAsMap.get(Constants.SINGLE_VARIABLE_NAME_FIELD_NAME).equals(filterName) &&
								filterValues.contains(sourceAsMap.get(Constants.VALUE_FIELD_NAME))){
							
							filterIdList.add((Integer) sourceAsMap.get(Constants.CUSTOM_LINE_ID_FIELD_NAME));
							
							if(!finalFilteredList.contains((Integer) sourceAsMap.get(Constants.CUSTOM_LINE_ID_FIELD_NAME)))
								finalFilteredList.add((Integer) sourceAsMap.get(Constants.CUSTOM_LINE_ID_FIELD_NAME));
						}
					}
				}
				
				if(!filteredIdListMap.containsKey(filterValues))
					filteredIdListMap.put(filterValues, filterIdList);
				else
					filteredIdListMap.get(filterValues).addAll(filterIdList);
			
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
		
		//intersecting finalFilteredList with all the idList of filteredIdListMap
		for(List<Integer> idList : filteredIdListMap.values()) {
			finalFilteredList.retainAll(idList);
		}
		
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
			return finalFilteredList;
		else
			return Collections.emptyList();
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
}
*/