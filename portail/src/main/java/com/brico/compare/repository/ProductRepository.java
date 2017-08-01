package com.brico.compare.repository;

import javax.annotation.PreDestroy;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.logging.Logger;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Service;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.google.gson.Gson;

/**
 * Created by edeltil on 25/07/2017.
 */
@Service
public class ProductRepository {

	private Logger logger = Logger.getLogger("ProductRepository");

	private Client client = new PreBuiltTransportClient(Settings.EMPTY)
		.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

	public ProductRepository() throws UnknownHostException {
	}

	public Optional<Product> findOne(final String id) {
		GetResponse getResponse = client.prepareGet(Constants.INDEX_ELASTIC, Constants.TYPE_ELASTIC, id).get();
		logger.info("GET : " + getResponse.getSourceAsString() + " - " + id);
		return Optional.ofNullable(new Gson().fromJson(getResponse.getSourceAsString(), Product.class));
	}

	@PreDestroy
	public void clean (){
		client.close();
	}

}
