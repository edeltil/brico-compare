package com.brico.compare.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by edeltil on 25/07/2017.
 */
public class SimpleProductTest {

	@Test
	public void test() {
		SimpleProduct product = new SimpleProduct();
		assertNotNull(product);
		assertNotNull(product.getId());
		product.setRate(3);
		product.setImage("image");
		product.setShortDescription("shortDescription");
		product.setSeller("seller");
		product.setOldPrice(new Double("20.3"));
		product.setPrice(new Double("3.6"));
		product.setTitle("title");

		assertEquals(3, product.getRate());
		assertEquals("image", product.getImage());
		assertEquals("shortDescription", product.getShortDescription());
		assertEquals("seller", product.getSeller());
		assertEquals(new Double("20.3"), product.getOldPrice());
		assertEquals(new Double("3.6"), product.getPrice());
		assertEquals("title", product.getTitle());

		assertTrue("Problem on id", product.toString().contains(product.getId()));
		assertTrue("Problem on image", product.toString().contains(product.getImage()));
		assertTrue("Problem on seller", product.toString().contains(product.getSeller()));
		assertTrue("Problem on short description", product.toString().contains(product.getShortDescription()));
		assertTrue("Problem on title", product.toString().contains(product.getTitle()));
		assertTrue("Problem on old price", product.toString().contains(product.getOldPrice().toString()));
		assertTrue("Problem on price", product.toString().contains(product.getPrice().toString()));
		assertTrue("Problem on rate", product.toString().contains(String.valueOf(product.getRate())));
	}

}