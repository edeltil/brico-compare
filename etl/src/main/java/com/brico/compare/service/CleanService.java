package com.brico.compare.service;

import javax.annotation.PreDestroy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Seller;

/**
 * Created by edeltil on 10/02/2017.
 */
public class CleanService {
	private static final Logger LOGGER = Logger.getLogger("CleanService");

	private Seller seller;
	private Client client;

	public CleanService(final Seller seller) throws UnknownHostException {
		client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		this.seller = seller;
	}

	//@Scheduled(cron = "0 20 14 * * *")
	//	@Scheduled(cron = "0 0 3 * * *")
	public void cleanDB() throws IOException, ExecutionException, InterruptedException {
		LOGGER.log(Level.INFO, "------------------------------ CLEAN BEGIN FOR " + seller + " ------------------------------");
		SearchResponse searchResponse;
		do {
			searchResponse = client.prepareSearch(Constants.INDEX_ELASTIC).setTypes(Constants.TYPE_ELASTIC).setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.matchQuery("seller", seller.name())).setFrom(0).setSize(100).setExplain(true).get();
			LOGGER.log(Level.FINE,
				"Search : for " + seller + " : " + searchResponse.getHits().getHits().length + " / " + searchResponse.getHits().getTotalHits());
			for (SearchHit hit : searchResponse.getHits().getHits()) {
				client.prepareDelete().setIndex(Constants.INDEX_ELASTIC).setType(Constants.TYPE_ELASTIC).setId(hit.getId()).get();
			}
		} while (searchResponse.getHits().getTotalHits() != 0);
		LOGGER.log(Level.INFO, "------------------------------ CLEAN END FOR " + seller + " ------------------------------");
	}

	@PreDestroy
	public void clean (){
		client.close();
	}
}
