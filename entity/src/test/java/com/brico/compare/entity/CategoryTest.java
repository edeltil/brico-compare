package com.brico.compare.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by edeltil on 22/03/2017.
 */
public class CategoryTest {

	@Test
	public void test() {
		Category category = new Category("label", new String[] { "1", "2" });
		assertNotNull(category);
		assertEquals("label",category.getLabel());
		assertNotNull(category.getSearchs());
		assertEquals(2,category.getSearchs().size());
		assertEquals("1",category.getSearchs().get(0));
		assertEquals("2",category.getSearchs().get(1));
	}

}