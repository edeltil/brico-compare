package com.brico.compare.service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.brico.compare.entity.Product;
import com.brico.compare.entity.SimpleProduct;

/**
 * Created by Akemi on 27/01/2017.
 */
public class SearchServiceTest {
	@Test
	public void testSearch() throws UnknownHostException {
		SearchService searchService = new SearchService();
		List<String> searchs = new ArrayList<>();
		searchs.add("mur");
		searchs.add("carrelage");
		List<SimpleProduct> results = searchService.search(searchs);
		Assert.assertNotNull(results);
	}

	@Test
	public void testJardinAbriSearch() throws UnknownHostException {
		SearchService searchService = new SearchService();
		List<String> searchs = new ArrayList<>();
		searchs.add("jardin");
		searchs.add("abri");
		searchs.add("pergola");
		List<SimpleProduct> results = searchService.search(searchs);
		Assert.assertNotNull(results);
	}

}