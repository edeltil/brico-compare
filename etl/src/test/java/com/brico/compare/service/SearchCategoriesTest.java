package com.brico.compare.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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
import org.junit.Test;

import com.brico.compare.entity.Constants;

/**
 * Created by edeltil on 07/03/2017.
 */
public class SearchCategoriesTest {
	@Test
	public void testCategorie() throws UnknownHostException, ExecutionException, InterruptedException {//Aspirateur et souffleur
		Logger logger = Logger.getLogger("SearchCategoriesTest");
		Client client = new PreBuiltTransportClient(Settings.EMPTY)
			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		logger.info("Search");
		Map<String, Integer> criterias = new HashMap<>();
		criterias.put("description", 2);
		criterias.put("title", 4);
		criterias.put("categorieSeller", 6);
		List<String> searchs = new ArrayList<>();
		searchs.add("mur");
		searchs.add("carrelage");

		Map<String, Integer> mapProducts = new HashMap<>();
		for (String criteria : criterias.keySet()) {
			int index = 0;
			BoolQueryBuilder qb = QueryBuilders.boolQuery();
			for (String search : searchs) {
				qb.must(QueryBuilders.termQuery(criteria, search));
			}
			SearchResponse searchResponse = null;
			do {
				searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.QUERY_THEN_FETCH).setQuery(qb).setFrom(0)
					.setSize(100).setExplain(true).get();
				logger.info(
					"Search  : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits().getMaxScore() + " / " + searchResponse.getHits()
						.getTotalHits());
				for (SearchHit hit : searchResponse.getHits().getHits()) {
					logger.info("Search id : " + hit.getId());
					if (mapProducts.get(hit.getId()) != null) {
						mapProducts.replace(hit.getId(), mapProducts.get(hit.getId()) + criterias.get(criteria));
					} else {
						mapProducts.put(hit.getId(), criterias.get(criteria));
					}
				}
				index += 100;
			} while (index <= searchResponse.getHits().getTotalHits());
		}
		//		BoolQueryBuilder qbTitle = QueryBuilders.boolQuery();
		//		for (String search : searchs) {
		//			qbTitle.must(QueryBuilders.termQuery("title", search));
		//		}
		//
		//		BoolQueryBuilder qbCategorie = QueryBuilders.boolQuery();
		//		for (String search : searchs) {
		//			qbCategorie.must(QueryBuilders.termQuery("categorieSeller", search));
		//		}

		//		int index = 0;
		//
		//		Map<String, Integer> mapProducts = new HashMap<>();
		//		SearchResponse searchResponseDescription = null;
		//		SearchResponse searchResponseTitle = null;
		//		SearchResponse searchResponseCategorie = null;
		//		do {
		//			searchResponseDescription = client.prepareSearch("brico").setTypes("product").setSearchType(SearchType.QUERY_THEN_FETCH).setQuery(qbDescription)
		//				.setFrom(0).setSize(100).setExplain(true).get();
		//			logger.info(
		//				"Search Description : " + searchResponseDescription.getHits().getHits().length + " / " + searchResponseDescription.getHits().getMaxScore()
		//					+ " / " + searchResponseDescription.getHits().getTotalHits());
		//			for (SearchHit hit : searchResponseDescription.getHits().getHits()) {
		//				logger.info("SearchDescription id : " + hit.getId());
		//				if (mapProducts.get(hit.getId()) != null) {
		//					mapProducts.replace(hit.getId(), mapProducts.get(hit.getId()) + 2);
		//				} else {
		//					mapProducts.put(hit.getId(), 2);
		//				}
		//			}
		//			index += 100;
		//		} while (index <= searchResponseDescription.getHits().getTotalHits());
		//		do {
		//			searchResponseTitle = client.prepareSearch("brico").setTypes("product").setSearchType(SearchType.QUERY_THEN_FETCH).setQuery(qbTitle).setFrom(0)
		//				.setSize(100).setExplain(true).get();
		//			logger.info("Search Title : " + searchResponseTitle.getHits().getHits().length + " / " + searchResponseTitle.getHits().getMaxScore() + " / "
		//				+ searchResponseTitle.getHits().getTotalHits());
		//			for (SearchHit hit : searchResponseTitle.getHits().getHits()) {
		//				logger.info("SearchTitle id : " + hit.getId());
		//				if (mapProducts.get(hit.getId()) != null) {
		//					mapProducts.replace(hit.getId(), mapProducts.get(hit.getId()) + 4);
		//				} else {
		//					mapProducts.put(hit.getId(), 4);
		//				}
		//			}
		//		} while (index <= searchResponseTitle.getHits().getTotalHits());
		//		do {
		//			searchResponseCategorie = client.prepareSearch("brico").setTypes("product").setSearchType(SearchType.QUERY_THEN_FETCH).setQuery(qbCategorie)
		//				.setFrom(0).setSize(100).setExplain(true).get();
		//			logger.info(
		//				"Search Categorie : " + searchResponseCategorie.getHits().getHits().length + " / " + searchResponseCategorie.getHits().getMaxScore() + " / "
		//					+ searchResponseCategorie.getHits().getTotalHits());
		//
		//			for (SearchHit hit : searchResponseCategorie.getHits().getHits()) {
		//				logger.info("Search Categorie id : " + hit.getId());
		//				if (mapProducts.get(hit.getId()) != null) {
		//					mapProducts.replace(hit.getId(), mapProducts.get(hit.getId()) + 6);
		//				} else {
		//					mapProducts.put(hit.getId(), 6);
		//				}
		//			}
		//		} while (index <= searchResponseCategorie.getHits().getTotalHits());
		Map<String, Integer> sortedMap = sortByValue(mapProducts);
		for (String hit : sortedMap.keySet()) {
			GetResponse getResponse = client.prepareGet(Constants.INDEX_ELASTIC, Constants.TYPE_ELASTIC, hit).get();
			logger.info("GET : " + getResponse.getSourceAsString() + " - " + sortedMap.get(hit));
		}

	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		//    Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/

		return sortedMap;
	}
}
