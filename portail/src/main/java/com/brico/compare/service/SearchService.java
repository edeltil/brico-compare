package com.brico.compare.service;

import javax.annotation.PreDestroy;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Service;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.SimpleProduct;
import com.google.gson.Gson;

/**
 * Created by Akemi on 27/01/2017.
 */
@Service
public class SearchService {

	private Client client;
	private Logger logger = Logger.getLogger("SearchService");

	private Map<String, Integer> criterias = new HashMap<>();

	public SearchService() throws UnknownHostException {
		client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

		criterias.put("description", 40);
		criterias.put("title", 60);
		criterias.put("categorieSeller", 20);
	}

	public List<SimpleProduct> search(List<String> searchs) {
		Map<String, Integer> mapProducts = new HashMap<>();
		for (String criteria : criterias.keySet()) {

			int countCriteria = 0;
			for (String search : searchs) {
				int index = 0;
				BoolQueryBuilder qb = QueryBuilders.boolQuery();
				qb.must(QueryBuilders.termQuery(criteria, search));
				SearchResponse searchResponse;
				do {
					searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.QUERY_THEN_FETCH)
						.setQuery(qb).setFrom(0).setSize(100).setExplain(true).get();
					logger.info(
						"Search for " + criteria + " with" + qb.must() + " : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits()
							.getMaxScore() + " / " + searchResponse.getHits().getTotalHits());
					for (SearchHit hit : searchResponse.getHits().getHits()) {
						if (mapProducts.get(hit.getId()) != null) {
							mapProducts.replace(hit.getId(), mapProducts.get(hit.getId()) + criterias.get(criteria) * countCriteria * 10);
						} else {
							mapProducts.put(hit.getId(), criterias.get(criteria) * countCriteria * 10);
						}
					}
					index += 100;

				} while (index <= searchResponse.getHits().getTotalHits());
				countCriteria++;
			}
		}
		for (String criteria : criterias.keySet()) {
			BoolQueryBuilder qb = QueryBuilders.boolQuery();
			int countCriteria = 0;
			for (String search : searchs) {
				int index = 0;
				qb.must(QueryBuilders.termQuery(criteria, search));
				SearchResponse searchResponse;
				do {
					searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.QUERY_THEN_FETCH)
						.setQuery(qb).setFrom(0).setSize(100).setExplain(true).get();
					logger.info(
						"Search for " + criteria + " with" + qb.must() + " : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits()
							.getMaxScore() + " / " + searchResponse.getHits().getTotalHits());
					for (SearchHit hit : searchResponse.getHits().getHits()) {
						if (mapProducts.get(hit.getId()) != null) {
							mapProducts.replace(hit.getId(), mapProducts.get(hit.getId()) + criterias.get(criteria) * countCriteria);
						} else {
							mapProducts.put(hit.getId(), criterias.get(criteria) * countCriteria);
						}
					}
					index += 100;

				} while (index <= searchResponse.getHits().getTotalHits());
				countCriteria++;
			}
		}
		Map<String, Integer> sortedMap = sortByValue(mapProducts);
		List<SimpleProduct> products = new ArrayList<>();
		for (String hit : sortedMap.keySet()) {
			GetResponse getResponse = client.prepareGet(Constants.INDEX_ELASTIC, Constants.TYPE_ELASTIC, hit).get();
			logger.info("GET : " + getResponse.getSourceAsString() + " - " + sortedMap.get(hit));
			products.add(new Gson().fromJson(getResponse.getSourceAsString(), SimpleProduct.class));
		}
		return products;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());
		// 2. Sort list with Collections.sort(), provide a custom Comparator
		//    Try switch the o1 o2 position for a different order
		Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
		// 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	@PreDestroy
	public void clean (){
		client.close();
	}
}
