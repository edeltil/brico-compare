package com.brico.compare.controller;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.brico.compare.entity.Categories;
import com.brico.compare.entity.SimpleProduct;
import com.brico.compare.service.SearchService;

/**
 * Created by edeltil on 15/03/2017.
 */
public class SearchControllerTest {

	@Test
	public void test() throws UnknownHostException {
		int size = 10;
		int page = 1;
		SearchController searchController = new SearchController();
		SearchService searchService = new SearchService();
		Categories categories = new Categories();
		ReflectionTestUtils.setField(searchController, "searchService", searchService);
		ReflectionTestUtils.setField(searchController, "categories", categories);
		List<SimpleProduct> allProducts = searchController.getProducts(Arrays.asList("Jardin", "Abri", "Pergola"), null, null);
		for (int i = size; i < allProducts.size(); i = i + size) {
			List<SimpleProduct> products = searchController.getProducts(Arrays.asList("Jardin", "Abri", "Pergola"), page, size);
			Assert.assertNotNull(products);
			if (i + size > allProducts.size()) {
				Assert.assertTrue(products.size() < 10);
			} else {
				Assert.assertTrue(products.size() == 10);
			}
			page++;
		}

	}

}