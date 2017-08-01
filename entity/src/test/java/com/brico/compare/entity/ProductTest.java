package com.brico.compare.entity;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by edeltil on 22/03/2017.
 */
public class ProductTest {

	@Test
	public void test() {
		Product product = new Product();
		assertNotNull(product);
		assertNotNull(product.getId());
		assertNotNull(product.getDate());
		product.setRate(3);
		product.setImage("image");
		product.setPath("path");
		product.setShortDescription("shortDescription");
		product.setSeller("seller");
		product.setCategorieSeller("categorieSeller");
		product.setDescription("description");
		Date date = new Date();
		product.setDate(date);
		product.setOldPrice(new Double("20.3"));
		product.setPrice(new Double("3.6"));
		product.setTitle("title");
		product.setUnit(Constants.UNIT);
		product.setUrl("url");

		assertEquals(3, product.getRate());
		assertEquals("image", product.getImage());
		assertEquals("path", product.getPath());
		assertEquals("shortDescription", product.getShortDescription());
		assertEquals("seller", product.getSeller());
		assertEquals("categorieSeller", product.getCategorieSeller());
		assertEquals("description", product.getDescription());
		assertEquals(date, product.getDate());
		assertEquals(new Double("20.3"), product.getOldPrice());
		assertEquals(new Double("3.6"), product.getPrice());
		assertEquals("title", product.getTitle());
		assertEquals("unit", product.getUnit());
		assertEquals("url", product.getUrl());

		assertTrue("Problem on category seller", product.toString().contains(product.getCategorieSeller()));
		assertTrue("Problem on description", product.toString().contains(product.getDescription()));
		assertTrue("Problem on id", product.toString().contains(product.getId()));
		assertTrue("Problem on image", product.toString().contains(product.getImage()));
		assertTrue("Problem on path", product.toString().contains(product.getPath()));
		assertTrue("Problem on seller", product.toString().contains(product.getSeller()));
		assertTrue("Problem on short description", product.toString().contains(product.getShortDescription()));
		assertTrue("Problem on title", product.toString().contains(product.getTitle()));
		assertTrue("Problem on unit", product.toString().contains(product.getUnit()));
		assertTrue("Problem on url", product.toString().contains(product.getUrl()));
		assertTrue("Problem on date", product.toString().contains(product.getDate().toString()));
		assertTrue("Problem on old price", product.toString().contains(product.getOldPrice().toString()));
		assertTrue("Problem on price", product.toString().contains(product.getPrice().toString()));
		assertTrue("Problem on rate", product.toString().contains(String.valueOf(product.getRate())));
	}

}