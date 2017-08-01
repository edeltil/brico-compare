package com.brico.compare.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.brico.compare.entity.Categories;
import com.brico.compare.entity.Seller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by edeltil on 15/03/2017.
 */
public class CategoryControllerTest {

	private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void test() {
		CategoryController controller = new CategoryController();
		Categories categories = new Categories();
		ReflectionTestUtils.setField(controller, "categories", categories);
		assertNotNull(controller.getCategories(new ArrayList<>()).toString());
		assertNotNull(controller.getCategories(Arrays.asList("Jardin")).toString());
		assertNotNull(controller.getCategories(Arrays.asList("Jardin", "Abri")).toString());
		LOGGER.log(Level.INFO, "Empty : ");
		LOGGER.log(Level.INFO, controller.getCategories(new ArrayList<>()).toString());
		LOGGER.log(Level.INFO, "Jardin : ");
		LOGGER.log(Level.INFO, controller.getCategories(Arrays.asList("Jardin")).toString());
		LOGGER.log(Level.INFO, "Jardin - Abri : ");
		LOGGER.log(Level.INFO, controller.getCategories(Arrays.asList("Jardin", "Abri")).toString());

		List<String> sellers = controller.getSellers();
		assertNotNull(sellers);
		assertEquals(sellers.size(), Seller.values().length);

		for (Seller seller : Seller.values()) {
			assertTrue(seller.name() + " not found.", sellers.contains(seller.getLabel()));
		}
	}

}