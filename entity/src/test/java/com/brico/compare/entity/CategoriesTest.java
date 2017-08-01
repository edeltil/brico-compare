package com.brico.compare.entity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by edeltil on 22/03/2017.
 */

public class CategoriesTest {

	@Test
	public void verify_init() {
		Categories categories = new Categories();
		for (Category category : categories.getCategories()) {
			for (String search : category.getSearchs()) {
				assertTrue("Problem on " + category.getLabel() + " - " + search, category.getLabel().toLowerCase().contains(search.toLowerCase()));
			}
		}
	}

}