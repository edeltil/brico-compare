package com.brico.compare.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import com.brico.compare.entity.Constants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by edeltil on 21/02/2017.
 */
public class SearchTest {

	@Test
	public void search() throws UnknownHostException {
		Logger logger = Logger.getLogger("CleanService");
		Client client = new PreBuiltTransportClient(Settings.EMPTY)
			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		logger.info("Search");
		SearchResponse searchResponse = null;
		searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setFrom(0).setSize(100)
			.setExplain(true).get();
		logger.info("Search : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits().getMaxScore() + " / " + searchResponse.getHits()
			.getTotalHits());
		FileWriter fw;
		List<String> categories = new ArrayList<>();
		try {
			fw = new FileWriter(new File("C:/_tmp/perso/categories.txt"));
			int index = 0;
			do {
				//			searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).execute().actionGet();
				searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
					//				.setQuery(QueryBuilders.termQuery("multi", "test"))                 // Query
					//				.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
					.setFrom(index).setSize(100).setExplain(true).get();
				logger.info(
					"Search : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits().getMaxScore() + " / " + searchResponse.getHits()
						.getTotalHits());

				for (SearchHit hit : searchResponse.getHits().getHits()) {
					logger.info("Search id : " + hit.getId());
					GetResponse getResponse = client.prepareGet(Constants.INDEX_ELASTIC, Constants.TYPE_ELASTIC, hit.getId()).execute().actionGet();
					logger.info("GET : " + getResponse.getSourceAsString());
					JsonObject product = new JsonParser().parse(getResponse.getSourceAsString()).getAsJsonObject();

					if (product.get("categorieSeller") != null && !categories.contains(product.get("categorieSeller").getAsString())) {
						fw.append(product.get("seller").getAsString() + ";");
						categories.add(product.get("categorieSeller").getAsString());
						fw.append(product.get("categorieSeller").getAsString().replace(" - ", ";"));
						fw.append(System.lineSeparator());
					}
				}
				index += 100;
			} while (index <= searchResponse.getHits().getTotalHits());
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testCategorie() throws UnknownHostException, ExecutionException, InterruptedException {//Aspirateur et souffleur
		Logger logger = Logger.getLogger("CleanService");
		Client client = new PreBuiltTransportClient(Settings.EMPTY)
			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		logger.info("Search");
		SearchResponse searchResponse = null;
		searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.QUERY_THEN_FETCH)
			.setQuery(QueryBuilders.matchQuery("seller", "Casto")).setFrom(0).setSize(100).setExplain(true).execute().get();
		logger.info("Search : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits().getMaxScore() + " / " + searchResponse.getHits()
			.getTotalHits());
		List<String> categories = new ArrayList<>();
		int index = 0;
		do {
			//			searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).execute().actionGet();
			searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.matchQuery("seller", "Casto")).setFrom(0).setSize(100).setExplain(true).execute().get();
			logger.info(
				"Search : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits().getMaxScore() + " / " + searchResponse.getHits()
					.getTotalHits());

			for (SearchHit hit : searchResponse.getHits().getHits()) {
				logger.info("Search id : " + hit.getId());
				GetResponse getResponse = client.prepareGet(Constants.INDEX_ELASTIC, Constants.TYPE_ELASTIC, hit.getId()).execute().actionGet();
				logger.info("GET : " + getResponse.getSourceAsString());
				JsonObject product = new JsonParser().parse(getResponse.getSourceAsString()).getAsJsonObject();

				if (product.get("categorieSeller") != null && !categories.contains(product.get("categorieSeller").getAsString())) {
					categories.add(product.get("categorieSeller").getAsString());
				}
			}
			index += 100;
		} while (index <= searchResponse.getHits().getTotalHits());

	}

	@Test
	public void testSeller() throws UnknownHostException, ExecutionException, InterruptedException {//Aspirateur et souffleur
		Logger logger = Logger.getLogger("testSeller");
		Client client = new PreBuiltTransportClient(Settings.EMPTY)
			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		logger.info("Search");

		SearchResponse searchResponse = null;
		int index = 0;
		do {
			searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.matchQuery("seller", "Casto")).setFrom(0).setSize(100).setExplain(true).get();
			logger.info(
				"Search  : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits().getMaxScore() + " / " + searchResponse.getHits()
					.getTotalHits());
			index += 100;
		} while (index <= searchResponse.getHits().getTotalHits());
	}
}
