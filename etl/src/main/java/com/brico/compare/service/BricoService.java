package com.brico.compare.service;

import javax.annotation.PreDestroy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.brico.compare.parser.Parser;
import com.google.gson.Gson;

/**
 * Created by edeltil on 25/01/2017.
 */
public class BricoService {
	private static final Logger LOGGER = Logger.getLogger("BricoService");

	private Client client;

	private Parser parser;

	public BricoService(final Parser parser) throws UnknownHostException {
		this.parser = parser;
		client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
	}

	//@Scheduled(cron = "0 40 14 * * *")
	//	@Scheduled(cron = "0 0 4 * * *")
	public void populateProducts() throws IOException {
		LOGGER.log(Level.INFO, "------------------------------ POPULATE BEGIN FOR " + parser.getClass().getSimpleName() + " ------------------------------");
		List<Product> products = parser.parseDirectory();
		for (Product product : products) {
			IndexRequest indexRequest = new IndexRequest(Constants.INDEX_ELASTIC, Constants.TYPE_ELASTIC, product.getId());
			indexRequest.source(new Gson().toJson(product));
			IndexResponse response = client.index(indexRequest).actionGet();
			LOGGER.log(Level.FINE, "Insert OK " + response.getId());
		}
		LOGGER.log(Level.INFO, "------------------------------ POPULATE END FOR " + parser.getClass().getSimpleName() + " ------------------------------");
	}

	@PreDestroy
	public void clean (){
		client.close();
	}
}
