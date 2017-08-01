package com.brico.compare.service;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import com.brico.compare.entity.Constants;

/**
 * Created by edeltil on 27/01/2017.
 */
public class MainTest {

//	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
//		Logger logger = Logger.getLogger("MainTest");
//		Client client = new PreBuiltTransportClient(Settings.EMPTY)
//			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
//
//		//		logger.info("Insert");
//		//		XContentBuilder json = XContentFactory.jsonBuilder().startObject().
//		//			field("name", "Deck the Halls").field("year", 1885).field("lyrics", "Fa la la la la").endObject();
//		//		logger.info("Insert : " + json.string());
//		//		//		UpdateRequest updateRequest = new UpdateRequest("music", "songs", "1").doc(json);
//		//
//		//		IndexRequest indexRequest = new IndexRequest("music", "songs", UUID.randomUUID().toString());
//		//		indexRequest.source(json);
//		//		IndexResponse response = client.index(indexRequest).actionGet();
//		//		logger.info("Insert OK " + response.getId());
//		//		client.update(updateRequest).get();
//		logger.info("Search");
//		SearchResponse searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).execute().actionGet();
//		logger.info("Search : " + searchResponse.getHits().getHits().length+" / "+searchResponse.getHits().getMaxScore()+" / "+searchResponse.getHits().getTotalHits());
//		for (SearchHit hit : searchResponse.getHits().getHits()) {
//			logger.info("Search id : " + hit.getId());
//			GetResponse getResponse = client.prepareGet(Constants.INDEX_ELASTIC, Constants.TYPE_ELASTIC, hit.getId()).execute().actionGet();
//			logger.info("GET : " + getResponse.getSourceAsString());
//		}
//	}
}
