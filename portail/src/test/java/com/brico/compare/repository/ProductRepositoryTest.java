package com.brico.compare.repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.brico.compare.entity.SimpleProduct;
import com.brico.compare.service.SearchService;

import static org.junit.Assert.*;

/**
 * Created by edeltil on 25/07/2017.
 */
public class ProductRepositoryTest {

	@Test
	public void test() throws UnknownHostException {
		ProductRepository repository = new ProductRepository();
		assertFalse(repository.findOne("00").isPresent());

//		SearchService searchService = new SearchService();
//		List<String> searchs = new ArrayList<>();
//		searchs.add("mur");
//		searchs.add("carrelage");
//		List<SimpleProduct> results = searchService.search(searchs);
//		Assert.assertNotNull(results);
		assertTrue(repository.findOne("d25849a4-d9c5-489e-89fd-3ab26709fb0f").isPresent());
	}

}