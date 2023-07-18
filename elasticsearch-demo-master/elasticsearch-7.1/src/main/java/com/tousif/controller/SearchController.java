package com.tousif.controller;


import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tousif.model.SearchResultVo;
import com.tousif.service.impl.SearchService;

import io.swagger.annotations.ApiOperation;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;

//	@RequestMapping(value = "/search-all" , method = RequestMethod.POST)
//	public @ResponseBody SearchResponse all(@RequestBody String index, Locale locale, Model model) {
//
//		SearchResponse searchResponse = searchService.searchAll(index);
//		return searchResponse;
//	}
	
	/**
	 * You can have multiple request mappings for a method. For that add one @RequestMapping annotation with a list of values.
	 **/
	@PostMapping(value = {"/search-all", "/search-everything", "/search-all*"})
	public SearchResponse searchAll(){
		SearchResponse searchResponse = searchService.searchAll();
		return searchResponse;
	}
	
//	 http://localhost:8080/elasticsearch-7.1/search/search-index?index=vca_mdm_business_index
	@PostMapping(value = "/search-index")
	@ApiOperation(value = "Search the given index")
	public SearchResponse searchIndex(@RequestParam(value = "index", required = true) String index, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.searchAllWithinIndex(index);
		return searchResponse;
	}
	
//	 http://localhost:8080/elasticsearch-7.1/search/search-field-in-index?index=vca_mdm_business_index&field=state&fieldValue=Delhi
	@PostMapping(value = "/search-field-in-index")
	@ApiOperation(value = "Search the given index in given field for the provided field value")
	public SearchResponse searchFieldInIndex(@RequestParam(value = "index", required = true) String index
			,@RequestParam(value = "field", required = true) String fieldName
			,@RequestParam(value = "fieldValue", required = true) String fieldValue
			,Locale locale, Model model) {
		SearchResponse searchResponse = searchService.searchFieldInIndex(index, fieldName, fieldValue);
		return searchResponse;
	}
	
	@PostMapping(value = "/search-field-in-index-fuzziness")
	public SearchResponse searchFieldInIndexFuzziness(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.searchFieldInIndexFuzziness(inputMap.get("index"), inputMap.get("fieldName"), inputMap.get("fieldValue"));
		return searchResponse;
	}
	
	@PostMapping(value = "/search-options")
	public SearchResponse searchFieldInIndexFuzziness2(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.searchOptions(inputMap.get("index"), inputMap.get("fieldName"), inputMap.get("fieldValue"));
		return searchResponse;
	}
	
	@PostMapping(value = "/requesting-highlighting")
	public SearchResponse RequestingHighlighting(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.requestingHighlighting(inputMap.get("index"), inputMap.get("fieldName"), inputMap.get("fieldValue"));
		return searchResponse;
	}
	
	@PostMapping(value = "/requesting-aggregations")
	public SearchResponse requestingAggregations(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.requestingAggregations(inputMap.get("index"), inputMap.get("fieldName1"), inputMap.get("fieldName2"));
		return searchResponse;
	}
	
	@PostMapping(value = "/search-different-operations")
	public SearchResponse searchDifferentOperations(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.searchDifferentOperations(inputMap.get("index"),
				inputMap.get("fieldName"),
				inputMap.get("value1"),
				inputMap.get("value2"),
				inputMap.get("operation"));
		return searchResponse;
	}
	
	@PostMapping(value = "/sql-query-testing")
	public SearchResponse sqlQueryTesting(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.sqlQueryTesting(inputMap.get("index"));
		return searchResponse;
	}
	
	@PostMapping(value = "/and-or-query-testing")
	public SearchResponse andOrQueryTesting(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse searchResponse = searchService.andOrQueryTesting(inputMap);
		return searchResponse;
	}
	
	@PostMapping(value = "/update-api-testing")
	public UpdateResponse updateAPITesting(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		UpdateResponse response = searchService.updateAPITesting(inputMap);
		return response;
	}
	
	@PostMapping(value = "/and-or-dynamic-query")
	public SearchResponse andOrDynamicQueryTesting(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResponse response = searchService.andOrDynamicQueryTesting(inputMap);
		return response;
	}
	
	@PostMapping(value = "/scroll-api-testing")
	public Map<String, List<Map<String, Object>>> scrollAPITesting(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		Map<String, List<Map<String, Object>>> response = searchService.scrollAPITesting(inputMap);
		return response;
	}
	
	@PostMapping(value = "/multisearch-testing")
	public SearchResultVo multiSearchTesting(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResultVo searchResultVo = searchService.multiSearchTesting(inputMap);
		return searchResultVo;
	}
	
	@PostMapping(value = "/testing")
	public SearchResultVo test(@RequestBody  Map<String ,String > inputMap, Locale locale, Model model) {
		SearchResultVo searchResultVo = searchService.test(inputMap);
		return searchResultVo;
	}
	
	
}
